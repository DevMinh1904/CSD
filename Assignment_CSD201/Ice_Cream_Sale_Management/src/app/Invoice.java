package app;

import java.util.Date;

class Invoice implements Comparable<Invoice>{
    int id;
    Customer customer;
    IceCream iceCream;
    int quantity;
    double totalPrice;
    Date date;
    
    public Invoice(int id, Customer customer, IceCream iceCream, int quantity, double totalPrice, Date date) {
        this.id = id;
        this.customer = customer;
        this.iceCream = iceCream;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", customer=" + customer + ", iceCream=" + iceCream + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", date=" + date + '}';
    }

    @Override
    public int compareTo(Invoice other) {
        return Integer.compare(this.id, other.id);
    }


}
