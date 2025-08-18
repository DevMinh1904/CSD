
import java.util.ArrayList;

public class PhoneList {

    Node head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    void f0_StudentInfo() {
        //System.out.println("HE12346-VuVanHuy");
    }

    void f1_addHead(Phone x) {
        // check if price >20 do nothing otherwise add x to the head of the list
        if (x.price <= 20) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }

    }

    void f2_addtail(Phone x) {
        // check if price >20 do nothing otherwise add x to the tail of the list
        if (x.price <= 20) {
            Node newNode = new Node(x);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

    }

    void f3_InsertAt(Phone x, int pos) {
        // Insert phone x at pos Node   
        Node newNode = new Node(x);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; i < pos; i++) {
            if (current != null) {
                current = current.next;
            }
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }

    }

    public void f4_InsertBeforeFirstmax(Phone x) {
        Node current = head;
        Node prev = null;
        Node maxPrev = null;
        Node maxNode = head;
        double maxPrice = head != null ? head.info.price : -1;

        while (current != null) {
            if (current.info.price > maxPrice) {
                maxPrice = current.info.price;
                maxPrev = prev;
                maxNode = current;
            }
            prev = current;
            current = current.next;
        }

        Node newNode = new Node(x);
        if (maxPrev == null) { // Insert at head or list is empty
            newNode.next = head;
            head = newNode;
        } else { // Insert before maxNode
            newNode.next = maxPrev.next;
            maxPrev.next = newNode;
        }
    }

    void f5_InsertAfterFirstMin(Phone x) {
        Node current = head;
        Node minNode = null;
        double minPrice = Double.MAX_VALUE; // Set to highest possible value

        while (current != null) {
            if (current.info.price < minPrice) {
                minPrice = current.info.price;
                minNode = current;
            }
            current = current.next;
        }

        if (minNode != null) {
            Node newNode = new Node(x);
            // Insert after the min price node
            newNode.next = minNode.next;
            minNode.next = newNode;
        }
    }

    void f6_InsertAfter(Phone x, double xPrice) {
        // Insert Phone x after the first Node which has price = xPrice
        Node current = head;
        while (current != null && current.info.price != xPrice) {
            current = current.next;
        }
        if (current != null) {
            Node newNode = new Node(x);
            newNode.next = current.next;
            current.next = newNode;
        }

    }

    void f7_InsertBefore(Phone x, double xPrice) {
        Node current = head;
        Node previous = null;
        while (current != null && current.info.price != xPrice) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            Node newNode = new Node(x);
            if (current == head) {
                newNode.next = head;
                head = newNode;
            } else {
                previous.next = newNode;
                newNode.next = current;
            }
        }
    }

    void f8_removeAt(int pos) {
        // remove a node at position pos
        Node current = head;
        Node previous = null;
        int index = 0;
        while (current != null && index < pos) {
            previous = current;
            current = current.next;
            index++;
        }
        if (current != null) {
            if (previous == null) {
                head = head.next; // remove head
            } else {
                previous.next = current.next; // remove current node
            }
        }
    }

    void f9_removeOne(double x) {
        //remove the last Phone has price = x   
        Node current = head;
        Node previous = null;
        Node toRemove = null;
        Node preToRemove = null;
        while (current != null) {
            if (current.info.price == x) {
                preToRemove = previous;
                toRemove = current;
            }
            previous = current;
            current = current.next;
        }
        if (toRemove != null) {
            if (toRemove == head) {
                head = head.next; // remove head
            } else {
                preToRemove.next = toRemove.next; // remove toRemove node
            }
        }
    }

    void f10_removeAll(double x) {
        //remove all Phones have price = x 
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.info.price == x) {
                if (previous == null) {
                    head = current.next; // remove head
                    current = head;
                } else {
                    previous.next = current.next; // remove current node
                    current = previous.next;
                }
            } else {
                previous = current;
                current = current.next;
            }
        }
    }

    void f11_remove2(char x) {
        // Remove 2th Node which has first character of model =x
        Node current = head;
        int count = 0;
        while (current != null && current.next != null) {
            if (current.next.info.model.charAt(0) == x) {
                count++;
                if (count == 2) {
                    current.next = current.next.next;
                    return;
                }
            }
            current = current.next;
        }
    }

    public void f12_RemoveBefore(char x) {
        
    }

    public void f13_RemoveAfter(char x) {
        if (head == null || head.next == null) {
            return; // No need to remove if the list is empty or has only one element
        }
        Node current = head;
        Node nodeToRemoveAfter = null;

        // Traverse the list to find the last node whose model starts with char x
        while (current != null && current.next != null) {
            if (current.info.model.charAt(0) == x) {
                nodeToRemoveAfter = current; // Found a node, keep track of it
            }
            current = current.next; // Move to the next node
        }

        // If found, remove the node after nodeToRemoveAfter
        if (nodeToRemoveAfter != null && nodeToRemoveAfter.next != null) {
            nodeToRemoveAfter.next = nodeToRemoveAfter.next.next;
        }
    }

    void f14_RemoveBefore(char x) {
        // remove Node before the first Node has the first character of model equal x  
        Node current = head;
        Node previous = null;
        while (current != null && current.next != null) {
            if (current.next.info.model.charAt(0) == x) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    void f15_RemoveAfter(char x) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.info.model.charAt(0) == x) {
                if (current.next != null) {
                    current.next = current.next.next;
                }
                return;
            }
            current = current.next;
        }
    }

    void f16_SortAsc() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node index = null;
        Phone temp;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.info.price > index.info.price) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    void f17_SortDes() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node index = null;
        Phone temp;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.info.price < index.info.price) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    void f18_SortAsc2() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node index = null;
        Phone temp;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.info.model.compareTo(index.info.model) > 0) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    void f19_SortDes2() {
        // sort list Descending by model
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node index = null;
        Phone temp;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.info.model.compareTo(index.info.model) < 0) {
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // f20: Sort by price increment from head to last maximum price
    public void f20_sort2() {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one element
        }
        // Find the last maximum price node
        Node lastMax = head;
        double maxPrice = head.info.price;
        Node current = head.next;
        while (current != null) {
            if (current.info.price >= maxPrice) { // Check for greater or equal to include the last occurrence of max price
                maxPrice = current.info.price;
                lastMax = current;
            }
            current = current.next;
        }

        // Perform bubble sort up to the last maximum price node
        boolean wasChanged;
        do {
            Node previous = null;
            Node node = head;
            wasChanged = false;

            while (node.next != null && node != lastMax) {
                if (node.info.price > node.next.info.price) {
                    // Swap the nodes
                    wasChanged = true;
                    Node temp = node.next;
                    node.next = temp.next;
                    temp.next = node;
                    if (previous == null) {
                        head = temp;
                    } else {
                        previous.next = temp;
                    }
                    previous = temp;
                } else {
                    previous = node;
                    node = node.next;
                }
            }
        } while (wasChanged);
    }

// f21: Update price of the Phone at pos(th) by value
    public void f21_update(int pos, double value) {
        if (head == null) {
            return; // List is empty
        }
        Node current = head;
        int count = 0;

        // Traverse to the position
        while (current != null) {
            if (count == pos) {
                current.info.price = value; // Update the price
                break;
            }
            count++;
            current = current.next;
        }
    }

// f22: Update prices of all phones by discount xpercent
    public void f22_Discount(double xpercent) {
        Node current = head;
        while (current != null) {
            current.info.price -= current.info.price * xpercent / 100; // Apply discount
            current = current.next;
        }
    }

// f23: Count the Phones which have the first character of Model equal x
    public int f23_count(char x) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (Character.toLowerCase(current.info.model.charAt(0)) == Character.toLowerCase(x)) {
                count++;
            }
            current = current.next;
        }
        return count;
    }
// f24: Return all Phones which have price <= x

    public PhoneList f24_listAll(double x) {
        PhoneList resultList = new PhoneList();
        Node current = head;
        while (current != null) {
            if (current.info.price <= x) {
                resultList.addTail(current.info); // Assuming addTail is a method to add a Phone to the tail of the list
            }
            current = current.next;
        }
        return resultList;
    }

    public PhoneList f25_listTopn(int n) {
        PhoneList sortedList = sortByPriceAsc(); // Assuming this method sorts the list in ascending order
        PhoneList resultList = new PhoneList(); // Assuming a constructor exists that initializes head to null
        Node current = sortedList.head;
        int count = 0;

        while (current != null && count < n) {
            resultList.addTail(current.info); // Assuming addTail(Phone x) method is implemented correctly
            current = current.next;
            count++;
        }

        return resultList;
    }

// Assuming a simple bubble sort for demonstration, replace with more efficient sort if needed
    private PhoneList sortByPriceAsc() {
        PhoneList sortedList = new PhoneList();
        if (head == null) {
            return sortedList; // Return empty list if original list is empty
        }
        // Clone original list to sortedList to keep the original list unmodified
        Node current = head;
        while (current != null) {
            sortedList.addTail(new Phone(current.info.model, current.info.price)); // Assuming Phone constructor and addTail method
            current = current.next;
        }

        // Bubble sort
        boolean wasChanged;
        do {
            Node currentSorted = sortedList.head;
            Node nextSorted = sortedList.head.next;
            Node prevSorted = null;
            wasChanged = false;

            while (nextSorted != null) {
                if (currentSorted.info.price > nextSorted.info.price) {
                    // Swap
                    if (prevSorted == null) {
                        sortedList.head = nextSorted;
                    } else {
                        prevSorted.next = nextSorted;
                    }
                    currentSorted.next = nextSorted.next;
                    nextSorted.next = currentSorted;

                    // Update pointers after swap
                    prevSorted = nextSorted;
                    nextSorted = currentSorted.next;
                    wasChanged = true;
                } else {
                    prevSorted = currentSorted;
                    currentSorted = nextSorted;
                    nextSorted = nextSorted.next;
                }
            }
        } while (wasChanged);

        return sortedList;
    }

    public void addTail(Phone x) {
        // Create a new node with given data
        Node newNode = new Node(x);

        // If the Linked List is empty, then make the new node as head
        if (head == null) {
            head = newNode;
            return;
        }

        // Else traverse till the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Change the next of last node
        last.next = newNode;
    }
}
