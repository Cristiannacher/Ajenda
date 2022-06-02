import Excepciones.LoadContactsExeception;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class SerializableJsonContactProvider implements IcontactsProvider {
    private LinkedList<Contacto> contactos = new LinkedList<>();
    private File f = new File("Resources/fixero2.txt");

    public void safeContacts() {

        try {
            FileWriter weriter2 = new FileWriter(f);
            Gson gson = new Gson();
            gson.toJson(contactos,weriter2);

        } catch (IOException ioException) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    @Override
    public List<Contacto> loadContacts() throws LoadContactsExeception {
        LinkedList<Contacto> contacts = new LinkedList<>();
        Type listaContactosType = new TypeToken<List<Contacto>>(){}.getType();
        try (FileReader reader = new FileReader(f)) {
            Gson gson = new Gson();
            gson.fromJson(reader,listaContactosType);
        } catch (EOFException eof) {
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        // catch (IOException ioException) {
        // throw new LoadContactsExeception();
        //}
        return contacts;
    }

    @Override
    public void add(Contacto contacto) throws LoadContactsExeception {
        contactos = (LinkedList<Contacto>) loadContacts();
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
                safeContacts();
                break;
            }
        }

    }

    @Override
    public void clean() {
        contactos.clear();
        safeContacts();
    }

}
