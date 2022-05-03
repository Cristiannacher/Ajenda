import java.util.LinkedList;
import java.util.List;

public class HardcodedContactsProvider implements IcontactsProvider {

    List<Contacto> contactos = new LinkedList<>();

    public HardcodedContactsProvider() {
        contactos.add(new Contacto(123, "Pepe", "123456789", "C/Bonita", "pepe@gmail.com"));
        contactos.add(new Contacto(1234, "Maria", "123456789", "C/Bonita", "pepe@gmail.com"));
        contactos.add(new Contacto(12345, "Jose", "123456789", "C/Bonita", "pepe@gmail.com"));
        contactos.add(new Contacto(123456, "Cosmin", "123456789", "C/Bonita", "pepe@gmail.com"));
    }

    @Override
    public List<Contacto> loadContacts() {
        return contactos;
    }

    @Override
    public void add(Contacto contacto) {
        contactos.add(contacto);
    }

    @Override
    public void remove(Contacto contacto) {
        contactos.remove(contacto);
    }

    @Override
    public void update(Contacto newContact) {
        for (Contacto contacto : contactos) {
            if (contacto.equals(newContact)) {
                contactos.set(contactos.indexOf(contacto), newContact);
                break;
            }
        }
    }

    @Override
    public void clean() {
        contactos.clear();

    }
}
