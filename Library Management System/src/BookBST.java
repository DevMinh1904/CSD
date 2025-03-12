
import java.util.LinkedList;
import java.util.Queue;


class BookBST {

    Node root;

    // 1. Add book, return true if successful
    public boolean addBook(Book book) {
        if (searchBookbyCode(book.code) != null) {
            return false; // Ensure unique code
        }
        root = insertRec(root, book);
        return true;
    }

    private Node insertRec(Node root, Book book) { // Recursion 
        if (root == null) {
            return new Node(book);
        }
        if (book.code.compareTo(root.book.code) < 0) {
            root.left = insertRec(root.left, book);
        } else {    
            root.right = insertRec(root.right, book);
        }
        return root;
    }

    // 2-3. Print books (1: In-order, 2: Breadth-first)
    public void showBook(int method) {
        if (method == 1) {
            inOrder(root);
        } else if (method == 2) {
            breadthFirst(root);
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.book);
            inOrder(root.right);
        }
    }

    private void breadthFirst(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.book);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    // 4. Search Book by Code
    public Book searchBookbyCode(String bookCode) {
        Node result = searchRec(root, bookCode);
        return result != null ? result.book : null;
    }

    private Node searchRec(Node root, String bookCode) {
        if (root == null || root.book.code.equals(bookCode)) {
            return root;
        }
        return bookCode.compareTo(root.book.code) < 0 ? searchRec(root.left, bookCode) : searchRec(root.right, bookCode);
    }

    // 5. Count all books in the library
    public int countBook() {
        return countRec(root);
    }

    private int countRec(Node root) {
        return root == null ? 0 : 1 + countRec(root.left) + countRec(root.right);
    }

    // 6. Remove a book by code
    public boolean removeBook(String bookCode) {
        if (searchBookbyCode(bookCode) == null) {
            return false; // If not found
        }
        root = deleteRec(root, bookCode);
        return true;
    }

    private Node deleteRec(Node root, String bookCode) {
        if (root == null) {
            return null;
        }
        if (bookCode.compareTo(root.book.code) < 0) {
            root.left = deleteRec(root.left, bookCode);
        } else if (bookCode.compareTo(root.book.code) > 0) {
            root.right = deleteRec(root.right, bookCode);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node successor = findMin(root.right);
            root.book = successor.book;
            root.right = deleteRec(root.right, successor.book.code);
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // 7. Print all available books whose lended < quantity
    public void printAvailableBook() {
        printAvailableRec(root);
    }

    private void printAvailableRec(Node root) {
        if (root != null) {
            printAvailableRec(root.left);
            if (root.book.isAvailable()) {
                System.out.println(root.book);
            }
            printAvailableRec(root.right);
        }
    }
}
