package app;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;

    private int height(AVLNode<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(AVLNode<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode<T> rotateRight(AVLNode<T> y) {
        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(T key) {
        root = insertRec(root, key);
    }

    private AVLNode<T> insertRec(AVLNode<T> node, T key) {
        if (node == null) {
            return new AVLNode<>(key);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insertRec(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRec(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rotateRight(node);
        }
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return rotateLeft(node);
        }
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void delete(T key) {
        root = deleteRec(root, key);
    }

    private AVLNode<T> deleteRec(AVLNode<T> root, T key) {
        if (root == null) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if ((root.left == null) || (root.right == null)) {
                AVLNode<T> temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                AVLNode<T> temp = getMinValueNode(root.right);
                root.key = temp.key;
                root.right = deleteRec(root.right, temp.key);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rotateRight(root);
        }
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) {
            return rotateLeft(root);
        }
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    private AVLNode<T> getMinValueNode(AVLNode<T> node) {
        AVLNode<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public boolean search(T key) {
        return searchRec(root, key) != null;
    }

    private AVLNode<T> searchRec(AVLNode<T> root, T key) {
        if (root == null || root.key.equals(key)) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }
    
    public T get(T key) {
        AVLNode<T> node = searchRec(root, key);
        return node == null ? null : node.key;
    }
    
    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }
    
    private void inOrderTraversal(AVLNode<T> node, List<T> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.key);
            inOrderTraversal(node.right, result);
        }
    }
}
