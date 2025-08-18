/*
 Assignment 1  - Income tax
 Class ID          : Se1864
 Student ID        : He170232
 Student Name      : Nguyễn Lê Khải
 Due Date          : 15 Februaty 2024
 I declare that this assignment is my own work
 in accordance with FPT Policy.
*/
package ass1;

public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(TaxPayer taxpayer) {
        Node newNode = new Node(taxpayer);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(TaxPayer taxpayer) {
        Node newNode = new Node(taxpayer);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAfter(int position, TaxPayer taxpayer) {
        if (position < 0 || isEmpty()) {
            throw new IllegalArgumentException("Invalid position or empty list");
        }

        Node newNode = new Node(taxpayer);
        Node current = head;
        int count = 0;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            // Insert at the end if position exceeds list size
            insertAtEnd(taxpayer);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public TaxPayer deleteByCode(String code) {
        if (isEmpty()) {
            return null;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.data.code.equals(code)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return null; // Taxpayer not found
        }

        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }

        if (current == tail) {
            tail = previous;
        }

        return current.data;
    }

    public TaxPayer searchByCode(String code) {
        if (isEmpty()) {
            return null;
        }

        Node current = head;
        while (current != null && !current.data.code.equals(code)) {
            current = current.next;
        }

        return current != null ? current.data : null;
    }

    public void displayData() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.printf("%5s%10s%10s%10s%10s\n", "Code","Tax Name","Income","Deduction","Tax");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // bubble sort 
    public void sortList() {
        if (isEmpty() || head.next == null) {
            return; // Nothing to sort
        }

        boolean swapped;
        for (int i = 0; i < length() - 1; i++) {
            swapped = false;
            Node current = head;
            Node next = current.next;

            while (next != null) {
                if (current.data.code.compareTo(next.data.code) > 0) {
                    swapNodes(current, next);
                    swapped = true;
                }
                current = next;
                next = current.next;
            }

            if (!swapped) {
                break; // List already sorted, early termination
            }
        }
    }

    private void swapNodes(Node node1, Node node2) {
        // Swap data and next references of the nodes
        TaxPayer temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;

        Node tempNext = node1.next;
        node1.next = node2.next;
        node2.next = tempNext;
    }

    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public TaxPayer deleteAtPosition(int position) {
    if (isEmpty() || position < 0 || position >= length()) {
        throw new IllegalArgumentException("Invalid position or empty list");
    }

    Node current = head;
    Node previous = null;

    for (int i = 0; i < position; i++) {
        previous = current;
        current = current.next;
    }

    if (previous == null) {
        head = current.next; // Delete head
    } else {
        previous.next = current.next;
    }

    if (current == tail) {
        tail = previous; // Update tail if deleting last node
    }

    return current.data;
}


}
