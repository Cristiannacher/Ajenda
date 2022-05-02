import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileContactProvider implements IcontactsProvider {

    private List<Contacto> contactos = new LinkedList<>();
    private File f = new File("resources/fixero.txt");


    public void refresh() {
        try {
            FileWriter writer = new FileWriter(f);
            String linea = "";
            for (Contacto contacto : contactos) {
                linea = (contacto.getId() + " ; " + contacto.getName() + " ; " + contacto.getNumber() + " ; " + contacto.getAddress() + " ; " + contacto.getEmail() + "\n");
                writer.write(linea);
            }
        } catch (IOException ioException) {
            System.out.println("Error");
        }

    }

    @Override
    public List<Contacto> loadContacts() {
        return contactos;
    }

    @Override
    public void add(Contacto contacto) {
        contactos.add(contacto);
        refresh();
    }

    @Override
    public void remove(Contacto contacto) {
        for (Contacto contacto1 : contactos) {
            if (contacto1.getId() == contacto.getId()) {
                contactos.remove(contacto1);
            }
        }
        refresh();
    }

    @Override
    public void update(Contacto newContact) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == newContact.getId()) {
                contacto = newContact;
                break;
            }
        }
        refresh();
    }
}
