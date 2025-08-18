/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.twincode.singlelinkedlist;

/**
 *
 * @author bravee06
 */

// Viết danh sách liên kết đơn lưu trữ 4 số nguyên. Tìm phần tử lớn nhất trong danh sách 

public class DemoLinkedList {
    static class Node{
        int data;
        Node next;
        
        // hàm dựng khởi tạo khi được tạo ra 
        public Node(int data){
            this.data =data;
            this.next = null;
        }
    }
    
    static class MyLinkedList{
        Node head;
        Node tail;
        
        public MyLinkedList(){
            head = tail = null;
        }
        
        public void insertBefore(int data){
            // khởi tạo node và cấp phát bộ nhớ 
            Node newNode = new Node(data);
            // TH: Danh sách liên kết rỗng 
            if(head == null){
                // hai con trỏ head và tail trỏ tới node mới tạo 
                head = tail = newNode;
            }else{
                newNode.next = head;
                head = newNode;
            }
        }
        
        public void insertAfter(int data){
            // khởi tạo node và cấp phát bộ nhớ 
            Node newNode = new Node(data);
            // TH: Danh sách liên kết rỗng 
            if(head == null){
                // hai con trỏ head và tail trỏ tới node mới tạo 
                head = tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
        }
        
        // hàm xuất danh sách 
        public void display(){
            //for(int i =0; i < n;i++);
            for(Node i = head; i != null;i = i.next){
                System.out.print(i.data + " - ");
            }
        }
        
        
        // hàm tìm phần tử lớn nhất trong danh sách 
        
        public int getMax(){
            int max = head.data; // gán max là giá trị của Node đầu tiên 
            
            // duyệt từ đầu node đến cuối node 
            for(Node i = head; i != null;i = i.next){
                // so sánh giá trị các node với giá trị max 
                // và cập nhật 
                if(i.data > max) max = i.data;
            }
            
            // trả về giá trị lớn nhất 
            return max;
        }
    }
    
    public static void main(String[] args) {
        // khởi tạo danh sách liên kết 
        MyLinkedList newLinnkedList = new  MyLinkedList();
      
        int n = 4;
        
        for(int i = 1; i <= n; i++){
            newLinnkedList.insertBefore(i);
        }
        
        newLinnkedList.insertBefore(10);
        newLinnkedList.insertAfter(5);
        
        
        newLinnkedList.display();
        
        
        
        int max_value = newLinnkedList.getMax();
        
        
        System.out.println("Max value: " + max_value);
        
        
        
        
        
    }
}
