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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to end");
            System.out.println("3. Display data");
            System.out.println("4. Save data to file");
            System.out.println("5. Search by code");
            System.out.println("6. Delete by code");
            System.out.println("7. Sort by code");
            System.out.println("8. Input & add to beginning");
            System.out.println("9. Add after position k");
            System.out.println("10. Delete position k");
            System.out.println("0. Exit");
            System.out.print("Your selection (0 -> 10): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loadDataFromFile(list, scanner);
                    break;
                case 2:
                    inputTaxpayer(list, scanner, false);
                    break;
                case 3:
                    list.displayData();
                    break;
                case 4:
                    saveDataToFile(list, scanner);
                    break;
                case 5:
                    searchByCode(list, scanner);
                    break;
                case 6:
                    deleteByCode(list, scanner);
                    break;
                case 7:
                    list.sortList(); // Use chosen sorting algorithm from LinkedList class
                    System.out.println("List sorted by code.");
                    break;
                case 8:
                    inputTaxpayer(list, scanner, true);
                    break;
                case 9:
                    addAfterPosition(list, scanner);
                    break;
                case 10:
                    deleteAtPosition(list, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // Helper methods for file I/O and menu actions
    private static void loadDataFromFile(LinkedList list, Scanner scanner) {
        System.out.print("Enter filename: ");
        String filename = scanner.next();
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                TaxPayer taxpayer = parseTaxpayerData(line);
                list.insertAtEnd(taxpayer);
            }
            fileScanner.close();
            System.out.println("Data loaded successfully from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        }
    }

    private static void saveDataToFile(LinkedList list, Scanner scanner) {
        System.out.print("Enter filename: ");
        String filename = scanner.next();
        try {
            FileWriter writer = new FileWriter(filename);
            Node current = list.head;
            while (current != null) {
                writer.write(formatTaxpayerData(current.data) + "\n");
                current = current.next;
            }
            writer.close();
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error: Could not write to file!");
        }
    }

    private static void inputTaxpayer(LinkedList list, Scanner scanner, boolean isBeginning) {
        TaxPayer taxpayer = new TaxPayer();

        System.out.print("Enter code: ");
        taxpayer.code = scanner.nextLine();

        System.out.print("Enter name: ");
        taxpayer.name = scanner.nextLine();

        do {
            System.out.print("Enter income (positive value): ");
            taxpayer.income = scanner.nextDouble();
        } while (taxpayer.income <= 0);

        do {
            System.out.print("Enter deduction (non-negative and less than income): ");
            taxpayer.deduction = scanner.nextDouble();
        } while (taxpayer.deduction < 0 || taxpayer.deduction > taxpayer.income);

        taxpayer.tax = calculateTax(taxpayer.income, taxpayer.deduction);

        if (isBeginning) {
            list.insertAtBeginning(taxpayer);
        } else {
            list.insertAtEnd(taxpayer);
        }
        System.out.println("Taxpayer added successfully.");
    }

    private static void searchByCode(LinkedList list, Scanner scanner) {
        System.out.print("Enter taxpayer code to search: ");
        String code = scanner.nextLine();

        TaxPayer taxpayer = list.searchByCode(code);
        if (taxpayer != null) {
            System.out.println("Taxpayer found:");
            System.out.printf("%5s%10s%10s%10s%10s\n", "Code", "Tax Name", "Income", "Deduction", "Tax");
            System.out.println(taxpayer);
        } else {
            System.out.println("Taxpayer with code " + code + " not found.");
        }
    }

    private static void deleteByCode(LinkedList list, Scanner scanner) {
        System.out.print("Enter taxpayer code to delete: ");
        String code = scanner.next();

        TaxPayer taxpayer = list.deleteByCode(code);
        if (taxpayer != null) {
            System.out.println("Taxpayer deleted successfully:");
            System.out.printf("%5s%10s%10s%10s%10s\n", "Code", "Tax Name", "Income", "Deduction", "Tax");
            System.out.println(taxpayer);
        } else {
            System.out.println("Taxpayer with code " + code + " not found.");
        }
    }

    private static void addAfterPosition(LinkedList list, Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("List is empty. Cannot add after position.");
            return;
        }

        System.out.print("Enter position to insert after: ");
        int position = scanner.nextInt();

        if (position < 0 || position >= list.length()) {
            System.out.println("Invalid position.");
            return;
        }

        TaxPayer taxpayer = new TaxPayer();
        inputTaxpayerDetails(taxpayer, scanner);

        list.insertAfter(position, taxpayer);
        System.out.println("Taxpayer added successfully.");
    }

    private static void deleteAtPosition(LinkedList list, Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("List is empty. Cannot delete at position.");
            return;
        }

        System.out.print("Enter position to delete: ");
        int position = scanner.nextInt();

        if (position < 0 || position >= list.length()) {
            System.out.println("Invalid position.");
            return;
        }

        TaxPayer taxpayer = list.deleteAtPosition(position);
        System.out.println("Taxpayer deleted successfully:");
        System.out.printf("%5s%10s%10s%10s%10s\n", "Code", "Tax Name", "Income", "Deduction", "Tax");
        System.out.println(taxpayer);
    }

    private static void inputTaxpayerDetails(TaxPayer taxpayer, Scanner scanner) {
       
            System.out.print("Enter code: ");
            taxpayer.code = scanner.nextLine();

            System.out.print("Enter name: ");
            taxpayer.name = scanner.nextLine();
        do{
            System.out.print("Enter income (positive value): ");
            taxpayer.income = scanner.nextDouble();
        } while (taxpayer.income <= 0);

        do {
            System.out.print("Enter deduction (non-negative and less than income): ");
            taxpayer.deduction = scanner.nextDouble();
        } while (taxpayer.deduction < 0 || taxpayer.deduction > taxpayer.income);

        taxpayer.tax = calculateTax(taxpayer.income, taxpayer.deduction);
    }

    private static double calculateTax(double income, double deduction) {
        double taxableIncome = income - deduction;
        if (taxableIncome <= 5000) {
            return taxableIncome * 0.05;
        } else if (taxableIncome <= 10000) {
            return 250 + (taxableIncome - 5000) * 0.1;
        } else {
            return 750 + (taxableIncome - 10000) * 0.15;
        }
    }

    private static String formatTaxpayerData(TaxPayer taxpayer) {
        return taxpayer.code + ","
                + taxpayer.name + ","
                + taxpayer.income + ","
                + taxpayer.deduction + ","
                + taxpayer.tax;
    }

    private static TaxPayer parseTaxpayerData(String line) {
        String[] data = line.split(",");
        if (data.length != 5) {
            throw new IllegalArgumentException("Invalid data format in file!");
        }

        TaxPayer taxpayer = new TaxPayer();
        taxpayer.code = data[0];
        taxpayer.name = data[1];
        taxpayer.income = Double.parseDouble(data[2]);
        taxpayer.deduction = Double.parseDouble(data[3]);
        taxpayer.tax = Double.parseDouble(data[4]);

        return taxpayer;
    }

}
