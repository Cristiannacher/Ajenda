import Excepciones.LoadContactsExeception;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws LoadContactsExeception {
        boolean si = true;
        int order;
        String name;
        String num;

        Scanner reader = new Scanner(System.in);
        Agenda agenda = null;
        IcontactsProvider provider = new FileContactProvider();
        IcontactsProvider provider1 = new HardcodedContactsProvider();
        IcontactsProvider provider2 = new SerializableContactProvider();
        IcontactsProvider provider3 = new SerializableJsonContactProvider();

        System.out.println("Quieres trabajar con memoria con fixero o serializado? 1 memoria 2 fixero 3 serializado 4 serializadoJson");
        int elige = reader.nextInt();
        boolean elegirBien = true;

        while (elegirBien) {
            if (elige == 1) {
                agenda = new Agenda(provider1);
                break;
            } else if (elige == 2) {
                agenda = new Agenda(provider);
                break;
            } else if (elige == 3) {
                agenda = new Agenda(provider2);
                break;
            } else if (elige == 4) {
                agenda = new Agenda(provider3);
                break;
            } else {
                System.out.println("Cabezon");
            }
        }

        while (si) {
            System.out.println("¿Que quieres hacer?  Elige el  numero de la orden");
            System.out.println();
            System.out.println("1.- Añadir contacto");
            System.out.println("2.- Borrar un contacto");
            System.out.println("3.- Ver los contactos");
            System.out.println("4.- Modificar el nombre de un contacto");
            System.out.println("5.- Modificar el numero de un contacto");
            System.out.println("6.- Modificar la direccion del contacto");
            System.out.println("7.- Modificar el correo del contacto");
            System.out.println("8.- Vaciar agenda");
            System.out.println("9.- NO quiero hacer nada mas");

            agenda.seeContacts();

            order = reader.nextInt();
            reader.nextLine();

            if (order < 10 && order > 0) {
                switch (order) {
                    case 1:
                        agenda.addContact(agenda.createContact());
                        break;
                    case 2:
                        System.out.println("Elige el contacto a borrar");
                        order = reader.nextInt();
                        reader.nextLine();
                        if (order <= agenda.getContactos().size() - 1)
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
                        if (order <= agenda.getContactos().size() - 1) {
                            System.out.println("Nombre del contacto:");
                            name = reader.nextLine();
                            agenda.getContact(order).chancheName(name);
                            agenda.update(agenda.getContact(order));
                        } else System.out.println("Pon un contacto valido cabezon");
                        break;
                    case 5:
                        System.out.println("Elige el contacto a modificar");
                        order = reader.nextInt();
                        reader.nextLine();
                        if (order <= agenda.getContactos().size() - 1) {
                            System.out.println("Numero del contacto:");
                            num = reader.nextLine();
                            agenda.getContact(order).chancheNumber(num);
                            agenda.update(agenda.getContact(order));
                        } else System.out.println("Elige un contacto valido cabezon");
                        break;
                    case 6:
                        System.out.println("Elige el contacto a modificar");
                        order = reader.nextInt();
                        reader.nextLine();
                        if (order <= agenda.getContactos().size() - 1) {
                            System.out.println("Direccion del contacto:");
                            name = reader.nextLine();
                            agenda.getContact(order).chancheAdress(name);
                            System.out.println(name);
                            agenda.update(agenda.getContact(order));
                        } else System.out.println("Elige un contacto valido cabezon");
                        break;
                    case 7:
                        System.out.println("Elige el contacto a modificar");
                        order = reader.nextInt();
                        reader.nextLine();
                        if (order <= agenda.getContactos().size() - 1) {
                            System.out.println("Email del contacto:");
                            name = reader.nextLine();
                            agenda.getContact(order).chancheEmail(name);
                            agenda.update(agenda.getContact(order));
                        } else System.out.println("Elige un contacto valido cabezon");
                        break;
                    case 8:
                        agenda.clearAgenda();
                        break;
                    case 9:
                        si = false;
                        break;
                }

            } else System.out.println("Elige una orden valida cabezon");

        }
    }

}
