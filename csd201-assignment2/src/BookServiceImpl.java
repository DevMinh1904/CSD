
public class BookServiceImpl implements BookService {

    private class Node {
        Book book;
        Node left, right;
        
        public Node(Book book) {
            this.book = book;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root; 
    
    public BookServiceImpl() {
        root = null;
    }
    
    // 1. Add book to BST
    @Override
    public boolean addBook(Book book) {
        if (book == null || searchBookbyCode(book.getCode()) != null) {
            return false; // Book already exists or is null
        }
        
        root = addBookRecursive(root, book);
        return true;
    }
    
    private Node addBookRecursive(Node current, Book book) {
        if (current == null) {
            return new Node(book);
        }
        
        // Compare book codes for BST ordering
        int compareResult = book.getCode().compareTo(current.book.getCode());
        
        if (compareResult < 0) {
            current.left = addBookRecursive(current.left, book);
        } else if (compareResult > 0) {
            current.right = addBookRecursive(current.right, book);
        }
        
        return current;
    }
    
    // 2-3. Print books with different traversal methods
    @Override
    public void showBook(int method) {
        if (method == 1) {
            // In-order traversal
            System.out.println("In-order traversal:");
            inOrderTraversal(root);
        } else if (method == 2) {
            // Breadth-first traversal
            System.out.println("Breadth-first traversal:");
            breadthFirstTraversal();
        }
    }
    
    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        
        inOrderTraversal(node.left);
        System.out.println(node.book);
        inOrderTraversal(node.right);
    }
    
    private void breadthFirstTraversal() {
        if (root == null) {
            return;
        }
        
        // Use a queue for BFS
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.book);
            
            if (node.left != null) {
                queue.add(node.left);
            }
            
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    
    // 4. Search book by code
    @Override
    public Book searchBookbyCode(String bookCode) {
        return searchBookbyCodeRecursive(root, bookCode);
    }
    
    private Book searchBookbyCodeRecursive(Node node, String bookCode) {
        if (node == null || bookCode == null) {
            return null;
        }
        
        int compareResult = bookCode.compareTo(node.book.getCode());
        
        if (compareResult == 0) {
            return node.book;
        } else if (compareResult < 0) {
            return searchBookbyCodeRecursive(node.left, bookCode);
        } else {
            return searchBookbyCodeRecursive(node.right, bookCode);
        }
    }
    
    // 5. Count books
    @Override
    public int countBook() {
        return countBookRecursive(root);
    }
    
    private int countBookRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + countBookRecursive(node.left) + countBookRecursive(node.right);
    }
    
    // 6. Remove book by code
    @Override
    public boolean removeBook(String bookCode) {
        if (searchBookbyCode(bookCode) == null) {
            return false; // Book not found
        }
        
        root = removeBookRecursive(root, bookCode);
        return true;
    }
    
    private Node removeBookRecursive(Node node, String bookCode) {
        if (node == null) {
            return null;
        }
        
        int compareResult = bookCode.compareTo(node.book.getCode());
        
        if (compareResult < 0) {
            node.left = removeBookRecursive(node.left, bookCode);
        } else if (compareResult > 0) {
            node.right = removeBookRecursive(node.right, bookCode);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            
            // Node with two children
            // Get the inorder successor (smallest in the right subtree)
            node.book = findMinValue(node.right);
            
            // Delete the inorder successor
            node.right = removeBookRecursive(node.right, node.book.getCode());
        }
        
        return node;
    }
    
    private Book findMinValue(Node node) {
        Book minValue = node.book;
        while (node.left != null) {
            minValue = node.left.book;
            node = node.left;
        }
        return minValue;
    }
    
    // 7. Print available books (lended < quantity)
    @Override
    public void printAvailableBook() {
        System.out.println("Available Books (sorted by code):");
        printAvailableBookRecursive(root);
    }
    
    private void printAvailableBookRecursive(Node node) {
        if (node == null) {
            return;
        }
        
        // In-order traversal to print in sorted order by code
        printAvailableBookRecursive(node.left);
        
        if (node.book.getLended() < node.book.getQuantity()) {
            System.out.println(node.book);
        }
        
        printAvailableBookRecursive(node.right);
    }
    @Override
    public void balancing() {
    }
    @Override
    public Book searchBookbyName(String name) {
         return new Book("TEST","Test book",10,10,35.5);
    }    
    
    
}
