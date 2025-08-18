package app;

import java.util.Date;
import java.util.List;

public class ISM {
    private AVLTree<IceCream> iceCreamTree = new AVLTree<>();
    private AVLTree<Customer> customerTree = new AVLTree<>();
    private AVLTree<Invoice> invoiceTree = new AVLTree<>();
    private AVLTree<Employee> employeeTree = new AVLTree<>();

    public void addIceCream(IceCream iceCream) {
        iceCreamTree.insert(iceCream);
    }

    public void addCustomer(Customer customer) {
        customerTree.insert(customer);
    }
    
    public void updateCustomer(Customer customer) {
        Customer existingCustomer = customerTree.get(customer);
        if (existingCustomer != null) {
            customerTree.delete(existingCustomer);
            customerTree.insert(customer);
        }
    }

    public void addEmployee(Employee employee) {
        employeeTree.insert(employee);
    }

    public void updateIceCream(IceCream iceCream) {
        IceCream existingIceCream = iceCreamTree.get(iceCream);
        if (existingIceCream != null) {
            iceCreamTree.delete(existingIceCream);
            iceCreamTree.insert(iceCream);
        }
    }

    public void deleteIceCream(IceCream iceCream) {
        iceCreamTree.delete(iceCream);
    }
    
    public void updateEmployee(Employee employee) {
        Employee existingEmployee = employeeTree.get(employee);
        if (existingEmployee != null) {
            employeeTree.delete(existingEmployee);
            employeeTree.insert(employee);
        }
    }

    public void deleteEmployee(Employee employee) {
        employeeTree.delete(employee);
    }
    
    public void updateInvoice(Invoice invoice) {
        Invoice existingInvoice = invoiceTree.get(invoice);
        if (existingInvoice != null) {
            invoiceTree.delete(existingInvoice);
            invoiceTree.insert(invoice);
        }
    }

    public void deleteCustomer(Customer customer) {
        customerTree.delete(customer);
    }
    
    public void deleteInvoice(Invoice invoice) {
        invoiceTree.delete(invoice);
    }

    public void generateInvoice(int invoiceId, Customer customer, IceCream iceCream, int quantity) {
        double totalPrice = iceCream.price * quantity;
        Invoice invoice = new Invoice(invoiceId, customer, iceCream, quantity, totalPrice, new Date());
        invoiceTree.insert(invoice);
    }

    public List<Employee> listAllEmployees() {
        return employeeTree.getAll();
    }
    
    public List<Customer> listAllCustomers() {
        return customerTree.getAll();
    }

    public List<Invoice> listAllInvoices() {
        return invoiceTree.getAll();
    }
    
    public List<IceCream> listAllIceCreams() {
        return iceCreamTree.getAll();
    }
    
    public static void main(String[] args) {
         ISM ism = new ISM();

        // Adding entities
        IceCream iceCream1 = new IceCream(1, "Vanilla", "Vanilla", 2.5);
        IceCream iceCream2 = new IceCream(2, "Chocolate", "Chocolate", 3.0);
        Customer customer1 = new Customer(1, "John Doe", "john@example.com", "1234567890");
        Customer customer2 = new Customer(2, "Jane Roe", "jane@example.com", "0987654321");
        Employee employee1 = new Employee(1, "Jane Smith", "Manager");
        Employee employee2 = new Employee(2, "John Brown", "Cashier");

        ism.addIceCream(iceCream1);
        ism.addIceCream(iceCream2);
        ism.addCustomer(customer1);
        ism.addCustomer(customer2);
        ism.addEmployee(employee1);
        ism.addEmployee(employee2);

        // Generating invoices
        ism.generateInvoice(1, customer1, iceCream1, 3);
        ism.generateInvoice(2, customer2, iceCream2, 5);

        // Updating entities
        IceCream updatedIceCream = new IceCream(1, "Vanilla Delight", "Vanilla", 2.75);
        ism.updateIceCream(updatedIceCream);
        Customer updatedCustomer = new Customer(1, "Johnathan Doe", "johnathan@example.com", "1234567890");
        ism.updateCustomer(updatedCustomer);
        Employee updatedEmployee = new Employee(1, "Jane Smith", "General Manager");
        ism.updateEmployee(updatedEmployee);

        // Deleting entities
        ism.deleteIceCream(iceCream2);
        ism.deleteCustomer(customer2);
        ism.deleteEmployee(employee2);

        // Listing all entities
        System.out.println("All Ice Creams:");
        List<IceCream> iceCreams = ism.listAllIceCreams();
        for (IceCream iceCream : iceCreams) {
            System.out.println(iceCream);
        }

        System.out.println("All Customers:");
        List<Customer> customers = ism.listAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("All Employees:");
        List<Employee> employees = ism.listAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("All Invoices:");
        List<Invoice> invoices = ism.listAllInvoices();
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }
    
}
