import java.util.Objects;
import java.util.Random;

public class Contacto {

    private int id;
    private String name;
    private String number;
    private String address;
    private String email;

    public Contacto() {
    }

    Random random = new Random();

    public Contacto(String name, String number, String address, String email) {
        this.id = random.nextInt(1000);
        this.number = number;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Contacto(int id, String name, String number, String address, String email) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void chancheName(String name) {
        this.name = name;
    }

    public void chancheNumber(String number) {
        this.number = number;
    }

    public void chancheAdress(String name) {
        this.address = name;
    }

    public void chancheEmail(String name) {
        this.email = name;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CONTACT NAME: " + name +
                " -" +
                "  NUMBER: " + number +
                " -" +
                " ADRESS: " + address +
                " -" +
                " EMAIL: " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return id == contacto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
