import java.io.*;
import java.util.Scanner;

public class TrainBookingSystem {
    static TrainList trainList = new TrainList();
    static CustomerList customerList = new CustomerList();
    static BookingList bookingList = new BookingList();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    loadTrainData();
                    break;
                case 2:
                    addTrainToEnd();
                    break;
                case 3:
                    trainList.display();
                    break;
                case 4:
                    saveTrainData();
                    break;
                case 5:
                    searchTrainByCode();
                    break;
                case 6:
                    deleteTrainByCode();
                    break;
                case 7:
                    sortTrains();
                    break;
                case 8:
                    addTrainAfterPosition();
                    break;
                case 9:
                    deleteNodeBeforeTrain();  
                    break;
                case 10:
                    loadCustomerData();
                    break;
                case 11:
                    addCustomerToEnd();
                    break;
                case 12:
                    customerList.display();
                    break;
                case 13:
                    saveCustomerData();
                    break;
                case 14:
                    searchCustomerByCode();
                    break;
                case 15:
                    deleteCustomerByCode();
                    break;
                case 16:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\nTrain Booking System Menu:");
        System.out.println("=== Train List ===");
        System.out.println("1. Load train data");
        System.out.println("2. Add new train");
        System.out.println("3. Display trains");
        System.out.println("4. Save train data");
        System.out.println("5. Search by train code");
        System.out.println("6. Delete by train code");
        System.out.println("7. Sort trains by train code");
        System.out.println("8. Add train after position k");
        System.out.println("9. Delete the node before the node having tcode = xCode"); 

        System.out.println("=== Customer List ===");
        System.out.println("10. Load customer data");
        System.out.println("11. Add new customer");
        System.out.println("12. Display customers");
        System.out.println("13. Save customer data");
        System.out.println("14. Search by customer code");
        System.out.println("15. Delete by customer code");

        System.out.println("16. Exit");
        System.out.print("Enter your choice: ");
    }

    // Train List Methods
    public static void loadTrainData() {
        System.out.print("Enter the train data file name: ");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length == 6) {
                    String tcode = parts[0].trim();
                    String train_name = parts[1].trim();
                    int seat = Integer.parseInt(parts[2].trim());
                    int booked = Integer.parseInt(parts[3].trim());
                    double depart_time = Double.parseDouble(parts[4].trim());
                    String depart_place = parts[5].trim();
                    Train train = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
                    trainList.addTrainToEnd(train);
                }
            }
            System.out.println("Train data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void addTrainToEnd() {
        System.out.print("Enter train code (tcode): ");
        String tcode = scanner.nextLine();
        System.out.print("Enter train name: ");
        String train_name = scanner.nextLine();
        System.out.print("Enter number of seats: ");
        int seat = scanner.nextInt();
        System.out.print("Enter number of booked seats: ");
        int booked = scanner.nextInt();
        System.out.print("Enter departure time: ");
        double depart_time = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter departure place: ");
        String depart_place = scanner.nextLine();

        Train train = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
        trainList.addTrainToEnd(train);
        System.out.println("Train added successfully.");
    }

    public static void saveTrainData() {
        System.out.print("Enter the file name to save train data: ");
        String fileName = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Node temp = trainList.head;
            while (temp != null) {
                Train train = (Train) temp.data;
                writer.write(train.tcode + " | " + train.train_name + " | " + train.seat + " | " + train.booked + " | " + train.depart_time + " | " + train.depart_place + "\n");
                temp = temp.next;
            }
            System.out.println("Train data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void searchTrainByCode() {
        System.out.print("Enter train code to search: ");
        String tcode = scanner.nextLine();
        Node temp = trainList.head;
        while (temp != null) {
            Train train = (Train) temp.data;
            if (train.tcode.equals(tcode)) {
                System.out.println("Train found: " + train);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Train not found.");
    }

    public static void deleteTrainByCode() {
        System.out.print("Enter train code to delete: ");
        String tcode = scanner.nextLine();
        Node temp = trainList.head;
        Node prev = null;
        while (temp != null) {
            Train train = (Train) temp.data;
            if (train.tcode.equals(tcode)) {
                if (prev == null) {
                    trainList.head = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Train deleted: " + train);
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Train not found.");
    }

    public static void sortTrains() {
        Node current = trainList.head;
        Node index = null;
        Train tempTrain;
        if (trainList.head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (((Train) current.data).tcode.compareTo(((Train) index.data).tcode) > 0) {
                        tempTrain = (Train) current.data;
                        current.data = index.data;
                        index.data = tempTrain;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        System.out.println("Trains sorted successfully.");
    }

    public static void addTrainAfterPosition() {
        System.out.print("Enter position to add after: ");
        int position = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter train code (tcode): ");
        String tcode = scanner.nextLine();
        System.out.print("Enter train name: ");
        String train_name = scanner.nextLine();
        System.out.print("Enter number of seats: ");
        int seat = scanner.nextInt();
        System.out.print("Enter number of booked seats: ");
        int booked = scanner.nextInt();
        System.out.print("Enter departure time: ");
        double depart_time = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter departure place: ");
        String depart_place = scanner.nextLine();

        Train train = new Train(tcode, train_name, seat, booked, depart_time, depart_place);

        Node temp = trainList.head;
        int count = 0;
        while (temp != null) {
            if (count == position) {
                Node newNode = new Node(train);
                newNode.next = temp.next;
                temp.next = newNode;
                System.out.println("Train added after position " + position);
                return;
            }
            count++;
            temp = temp.next;
        }
        System.out.println("Invalid position.");
    }

    public static void deleteNodeBeforeTrain() {
        System.out.print("Enter train code to delete the node before: ");
        String tcode = scanner.nextLine();

        if (trainList.head == null || trainList.head.next == null) {
            System.out.println("Not enough nodes to perform this operation.");
            return;
        }

        Node temp = trainList.head;
        Node prev = null;

        while (temp != null && temp.next != null) {
            Train train = (Train) temp.next.data; 
            if (train.tcode.equals(tcode)) {
                if (prev == null) {
                    trainList.head = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Node before train code " + tcode + " deleted.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Train with tcode " + tcode + " not found.");
    }

    public static void loadCustomerData() {
        System.out.print("Enter the customer data file name: ");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length == 3) {
                    String ccode = parts[0].trim();
                    String cus_name = parts[1].trim();
                    String phone = parts[2].trim();
                    Customer customer = new Customer(ccode, cus_name, phone);
                    customerList.addCustomerToEnd(customer);
                }
            }
            System.out.println("Customer data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void addCustomerToEnd() {
        System.out.print("Enter customer code (ccode): ");
        String ccode = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String cus_name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(ccode, cus_name, phone);
        customerList.addCustomerToEnd(customer);
        System.out.println("Customer added successfully.");
    }

    public static void saveCustomerData() {
        System.out.print("Enter the file name to save customer data: ");
        String fileName = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Node temp = customerList.head;
            while (temp != null) {
                Customer customer = (Customer) temp.data;
                writer.write(customer.ccode + " | " + customer.cus_name + " | " + customer.phone + "\n");
                temp = temp.next;
            }
            System.out.println("Customer data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void searchCustomerByCode() {
        System.out.print("Enter customer code to search: ");
        String ccode = scanner.nextLine();
        Node temp = customerList.head;
        while (temp != null) {
            Customer customer = (Customer) temp.data;
            if (customer.ccode.equals(ccode)) {
                System.out.println("Customer found: " + customer);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Customer not found.");
    }

    public static void deleteCustomerByCode() {
        System.out.print("Enter customer code to delete: ");
        String ccode = scanner.nextLine();
        Node temp = customerList.head;
        Node prev = null;
        while (temp != null) {
            Customer customer = (Customer) temp.data;
            if (customer.ccode.equals(ccode)) {
                if (prev == null) {
                    customerList.head = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Customer deleted: " + customer);
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Customer not found.");
    }
}
