
/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { // do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

    // ===========================================================================
    // (2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART=========
    // ===========================================================================
    // ===========================================================================
    /*
     * Khong su dung tieng Viet co dau de viet ghi chu.
     * Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xSource, int xPrice, int xType) {
        // You should write here appropriate statements to complete this function.
        // Create a new Node object
        if (xSource.charAt(0) == 'D') {
            return;
        }
        Node newNode = new Node(new Watermelon(xSource, xPrice, xType));

        // If the list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty
            tail.next = newNode;
            tail = newNode;
        }

        // ----------------------------------------------------------------------
    }

    void addFirst(String xSource, int xPrice, int xType) {
        // You should write here appropriate statements to complete this function.

        // ----------------------------------------------------------------------
    }

    // f2
    public void insert(Node y, int k) {
        // You should write here appropriate statements to complete this function.
        // If the list is empty
        if (head == null) {
            if (k == 0) {
                head = y;
            }
        } else if (k == 0) {
            // If the list is not empty and k is 0
            y.next = head;
            head = y;
        } else {
            // If the list is not empty and k is not 0
            Node current = head;
            int count = 1;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }
            if (current != null) {
                y.next = current.next;
                current.next = y;
            }
        }

        // ----------------------------------------------------------------------
    }

    // f3
    public void removeNodeAtPosition(int position) {
        // You should write here appropriate statements to complete this function.
        // If the list is empty
        if (head == null) {
            return;
        }

        // If the head needs to be removed
        if (position == 0) {
            head = head.next;
            return;
        }

        // Find the previous node of the node to be deleted
        Node previous = head;
        for (int i = 0; previous != null && i < position - 1; i++) {
            previous = previous.next;
        }

        // If position is more than the number of nodes
        if (previous == null || previous.next == null) {
            return;
        }

        // Node temp is the node to be deleted
        // Remove the node
        Node next = previous.next.next;

        previous.next = next; // Unlink the deleted node from the list

        // ----------------------------------------------------------------------
    }

    // f4

    void sortFull() {// sort full
        Node i = head;
        Node j = null;
        Watermelon tmp;
        while (i != null) {
            j = i.next;
            while (j != null) {
                if (i.info.price > j.info.price) {
                    tmp = i.info;
                    i.info = j.info;
                    j.info = tmp;
                }
                j = j.next;
            }
            i = i.next;
        }
    }

    void sortNNumberFirstElement(int N) {
        Node current = head;
        for (int i = 0; i < N && current != null; i++) {
            Node innerCurrent = current.next;
            for (int j = i + 1; j < N && innerCurrent != null; j++) {
                if (current.info.type > innerCurrent.info.type) {
                    Watermelon temp = current.info;
                    current.info = innerCurrent.info;
                    innerCurrent.info = temp;
                }
                innerCurrent = innerCurrent.next;
            }
            current = current.next;
        }
    }

    // f5
    public void deleteLast() {
        // You should write here appropriate statements to complete this function.
        // If the list is empty
        if (head == null) {
            return;
        }

        // If there is only one node in the list
        if (head.next == null) {
            head = null;
            return;
        }

        // If there are more than one nodes in the list
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }

        // Delete the last node
        secondLast.next = null;

        // ----------------------------------------------------------------------
    }

    // f6
    public void deleteFirst() {
        // You should write here appropriate statements to complete this function.

        // If the list is empty
        if (head == null) {
            return;
        }

        // Set the head to the next of the head
        head = head.next;
        // ----------------------------------------------------------------------
    }

    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // ==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Watermelon g;
        Watermelon h;
        g = new Watermelon("G", 2, 3);
        h = new Watermelon("H", 5, 6);
        Node x = new Node(g);
        Node y = new Node(h);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */

        insert(x, 1);
        insert(y, 1);

        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // ==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        removeNodeAtPosition(2);
        removeNodeAtPosition(2);
        
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // ==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        sortNNumberFirstElement(4);
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // ==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        deleteLast();

        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // ==================================================================
    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        deleteFirst();
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
