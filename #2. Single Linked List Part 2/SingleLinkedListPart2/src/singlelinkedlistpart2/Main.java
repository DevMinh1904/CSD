/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singlelinkedlistpart2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bravee06
 */

// danh sách liên kết gồm 10 số nguyên 
// danh sách liên kết gồm 10 học sinh

public class Main {
    
    static class Node<E>{
        E data;
        Node<E> next;
        
        // viết hàm khởi tạo một cái node 
        Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    
    static class SingleLinkedList<E>{
        private Node<E> head; // first element in sll 
        private Node<E> tail; // last elment in sll 
        private int size; // size of sll 
        
        public SingleLinkedList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        
        // insert element into last sll 
        public void addLast(E data){
            
            Node<E> newNode = new Node(data);
            if(size == 0){
                addFirst(data);
            }else{
                tail.next = newNode;
                tail = newNode;
            }
            
            // tăng size của sll lên 
            size++;
            
        }
        
        // insert element into first sll 
        public void addFirst(E data){
            // khởi tạo node 
            Node newNode = new Node(data);
            // th danh sách rỗng 
            if(size == 0){
                head = tail = newNode;
            }else{
                // cho liên kết next của newNode bằng head 
                newNode.next = head;
                // đổi đầu của danh sách 
                head = newNode;
            }
            size++;
        }
        
        
        // tìm kiếm node ở trong danh sách liên kết 
        Node<E> search(E data){
            // dùng vòng for duyệt từ đầu tới cuối danh sách 
            for(Node<E> i = head; i != null; i = i.next){
                
                if(i.data == data){
                    return i;
                }
            }
            
            return null;
        }
        
        List<Node<E>> getListNode(E data){
            // khởi tạo một danh sách các node 
            List<Node<E>> list = new ArrayList<>();
            // dùng vòng for duyệt từ đầu tới cuối danh sách 
            for(Node<E> i = head; i != null; i = i.next){
                
                if(i.data == data){
                    list.add(i);
                }
            }
            
            return list;
        }
        
        // get element in single linked list by index 
        // trả về một Node theo chỉ mục 
        // 1 -> 2 -> 3 
        // 0    1    2
        // get(1) = 2 
        // x 
        
        Node<E> get(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException();
            }
            
            Node<E> x = head; // trỏ tới thằng đầu tiên trong danh sách liên kêt 
            
            // index = 2 
            // i = 0,1
            for(int i = 0; i < index;i++){
                x = x.next; // di chuyển 2 lần đến khi gặp phần tử có index = 2
            }
            
            
//            int i = 0;
//            for(Node<E> start = head; start != null; start=start.next){
//                if(index == i){ // (1 , 0) , (1,1)
//                    return start;
//                }
//                i++; // i = 1 
//            }

            return x;
           
        }
        
        // dữ liệu a tương đương với node chuẩn bị thêm vào danh sách 
        // dữ liệu b tương đương với node đã có ở trong danh sách 
        void addAfterNodeFrist(E a,E b){
            Node<E> newNode = new Node(a);
            // chèn node p sau node q 
            // node q đã nằm trong danh sách liên kết 
            // nếu danh sách liên kết chỉ có một node 
            // thì node q chính là cái node đó 
            if(size == 1 && head.data == b){
                
                head.next = newNode;
            }
            // danh sách có nhiều hơn 1 phần tử 
            else{
                
                // tìm cái vị trí của node q 
                Node q = search(b);
                
                if(q == null) {
                    System.out.println("Không chèn được !");
                    return;
                }else{
//                    System.out.println("abc");
                    // khởi tạo node temp lưu node kế bên q 
                  
                       insertAfterNodeTemp(q,newNode);
//                        System.out.println(q);
                  
       
                }
            }
            
            
        }
        
        void insertAfterNodeTemp(Node q,Node newNode){
             Node temp = q.next;
             q.next = newNode;
             newNode.next = temp;
        }
        
        void display(){
            // 1 -> 2 -> 3 
            // 1,2,3
            // access from first element to last element 
            for(Node<E> i = head; i != null;i = i.next){
                // không phải phần tử cuối 
                if(i.next != null){
                    System.out.print(i.data + ", ");
                }else{
                    // phần tử cuối 
                    System.out.println(i.data);
                }
                
            }
            
        }
    }
    
    public static void main(String[] args) {
        // cấp phát bộ nhớ cho danh sách liên kết 
        SingleLinkedList<Integer> myList = new SingleLinkedList<>();
        // thêm phần tử vào danh sách liên kết 
        for(int i = 1;i <= 5;i++){
            myList.addLast(i);
        }
        
        
        for(int i = 6;i <= 10;i++){
            myList.addFirst(i);
        }
        myList.addLast(7);
        myList.addLast(7);
        myList.addLast(7);
        System.out.println("Nhập giá trị node p( chuẩn bị thêm vào ): ");
        Scanner sc = new Scanner(System.in);
        Integer a = sc.nextInt();
        System.out.println("Nhập giá trị của node q( đã trong danh sách ) :");
        Integer b = sc.nextInt();
        
        myList.addAfterNodeFrist(a, b);
        
        myList.display();
        
    }
    
    
}
