import java.awt.*;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

    private Contacto contact;
    private List<Contacto> contactos = new LinkedList<Contacto>();


    public Agenda() {
    }

    Scanner reader = new Scanner(System.in);

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void addContact(Contacto contact) {
        System.out.println("You ad a " + contact.getName());
        contactos.add(contact);
    }

    public Contacto createContact() {
        String name = "";
        String num = "";
        System.out.println("Nombre del contacto:");
        name = reader.nextLine();
        System.out.println("Numero del contacto:");
        num = reader.nextLine();

        Contacto t = new Contacto(name, num);
        return t;
    }

    // falta poner que es alfabeticamente
    public void seeContacts() {
        System.out.println();
        System.out.println("Tus contactos son:");
        if(!contactos.isEmpty()) {
            for (Contacto contact : contactos) {
                System.out.println(contactos.indexOf(contact) + "- " + contact);
            }
            System.out.println();
        } else System.out.println("Tu lista de contactos esta vacia");
    }

    public Contacto getContact(int num) {
        return contactos.get(num);
    }

    public void deleteContact(int num) {
        contactos.remove(num);
    }

    public void setSomRandomContacts() {
        contactos.add(new Contacto("Aitor Tilla Fina", "687459862"));
        contactos.add(new Contacto("Elena Nito Delbosque", "69832456"));
        contactos.add(new Contacto("Alba Sur Ero", "657984324"));
        contactos.add(new Contacto("Aitor Menta Fuerte","678954235"));


    }

    public void clearAgenda() {
        contactos.clear();
    }
}

