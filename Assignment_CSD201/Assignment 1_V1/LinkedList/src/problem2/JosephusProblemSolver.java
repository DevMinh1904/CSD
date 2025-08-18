/* Name: 
 Student Code: 
 Purpose: Solve problem 2 josephus problem 
 */
package problem2;

import java.util.*;

class Person {

    int number;
    Person next;

    public Person(int number) {
        this.number = number;
    }
}

class CircularLinkedList {

    private Person head;

    // Initialize the circular linked list with n people
    public CircularLinkedList(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("The number of people must be at least 1.");
        }

        head = new Person(1);
        Person current = head;
        for (int i = 2; i <= n; i++) {
            current.next = new Person(i);
            current = current.next;
        }
        current.next = head; // Make the list circular
    }

    // Solve the Josephus Problem and return the order of elimination
    public List<Integer> solveJosephusProblem(int k, int start) {
        List<Integer> eliminationOrder = new ArrayList<>();
        Person current = head;
        Person previous = null;

        // Rotate the list to the starting position
        for (int i = 1; i < start; i++) {
            previous = current;
            current = current.next;
        }

        while (current != current.next) {
            // Find the k-th person in the circle
            for (int i = 1; i < k; i++) {
                previous = current;
                current = current.next;
            }

            // Remove the k-th person from the circle
            eliminationOrder.add(current.number);
            previous.next = current.next;
            current = current.next;
        }

        eliminationOrder.add(current.number); // The last person remaining

        return eliminationOrder;
    }
}

public class JosephusProblemSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        int n = scanner.nextInt();
        System.out.println("Enter the number for counting off: ");
        int k = scanner.nextInt();
        System.out.println("Enter the number of the person where counting starts: ");
        int start = scanner.nextInt();

        CircularLinkedList circle = new CircularLinkedList(n);
        List<Integer> eliminationOrder = circle.solveJosephusProblem(k, start);

        System.out.println("Elimination Order: " + eliminationOrder);
        System.out.println("The last person standing: " + eliminationOrder.get(eliminationOrder.size() - 1));
    }
}
