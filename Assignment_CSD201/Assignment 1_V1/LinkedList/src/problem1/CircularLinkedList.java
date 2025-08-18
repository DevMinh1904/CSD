/* Name: 
 Student Code: 
 Purpose: Solve problem 1
 */
package problem1;

public class CircularLinkedList {

    private Node current;

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (current == null) {
            current = newNode;
            newNode.next = newNode; // Points to itself
        } else {
            newNode.next = current.next;
            current.next = newNode;
            current = newNode; // Move current to the new node
        }
    }

    public boolean search(int data) {
        if (current == null) {
            return false;
        }

        Node temp = current;
        do {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        } while (temp != current);

        return false;
    }

    public void delete(int data) {
        if (current == null) {
            return;
        }

        Node temp = current;
        Node prev = null;
        do {
            if (temp.data == data) {
                if (prev != null) {
                    prev.next = temp.next;
                    if (current == temp) {
                        current = prev;
                    }
                } else {
                    // Find the node before current
                    Node beforeCurrent = current;
                    while (beforeCurrent.next != current) {
                        beforeCurrent = beforeCurrent.next;
                    }
                    beforeCurrent.next = current.next;
                    current = beforeCurrent;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != current);
    }

    public void display() {
        if (current == null) {
            return;
        }

        Node temp = current;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != current);
        System.out.println();
    }

    public void step() {
        if (current != null) {
            current = current.next;
        }
    }
}
