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
            FileWriter writer = new FileWriter(f);
            String contactosToJson = "";
            Gson gson = new Gson();
            for (Contacto contacto : contactos) {
                contactosToJson = gson.toJson(contacto);
                writer.write(contactosToJson);
            }
        } catch (IOException ioException) {
            System.out.println("Algo ha pasao");
        }
    }
// me sigue petando por problemas de librerias y no se solucionarlo
    @Override
    public List<Contacto> loadContacts() {
        LinkedList<Contacto> contacts = new LinkedList<>();
        Type listaContactosType = new TypeToken<List<Contacto>>() {
        }.getType();
        try (FileReader reader = new FileReader(f)) {
            Gson gson = new Gson();
            gson.fromJson(reader, listaContactosType);
        } catch (EOFException eof) {
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
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
