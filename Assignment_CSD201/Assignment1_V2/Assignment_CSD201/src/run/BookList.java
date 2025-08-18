package run;

import java.io.*;
import java.util.*;

class BookList {
    Node head;

    class Node {
        Book book;
        Node next;

        Node(Book book) {
            this.book = book;
            next = null;
        }
    }

    // 1.1. Load data from file
    void loadDataFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] bookData = sc.nextLine().split("\\|");
            Book book = new Book(bookData[0].trim(), bookData[1].trim(), Integer.parseInt(bookData[2].trim()), 0,
                    Double.parseDouble(bookData[3].trim()));
            addToEnd(book);
        }
    }

    // 1.2. Input & add to the end
    void addToEnd(Book book) {
        Node newNode = new Node(book);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    // 1.3. Display data
    void displayData() {
        Node currentNode = head;
        System.out.println("code | Title | Quantity | Lended | Price | Value");
        System.out.println("------------------------------------------------");
        while (currentNode != null) {
            Book book = currentNode.book;
            System.out.printf("%s | %s | %d | %d | %.1f | %.1f\n", book.getBcode(), book.getTitle(), book.getQuantity(),
                    book.getLended(), book.getPrice(), book.getPrice() * book.getQuantity());
            currentNode = currentNode.next;
        }
    }

    // 1.4. Save book list to file
    void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        Node currentNode = head;
        while (currentNode != null) {
            writer.write(currentNode.book.toString() + "\n");
            currentNode = currentNode.next;
        }
        writer.close();
    }

    // 1.5. Search by bcode
    Node search(String bcode) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.book.getBcode().equals(bcode)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    // 1.6. Delete by bcode
    void deleteByBcode(String bcode) {
        Node currentNode = head, prev = null;

        if (currentNode != null && currentNode.book.getBcode().equals(bcode)) {
            head = currentNode.next; // Changed head
            return;
        }

        while (currentNode != null && !currentNode.book.getBcode().equals(bcode)) {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            prev.next = currentNode.next;
        }
    }

    // 1.7. Sort by bcode
    void sortByBcode() {
        Node current = head, index = null;
        Book temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.book.getBcode().compareTo(index.book.getBcode()) > 0) {
                        temp = current.book;
                        current.book = index.book;
                        index.book = temp;
                    }

                    index = index.next;
                }

                current = current.next;
            }
        }
    }

    // 1.8. Input & add to beginning
    void addToBeginning(Book book) {
        Node newNode = new Node(book);
        newNode.next = head;
        head = newNode;
    }

    // 1.9. Add after position k
    void addAfterPosition(Book book, int position) {
        Node newNode = new Node(book);
        Node currentNode = head;

        for (int i = 0; i < position; i++) {
            if (currentNode != null) {
                currentNode = currentNode.next;
            }
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    // 1.10. Delete position k
    void deleteAtPosition(int position) {
        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;

        temp.next = next;
    }

}