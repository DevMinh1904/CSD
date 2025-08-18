/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Muoidiem;
//
///**
// *
// * @author ocbu0
// */
//public class USE {
//    
//}

// InSERT

// void insert(String xForest, int xRate, int xSound) {
//    //You should insert here statements to complete this function
//    if(!xForest.startsWith("A")) {
//        this.root = insertRec(root, xForest, xRate, xSound);
//        }
//   }
//    
//    Node insertRec(Node root, String xType, int xPrice, int xColor){
//        if(root == null) return new Node(new Boo(xType,xPrice,xColor));
//    else if(xColor > root.info.sound) root.right = insertRec(root.right,xType,xPrice,xColor);
//    
//    else if(xColor < root.info.sound) root.left = insertRec(root.left,xType,xPrice,xColor);
//    
//    else return root;
//    return root;
//    }


// DELETE BY Coppy

// void delete(Node x) {
//        if (isEmpty()) 
//            return;
//        Node p = root, f = null;
//        while (p != null) {
//            if (p.info == x.info) break;
//            f = p;
//            if (p.info.sound > x.info.sound)
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
//            delete(p);
//    }



//    void delete(Node x) {
//        if (isEmpty()) 
//            return;
//        Node p = root, f = null;
//        while (p != null) {
//            if (p.info == x.info) break;
//            f = p;
//            if (p.info.price > x.info.price)
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
//    }
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








// ADD MANG CAC KIEU

//   ArrayList<Node> a = new ArrayList<>();
//        postOrder3(root, f, a);
//        Node p = a.get(3);
//        Node ff = searchParent(p);
//        delete(ff);




// SEARCH PARENT 
//    Node searchParent(Node a) {
//        if (a == null)
//            return null;
//        Node p = root, f = null;
//        while (p != null && p != a) {
//            f = p;
//            if (p.info.hoof > a.info.hoof)
//                p = p.left;
//            else 
//                p = p.right;
//        }
//        return f;
//    }

//// ROTATE  

///rotate left
//     public Node rotateLeft(Node p) {
//     if(p.right == null) return p;
//     Node p1 = p.right;
//     p.right = p1.left;
//     p1.left = p;
//     return p1;
//    }
//	
////rotate right
//     public Node rotateRight(Node p) {
//     if(p.left == null) return p;
//     Node p1 = p.left;
//     p.left = p1.right;
//     p1.right = p;
//     return p1;
//    } 

// Calculate Tree
//int treeHeight(Node root) {
//     if(root == null) return 0;
//    int leftHeight = treeHeight(root.left);
//    int rightHeight = treeHeight(root.right);
//    if(leftHeight > rightHeight) return leftHeight +1;
//    else return rightHeight +1; 
//    }
    
//
//    public Node findNodeMax(Node root) {
//    if (root == null) {
//        return null;
//    }
//
//    Node maxPriceNode = root;
//    while (maxPriceNode.right != null) {
//        maxPriceNode = maxPriceNode.right;
//    }
//
//    return maxPriceNode;
//}