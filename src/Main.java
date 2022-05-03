import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean si = true;
        int order = 0;
        String name = "";
        String num = "";

        Scanner reader = new Scanner(System.in);
        FileContactProvider provider = new FileContactProvider();

        Agenda agenda = new Agenda(provider);

        agenda.setSomRandomContacts();

        while (si) {
            System.out.println("¿Que quieres hacer?  Elige el  numero de la orden");
            System.out.println();
            System.out.println("1.- Añadir contacto");
            System.out.println("2.- Borrar un contacto");
            System.out.println("3.- Ver los contactos");
            System.out.println("4.- Modificar el nombre de un contacto");
            System.out.println("5.- Modificar el numero de un contacto");
            System.out.println("6.- Vaciar agenda");
            System.out.println("7.- NO quiero hacer nada mas");

            agenda.seeContacts();

            order = reader.nextInt();
            reader.nextLine();

            if (order <= 7) {
                switch (order) {
                    case 1:
                        agenda.addContact(agenda.createContact());
                        break;
                    case 2:
                        System.out.println("Elige el contacto a borrar");
                        order = reader.nextInt();
                        reader.nextLine();
                        if(order <= agenda.getContactos().size()-1)
                        agenda.deleteContact(order);
                        else System.out.println("Pon un contacto valido cabezon");
                        break;
                    case 3:
                        agenda.seeContacts();
                        break;
                    case 4:
                        System.out.println("Elige el contacto a modificar");
                        order = reader.nextInt();
                        reader.nextLine();
                        if(order <= agenda.getContactos().size()-1) {
                            System.out.println("Nombre del contacto:");
                            name = reader.nextLine();
                            agenda.getContact(order).chancheName(name);
                        } else System.out.println("Pon un contacto valido cabezon");
                        break;
                    case 5:
                        System.out.println("Elige el contacto a modificar");
                        order = reader.nextInt();
                        reader.nextLine();
                        if(order <= agenda.getContactos().size()-1) {
                            System.out.println("Numero del contacto:");
                            num = reader.nextLine();
                            agenda.getContact(order).chancheNumber(num);
                        } else System.out.println("Elige un contacto valido cabezon");
                        break;
                    case 6:
                        agenda.clearAgenda();
                        break;
                    case 7:
                        si = false;
                        break;
                }
            } else System.out.println("Elige una orden valida cabezon");

        }
    }

}
