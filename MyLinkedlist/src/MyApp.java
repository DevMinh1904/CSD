/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducmi
 */
public class MyApp {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addTail(12);
        list.addTail(10);
        list.addTail(7);
        list.addTail(15);
        list.addTail(20);
        list.addHead(100);
        list.traverse();
        list.find(7);
        
        Node head = list.getHead();
        System.out.println("Danh sach: ");
        System.out.print(head.getInfo() + " ");
        System.out.print(head.getNext().getInfo() + " ");
        System.out.print(head.getNext().getNext().getInfo() + " ");
        System.out.print(head.getNext().getNext().getNext().getInfo() + " ");

    }
}
