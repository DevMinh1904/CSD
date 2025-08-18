package app;

class IceCream implements Comparable<IceCream>{
    int id;
    String name;
    String flavor;
    double price;

    public IceCream(int id, String name, String flavor, double price) {
        this.id = id;
        this.name = name;
        this.flavor = flavor;
        this.price = price;
    }

    @Override
    public String toString() {
        return "IceCream{" + "id=" + id + ", name='" + name + '\'' + ", flavor='" + flavor + '\'' + ", price=" + price + '}';
    }
    
     @Override
    public int compareTo(IceCream other) {
        return Integer.compare(this.id, other.id);
    }
}
