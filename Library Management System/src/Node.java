/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducmi
 */
class Node {
    Book book;
    Node left, right;

    public Node(Book book) {
        this.book = book;
        this.left = this.right = null;
    }
}