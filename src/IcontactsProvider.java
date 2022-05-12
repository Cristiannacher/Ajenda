import Excepciones.LoadContactsExeception;

import java.util.List;
public interface IcontactsProvider {
    List<Contacto> loadContacts() throws LoadContactsExeception;
    void add(Contacto contacto) throws LoadContactsExeception;
    void remove(Contacto contacto) throws LoadContactsExeception;
    void update(Contacto contacot) throws LoadContactsExeception;
    void clean() throws LoadContactsExeception;
}
