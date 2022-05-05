import Excepciones.LoadContactsExeception;

import java.util.List;
public interface IcontactsProvider {
    List<Contacto> loadContacts() throws LoadContactsExeception;
    void add(Contacto contacto);
    void remove(Contacto contacto);
    void update(Contacto contacot);
    void clean();
}
