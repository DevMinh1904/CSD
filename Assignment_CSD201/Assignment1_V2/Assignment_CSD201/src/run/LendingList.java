package run;

import java.util.*;

public class LendingList {
    Node head;

    class Node {
        Lending lending;
        Node next;

        Node(Lending lending) {
            this.lending = lending;
            next = null;
        }
    }

    // 3.1. Input data
    void inputData(Lending lending) {
        Node newNode = new Node(lending);
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

    // 3.2. Display data
    void displayData() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.lending);
            currentNode = currentNode.next;
        }
    }

    // 3.3. Sort by bcode + rcode
    void sortByBcodeAndRcode() {
        Node current = head, index = null;
        Lending temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if ((current.lending.getBcode() + current.lending.getRcode())
                            .compareTo(index.lending.getBcode() + index.lending.getRcode()) > 0) {
                        temp = current.lending;
                        current.lending = index.lending;
                        index.lending = temp;
                    }

                    index = index.next;
                }

                current = current.next;
            }
        }
    }
}