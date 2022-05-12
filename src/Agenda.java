import Excepciones.LoadContactsExeception;

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


    public void addContact(Contacto contact) throws LoadContactsExeception {
        provider.add(contact);
        contactos = provider.loadContacts();
    }

    public void update(Contacto contacto) throws LoadContactsExeception{
        provider.update(contacto);
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

    public void seeContacts() throws LoadContactsExeception{
        contactos = provider.loadContacts();
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

        return contactos.get(num);
    }

    public void deleteContact(int num) throws LoadContactsExeception{
        provider.remove(contactos.get(num));
        contactos = provider.loadContacts();
    }

    public void clearAgenda() throws LoadContactsExeception{
        provider.clean();
        contactos = provider.loadContacts();
    }
}

