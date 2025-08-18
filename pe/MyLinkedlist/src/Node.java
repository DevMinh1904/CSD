/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducmi
 */
public class Node {

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(int info) {
        this.info = info;
    }
    

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    private int info;
    private Node next;

    @Override
    public String toString() {
        return "Node{" + "info=" + info + ", next=" + next + '}';
    }

}
