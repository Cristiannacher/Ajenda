import java.util.LinkedList;
import java.util.List;

public class HardcodedContactsProvider implements IcontactsProvider {

    List<Contacto> contactos = new LinkedList<>();

    public HarcodedContactsProvider() {
        contactos.add(new Contacto(0, "Pepe", "123456789", "C/Bonita", "pepe@gmail.com"));
        contactos.add(new Contacto(1, "Maria", "123456789", "C/Bonita", "pepe@gmail.com"));
        contactos.add(new Contacto(2, "Jose", "123456789", "C/Bonita", "pepe@gmail.com"));
        contactos.add(new Contacto(3, "Cosmin", "123456789", "C/Bonita", "pepe@gmail.com"));
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
    public void update(Contacto contacot) {

    }
}
