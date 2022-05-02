import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileContactProvider implements IcontactsProvider{

    private List<Contacto> contactos = new LinkedList<>();
    private File f = new File("resources/fixero.txt");

    public void update(){

    }

    @Override
    public List<Contacto> loadContacts() {
        return null;
    }

    @Override
    public void add(Contacto contacto) {

    }

    @Override
    public void remove(Contacto contacto) {

    }

    @Override
    public void update(Contacto contacot) {

    }
}
