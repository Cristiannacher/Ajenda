import java.awt.*;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

    private Contacto contact;
    private List<Contacto> contactos = new LinkedList<Contacto>();
    private IcontactsProvider provider;


    public Agenda(IcontactsProvider provider) {
        this.provider = provider;
    }

    Scanner reader = new Scanner(System.in);

    public List<Contacto> getContactos() {
        return contactos;
    }


    public void addContact(Contacto contact) {
        provider.add(contact);
        contactos = provider.loadContacts();
    }

    public Contacto createContact() {
        String name = "";
        String num = "";
        String adress = "";
        String email = "";
        System.out.println("Nombre del contacto:");
        name = reader.nextLine();
        System.out.println("Numero del contacto:");
        num = reader.nextLine();
        System.out.println("Direccion del contacto:");
        adress = reader.nextLine();
        System.out.println("Gmail del contacto:");
         email= reader.nextLine();

        Contacto t = new Contacto(name, num, adress, email);
        return t;
    }

    public void seeContacts() {
        System.out.println();
        System.out.println("Tus contactos son:");
        if (!contactos.isEmpty()) {
            for (Contacto contact : contactos) {
                System.out.println(contactos.indexOf(contact) + "- " + contact);
            }
            System.out.println();
        } else System.out.println("Tu lista de contactos esta vacia");
    }

    public Contacto getContact(int num) {
        contactos = provider.loadContacts();
        return contactos.get(num);
    }

    public void deleteContact(int num) {
        provider.remove(contactos.get(num));
        contactos = provider.loadContacts();
    }

    public void setSomRandomContacts() {
        provider.add(new Contacto("Aitor Tilla Fina", "687459862","calle","contacto1@gmail.com"));
        provider.add(new Contacto("Elena Nito Delbosque", "69832456","calle","contacto2@gmail.com"));
        provider.add(new Contacto("Alba Sur Ero", "657984324","calle","contacto3@gmail.com"));
        provider.add(new Contacto("Aitor Menta Fuerte","678954235","calle","contacto4@gmail.com"));

        contactos = provider.loadContacts();
    }

    public void clearAgenda() {
        provider.clean();
        contactos = provider.loadContacts();
    }
}

