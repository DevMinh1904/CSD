import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.getInfo() + " "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;

        for (int i = 0; i < n; i++)
            addLast(a[i], b[i], c[i]);
    }

    void addLast(String xDistrict, int xPrice, int xArea) {
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Create a new node with the given data
        if (xPrice < 0 && xArea < 0) {
            return;
        }
        Node newNode = new Node(new Apartment(xDistrict, xPrice, xArea));

        // If the list is empty, make this new node the head of the list
        if (head == null) {
            head = newNode;
        } else {
            // If the list is not empty, traverse to the end of the list
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Add the new node at the end of the list
            last.next = newNode;
        }

        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
    }

    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // f2: ham addFirst
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Create a new node with the given data
        Node newNode = new Node(new Apartment("Q7", 9, 5));

        // If the list is empty, make this new node the head of the list
        if (head == null) {
            head = newNode;
        } else {
            // If the list is not empty, make the new node's next point to the current head
            newNode.next = head;

            // Make the new node the head of the list
            head = newNode;
        }

        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f3: ham addPos
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Create a new node with the given data
        Node newNode = new Node(new Apartment("Q3", 8, 1));

        // If the list is empty, make this new node the head of the list
        if (head == null) {
            head = newNode;
        } else {
            // If the list is not empty, traverse to the 3rd node in the list
            Node current = head;
            for (int i = 0; i < 3; i++) {
                if (current.next != null) {
                    current = current.next;
                } else {
                    throw new Exception("Cannot add at position 4. List has fewer than 4 elements.");
                }
            }

            // Make the new node's next point to the 4th node
            newNode.next = current.next;

            // Make the 3rd node's next point to the new node
            current.next = newNode;
        }
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f4: removeFirst
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // Make the second node in the list the new head
        head = head.next;
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f5: removeLast
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // If the list has only one node, remove it by setting the head to null
        if (head.next == null) {
            head = null;
        } else {
            // If the list has more than one node, traverse to the second last node in the
            // list
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }

            // Set the second last node's next to null
            current.next = null;
        }
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f6: filter ==> chi giu lai cac node theo yeu cau
    void f6() throws Exception {
        clear();
        loadData(0);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // If the head node does not belong to the "TD" district, remove it
        while (head != null && !head.getInfo().district.equals("TD")) {
            head = head.next;
        }

        // Traverse through the list and remove nodes that do not belong to the "TD"
        // district
        Node current = head;
        while (current != null && current.next != null) {
            if (!current.next.getInfo().district.equals("TD")) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f7: cap nhat theo yeu cau
    void f7() throws Exception {
        clear();
        loadData(0);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // Traverse through the list to find the lowest price
        int minPrice = head.getInfo().price;
        Node current = head.next;
        while (current != null) {
            if (current.getInfo().price < minPrice) {
                minPrice = current.getInfo().price;
            }
            current = current.next;
        }

        // Traverse through the list again and increase the price by 1 for all
        // apartments with the lowest price
        current = head;
        while (current != null) {
            if (current.getInfo().price == minPrice) {
                current.getInfo().price++;
            }
            current=current.next;
        }

        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f8: dao nguoc list
    void f8() throws Exception {
        clear();
        loadData(0);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Initialize three pointers: prev to null, current to head, and next to null
        Node prev = null;
        Node current = head;
        Node next = null;

        // Traverse through the list
        while (current != null) {
            // Store the next node
            next = current.next;

            // Change the next of the current node to prev
            current.next = prev;

            // Move prev and current one step forward
            prev = current;
            current = next;
        }

        // Set the head of the list to prev because current will be null at the end of
        // the list
        head = prev;
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f9: update thong tin theo yeu cau
    void f9() throws Exception {
        clear();
        loadData(0);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // Traverse through the list and update the district of all apartments in "Q2"
        // and "Q9" to "TD"
        Node current = head;
        while (current != null) {
            if (current.getInfo().district.equals("Q2") || current.getInfo().district.equals("Q9")) {
                current.getInfo().district = "TD";
            }
            current = current.next;
        }
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f10: find max
    void f10() throws Exception {
        clear();
        loadData(0);
        String fname = "f10.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // Traverse through the list to find the apartment with the highest price per
        // square meter
        Node current = head;
        Node maxNode = head;
        double maxPricePerSqM = head.getInfo().price / (double) head.getInfo().area;
        while (current.next != null) {
            double pricePerSqM = current.next.getInfo().price / (double) current.next.getInfo().area;
            if (pricePerSqM > maxPricePerSqM) {
                maxPricePerSqM = pricePerSqM;
                maxNode = current.next;
            }
            current = current.next;
        }

        // Remove the maxNode from its current position in the list
        current = head;
        while (current.next != maxNode) {
            current = current.next;
        }
        current.next = current.next.next;

        // Add the maxNode to the head of the list
        maxNode.next = head;
        head = maxNode;
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
