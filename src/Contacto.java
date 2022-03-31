public class Contacto {

    private String name;
    private String number;

   public Contacto(){
   }

    public Contacto (String name, String number){
       this.number = number;
       this.name = name;
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
