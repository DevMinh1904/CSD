public class Phone {
   String model;
   double price;

    public Phone() {
    }

    public Phone(String model, double price) {
//        System.out.println(type +" "+model+" "+price);
       
        this.model = model;
        this.price = price;
    }
   public  String toString(){
       return "("+model+" "+(float) price+")";
   }
}
