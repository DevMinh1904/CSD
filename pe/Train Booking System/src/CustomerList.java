class CustomerList {
    Node head;

    public CustomerList() {
        head = null;
    }

    public void addCustomerToEnd(Customer customer) {
        Node newNode = new Node(customer);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
