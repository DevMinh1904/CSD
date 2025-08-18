import java.util.LinkedList;

public class BookServiceImpl implements BookService {

    private class Node {
        Book book;
        Node left;
        Node right;

        Node(Book book) {
            this.book = book;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BookServiceImpl() {
        this.root = null;
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null || book.getCode() == null)
            return false;
        // Nếu cây rỗng, thêm vào gốc
        if (root == null) {
            root = new Node(book);
            return true;
        }

        // Thêm vào cây, kiểm tra trùng mã sách
        Node temp = root;
        // book.getCode() trả về String, không thể dùng toán tử như < hoặc > trực tiếp với String
        while (true) {
            if (book.getCode().equals(temp.book.getCode())) {
                return false; // Mã sách đã tồn tại
            } else if (book.getCode().compareTo(temp.book.getCode()) < 0) {
                if (temp.left == null) {
                    temp.left = new Node(book);
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new Node(book);
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    @Override
    public void showBook(int method) {
        if (method == 1) {
            System.out.println("In-order traversal:");
            inOrderTraversal(root);
        } else if (method == 2) {
            System.out.println("Breadth-first traversal:");
            breadthFirstTraversal(root);
        } else {
            System.out.println("Invalid method!");
        }
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.book);
            inOrderTraversal(node.right);
        }
    }

    private void breadthFirstTraversal(Node root) {
        if (root == null) return;

        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;

        while (!q.isEmpty()) {
            p = q.dequeue();
            visit(p);

            if (p.left != null) q.enqueue(p.left);
            if (p.right != null) q.enqueue(p.right);
        }
    }

    // Visit method to process nodes
    private void visit(Node node) {
        System.out.println(node.book);
    }

    class MyQueue {
        private LinkedList<Node> list = new LinkedList<>();

        public void enqueue(Node node) {
            list.addLast(node);
        }

        public Node dequeue() {
            return list.pollFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    @Override
    public Book searchBookbyCode(String bookCode) {
        if (bookCode == null)
            return null;
        Node temp = root;
        while (temp != null) {
            if (bookCode.compareTo(temp.book.getCode()) < 0) {
                temp = temp.left;
            } else if (bookCode.compareTo(temp.book.getCode()) > 0) {
                temp = temp.right;
            } else {
                return temp.book;
            }
        }
        return null;
    }

    @Override
    public int countBook() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    @Override
    public boolean removeBook(String bookCode) {
        if (bookCode == null) {
            return false;
        }

        Node parent = null;
        Node temp = root;

        // Tìm node parent và node cần xóa
        while (temp != null && !bookCode.equals(temp.book.getCode())) {
            parent = temp;
            if (bookCode.compareTo(temp.book.getCode()) < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (temp == null) {
            return false; // Không tìm thấy
        }

        // Nếu Node không có con
        if (temp.left == null && temp.right == null) {
            if (temp == root) {
                root = null;
            } else if (parent.left == temp) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Nếu node có 1 con
        else if (temp.left == null || temp.right == null) {
            Node child = (temp.left != null) ? temp.left : temp.right;
            if (temp == root) {
                root = child;
            } else if (parent.left == temp) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        // Nếu node có 2 con
        else {
            Node successorParent = temp;
            Node successor = temp.right;

            // Tìm successor nhỏ nhất trong cây con phải
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Thay thế giá trị node cần xóa bằng successor
            temp.book = successor.book;

            // Xóa successor khỏi cây (successor có tối đa 1 con)
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        return true;
    }


    // Helper method to find the minimum node in a subtree
    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public void printAvailableBook() {
        printAvailableBooks(root);
    }

    private void printAvailableBooks(Node node) {
        if (node != null) {
            printAvailableBooks(node.left);
            if (node.book.getLended() < node.book.getQuantity()) {
                System.out.println(node.book);
            }
            printAvailableBooks(node.right);
        }
    }

    @Override
    public void balancing() {
        // Bước 1: Chuyển cây thành danh sách các node bằng duyệt in-order
        java.util.List<Node> nodes = new java.util.ArrayList<>();
        inOrderTraversalForBalancing(root, nodes);

        // Bước 2: Xây dựng lại cây cân bằng từ danh sách
        root = buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    private void inOrderTraversalForBalancing(Node node, java.util.List<Node> nodes) {
        if (node != null) {
            inOrderTraversalForBalancing(node.left, nodes);
            nodes.add(node);
            inOrderTraversalForBalancing(node.right, nodes);
        }
    }

    private Node buildBalancedTree(java.util.List<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        // Chọn phần tử giữa làm gốc để đảm bảo cây cân bằng
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        // Đệ quy xây dựng cây con bên trái và bên phải
        node.left = buildBalancedTree(nodes, start, mid - 1);
        node.right = buildBalancedTree(nodes, mid + 1, end);

        return node;
    }

    @Override
    public Book searchBookbyName(String name) {
        if (name == null) return null;
        return searchByName(root, name);
    }

    private Book searchByName(Node node, String name) {
        if (node == null) return null;

        Book found = searchByName(node.left, name);
        if (found != null) {
            return found;
        } else if (node.book.getName().equals(name)) {
            return node.book;
        } else {
            return searchByName(node.right, name);
        }
    }
}