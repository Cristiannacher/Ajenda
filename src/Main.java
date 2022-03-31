public class Main {


    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        Contacto contacto = new Contacto("Alfredo No Mires","6894328754");
        Contacto contacto2 = new Contacto("Alba Su rero","689456723");
        Contacto contacto3 = new Contacto("Aitor Menta Fuerte","698345781");

        agenda.setSomRandomContacts();
        agenda.seeContacts();

        agenda.addContact(contacto);
        agenda.addContact(contacto2);
        agenda.addContact(contacto3);
        agenda.seeContacts();

        agenda.getContact(3).chancheName("Carlos Moreno Cigala");
        agenda.delete(2);
        agenda.getContact(3).chancheNumber("688888888");
        agenda.seeContacts();

        System.out.println("¿Que quieres hacer?");
        System.out.println("1.- Añadir contacto");

    }

}
