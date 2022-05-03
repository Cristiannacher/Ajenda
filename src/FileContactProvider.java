import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileContactProvider implements IcontactsProvider {

    private List<Contacto> contactos = new LinkedList<>();
    private File f = new File("Resources/fixero.txt");


    public void safeContacts() {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            String linea = "";
            for (Contacto contacto : contactos) {
                linea = (contacto.getId() + "; " + contacto.getName() + " ; " + contacto.getNumber() + " ; " + contacto.getAddress() + " ; " + contacto.getEmail() + "\n");
                output.write(linea);
            }
            output.close();
        } catch (IOException ioException) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    @Override
    public List<Contacto> loadContacts() {
        List<Contacto> contactos = new LinkedList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(f));
            String linea = input.readLine();
            String[] infoContact;
            while (linea != null) {
                infoContact = linea.split(";");
                contactos.add(new Contacto(Integer.parseInt(infoContact[0]),infoContact[1],infoContact[2],infoContact[3],infoContact[4]));
                linea = input.readLine();
            }
            input.close();
        } catch (IOException ioException) {
            System.out.println("No se ha encontrado el archivo");
        }
        return contactos;
    }

    @Override
    public void add(Contacto contacto) {
        contactos.add(contacto);
        safeContacts();
    }

    @Override
    public void remove(Contacto contacto) {
        contactos.remove(contacto);
        safeContacts();
    }

    @Override
    public void update(Contacto newContact) {
        for (Contacto contacto : contactos) {
            if (contacto.equals(newContact)) {
                contactos.set(contactos.indexOf(contacto), newContact);
                break;
            }
        }
        safeContacts();
    }

    @Override
    public void clean() {
        contactos.clear();
        safeContacts();
    }
}
