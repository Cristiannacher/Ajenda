import java.awt.*;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Agenda {

    private Contacto contact;
    private List<Contacto> contactos = new LinkedList<Contacto>();

    String nombresContactosRandom[] = {"", "", "Alba Sur Ero, Aitor Menta Fuerte"};

    public Agenda() {
    }


    public List<Contacto> getContactos() {
        return contactos;
    }

    public void addContact(Contacto contact) {
        System.out.println("You ad a " + contact.getName());
        contactos.add(contact);
    }

    // falta poner que es alfabeticamente
    public void seeContacts() {
        System.out.println();
        for (Contacto contact : contactos) {
            System.out.println(contactos.indexOf(contact) + "- " + contact);
        }
        System.out.println();
    }

    public Contacto getContact(int num) {
        return contactos.get(num);
    }

    public void delete(int num) {
        contactos.remove(num);
    }

    public void setSomRandomContacts() {
        Contacto q = new Contacto("Aitor Tilla Fina", "687459862");
        Contacto w = new Contacto("Elena Nito Delbosque", "69832456");

        contactos.add(q);
        contactos.add(w);
    }

    public void clearAgenda(){
        contactos.clear();
    }
}

