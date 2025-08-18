public class Node {
    Phone info;
    Node next;

    public Node() {
    }

    public Node(Phone inf, Node next) {
        this.info = inf;
        this.next = next;
    }
    public Node(Phone inf) {      
       this(inf,null);
    }
    
}
