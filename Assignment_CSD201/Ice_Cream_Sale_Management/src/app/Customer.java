package app;

class Customer implements Comparable<Customer>{
    int id;
    String name;
    String email;
    String phone;

    public Customer(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
    }
}