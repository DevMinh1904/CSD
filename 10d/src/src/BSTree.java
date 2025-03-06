//
//import java.util.ArrayList;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Admin
// */
//public class BSTree {
//    Node root;
//
//    public BSTree() {
//        root = null;
//    }
//    
//    void clear() {
//        root = null;
//    }
//    
//    boolean isEmpty() {
//        return root == null;
//    }
//    
//    void insert(int x) {
//        Node q = new Node(x);
//        if (isEmpty()) {
//            root = q;
//            return;
//        }
//        Node p = root, f = null;
//        while (p != null) {
//            if (p.info == x) 
//                return;
//            
//            f = p;
//            if (p.info > x) 
//                p = p.left;
//            else
//                p = p.right;
//        }
//        
//        if (f.info > x) 
//            f.left = q;
//        else
//            f.right = q;
//    } 
//    
//    void preOrder(Node p) {
//        if (p == null) return;
//        System.out.print(p.info + " ");
//        preOrder(p.left);
//        preOrder(p.right);
//    }
//    
//    void preOrder() {
//        preOrder(root);
//        System.out.println();
//    }
//    
//    void inOrder(Node p) {
//        if (p == null) return;
//        inOrder(p.left);
//        System.out.print(p.info + " ");
//        inOrder(p.right);
//    }
//    
//    void inOrder() {
//        inOrder(root);
//        System.out.println();
//    }
//    
//    void postOrder(Node p) {
//        if (p == null) return;
//        postOrder(p.left);
//        postOrder(p.right);
//        System.out.print(p.info + " ");
//    }
//    
//    void postOrder() {
//        postOrder(root);
//        System.out.println();
//    }
//    
//    void BFS() {
//        if (isEmpty()) return;
//        MyQueue q = new MyQueue();
//        q.enqueue(root);
//        Node p;
//        while (!q.isEmpty()) {
//            p = q.dequeue();
//            System.out.print(p.info + " ");
//            if (p.left != null)
//                q.enqueue(p.left);
//            if (p.right != null)
//                q.enqueue(p.right);
//        }
//        System.out.println();
//    }
//    
//    void delete(Node x) {
//        if (isEmpty()) 
//            return;
//        Node p = root, f = null;
//        while (p != null) {
//            if (p.info == x.info) break;
//            f = p;
//            if (p.info > x.info)
//                p = p.left;
//            else
//                p = p.right;
//        }
//        if (p == null) return;
//        
//        // No child
//        if (p.left == null && p.right == null) {
//            if (f == null) {
//                root = null;
//                return;
//            }
//            if (f.left == p)
//                f.left = null;
//            else
//                f.right = null;
//        }
//        
//        // 1 child
//        if (p.left != null && p.right == null) {
//            if (f == null) {
//                root = p.left;
//                return;
//            }
//            if (f.left == p)
//                f.left = p.left;
//            else
//                f.right = p.left;
//        } 
//        else if (p.left == null && p.right != null) {
//            if (f == null) {
//                root = p.right;
//                return;
//            }
//            if (f.left == p) 
//                f.left = p.right;
//            else 
//                f.right = p.right;
//        }
//
//        // 2 children
//        if (p.left != null && p.right != null)
//            deleteByCopying(p);
////            deleteByMerging(p);
//    }
//    
//    void deleteByCopying(Node p) {
//        Node rightMost = p.left, f = null;
//        while (rightMost.right != null) {
//            f = rightMost;
//            rightMost = rightMost.right;
//        }
//        p.info = rightMost.info;
//        if (f == null)
//            p.left = rightMost.left;
//        else 
//            f.right = rightMost.left;
//    }
//    
//    void deleteByMerging(Node p) {
//        Node rightMost = p.left, f = searchParent(p);
//        while (rightMost.right != null) rightMost = rightMost.right;
//        rightMost.right = p.right;
//        if (f == null)
//            root = p.left;
//        else if (f.left == p)
//            f.left = p.left;
//        else 
//            f.right = p.left;
//    }
//    
//    int height() {
//        return height(root);
//    }
//    
//    int height(Node p) {
//        if (p == null) return 0;
//        int l = height(p.left), r = height(p.right);
//        return (l > r) ? l + 1 : r + 1;
//    }
//    
//    boolean isAVL(Node p) {
//        if (p == null) 
//            return true;
//        if (Math.abs(height(p.left) - height(p.right)) <= 1) 
//            return isAVL(p.left) && isAVL(p.right);
//        return false;
//    }
//    
//    Node updateAVL(Node p) {
//        if (p == null)
//            return null ;
//        while (height(p.left) - height(p.right) > 1) {
//            p = rotateRight(p);
//            p.left = updateAVL(p.left);
//            p.right = updateAVL(p.right);
//        }
//        while (height(p.right) - height(p.left) > 1) {
//            p = rotateLeft(p);
//            p.left = updateAVL(p.left);
//            p.right = updateAVL(p.right);
//        }
//        return p;
//    }
//    
//    int count() {
//        return count(root);
//    }
//    
//    int count(Node p) {
//        return (p == null) ? 0 : 1 + count(p.left) + count(p.right);
//    }
//    
//    int min() {
//        if (isEmpty()) return 0;
//        Node p = root;
//        while (p.left != null) p = p.left;
//        return p.info;
//    }
//    
//    Node search(Node x) {
//        Node p = root;
//        while (p != null && p.info != x.info) {
//            if (p.info > x.info)
//                p = p.left;
//            else
//                p = p.right;
//        }
//        return p;
//    }
//    
//    Node searchParent(Node a) {
//        if (a == null)
//            return null;
//        Node p = root, f = null;
//        while (p != null && p != a) {
//            f = p;
//            if (p.info > a.info)
//                p = p.left;
//            else 
//                p = p.right;
//        }
//        return f;
//    }
//    
//    Node rotateLeft(Node a) {
//        if (a == null || a.right == null)
//            return a;
//        Node b = a.right;
//        a.right = b.left;
//        b.left = a;
//        return b;
//    }
//    
//    void rotateLeftModifier(Node a) {
//        Node p = search(a);
//        if (p == root) {
//            root = rotateLeft(root);
//        } else {
//            Node parent = searchParent(p);
//            Node b = rotateLeft(p);
//            if (p != null) {
//                if (parent.left == p)
//                    parent.left = b;
//                else
//                    parent.right = b;
//            }
//        }
//    }
//    
//    Node rotateRight(Node a) {
//        if (a == null || a.left == null)
//            return a;
//        Node b = a.left;
//        a.left = b.right;
//        b.right = a;
//        return b;
//    }
//    
//    void rotateRightModifier(Node a) {
//        Node p = search(a);
//        if (p == root) {
//            root = rotateRight(root);
//        } else {
//            Node parent = searchParent(p);
//            Node b = rotateRight(p);
//            if (p != null) {
//                if (parent.left == p)
//                    parent.left = b;
//                else
//                    parent.right = b;
//            }
//        }
//    }
//    
//    void simpleBalance() {
//        if (!isAVL(root)) balance(root);
//    }
//    
//    void balance(ArrayList<Node> a, int first, int last){
//        if(first > last) return;
//        int m = (first + last) /2;
//        int x = ((Node)a.get(m)).info;
//        insert(x);
//        balance(a, first, m-1);
//        balance(a, m+1, last);
//    }
//	
//    void balance(Node p){
//        ArrayList<Node> a = new ArrayList<>();
//        buildArray(a, p);
//        int first = 0;
//        int last = a.size() - 1;
//        MyTree b = new MyTree();
//        b.balance(a, first, last);
//        root = b.root;
//    } 
//    
//    void buildArray(ArrayList<Node> a, Node p){
//        if (p == null) return;
//        buildArray(a, p.left);
//        a.add(p);
//        buildArray(a, p.right);
//    }
//    
//}
