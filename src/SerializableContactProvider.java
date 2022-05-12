import Excepciones.LoadContactsExeception;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SerializableContactProvider implements IcontactsProvider {
    private List<Contacto> contactos = new LinkedList<>();
    private File f = new File("Resources/fixeroSerializado.obj");

    public void safeContacts() {
        try {
            ObjectOutputStream writer = new ObjectOutputStream((new FileOutputStream(f)));

            for (Contacto contacto : contactos) {
                writer.writeObject(contacto);
            }
            writer.close();
        } catch (IOException ioException) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    @Override
    public List<Contacto> loadContacts() throws LoadContactsExeception {
        List<Contacto> contacts = new LinkedList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(f))) {
            Contacto contacto;
            while (true) {
                contacto = (Contacto) reader.readObject();
                contacts.add(contacto);
            }
        } catch (ClassNotFoundException e) {
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
