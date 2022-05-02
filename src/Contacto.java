public class Contacto {

    private int id;
    private String name;
    private String number;
    private String address;
    private String email;

   public Contacto(){
   }

    public Contacto (int id,String name, String number,String address,String email){
       this.id = id;
       this.number = number;
       this.name = name;
       this.address = address;
       this.email = email;

    }

    public int getId() {
        return id;
    }

    public void chancheName (String name){
        this.name = name;
    }

    public void chancheNumber(String number){
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Contact name: "+
                name +
                "  |" +
                "  Number: "+ number;
    }
}
