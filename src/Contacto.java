public class Contacto {

    private String id;
    private String name;
    private String number;
    private String address;
    private String email;

   public Contacto(){
   }

    public Contacto (String id,String name, String number,String address,String email){
       this.id = id;
       this.number = number;
       this.name = name;
       this.address = address;
       this.email = email;

    }

    public String getId() {
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

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact name: "+
                name +
                "  |" +
                "  Number: "+ number +
                " Adress: " + address +
                " Gmail: "+ email;
    }
}
