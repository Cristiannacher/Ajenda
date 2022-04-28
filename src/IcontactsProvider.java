import java.util.List;
public interface IcontactsProvider {
    List<Contacto> loadContacts();
    void add(Contacto contacto);
    void remove(Contacto contacto);
    void update(Contacto contacot);
}
