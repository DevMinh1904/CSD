package run;

import java.io.*;
import java.util.*;

public class ReaderList {
    Node head;

    class Node {
        Reader reader;
        Node next;

        Node(Reader reader) {
            this.reader = reader;
            next = null;
        }
    }

    // 2.1. Load data from file
    void loadDataFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] readerData = sc.nextLine().split("\\|");
            Reader reader = new Reader(readerData[0].trim(), readerData[1].trim(),
                    Integer.parseInt(readerData[2].trim()));
            addToEnd(reader);
        }
    }

    // 2.2. Input & add to the end
    void addToEnd(Reader reader) {
        Node newNode = new Node(reader);
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

    // 2.3. Display data
    void displayData() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.reader);
            currentNode = currentNode.next;
        }
    }

    // 2.4. Save reader list to file
    void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        Node currentNode = head;
        while (currentNode != null) {
            writer.write(currentNode.reader.toString() + "\n");
            currentNode = currentNode.next;
        }
        writer.close();
    }

    // 2.5. Search by rcode
    Node search(String rcode) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.reader.getRcode().equals(rcode)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    // 2.6. Delete by rcode
    void deleteByRcode(String rcode) {
        Node currentNode = head, prev = null;

        if (currentNode != null && currentNode.reader.getRcode().equals(rcode)) {
            head = currentNode.next; // Changed head
            return;
        }

        while (currentNode != null && !currentNode.reader.getRcode().equals(rcode)) {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            prev.next = currentNode.next;
        }
    }
}