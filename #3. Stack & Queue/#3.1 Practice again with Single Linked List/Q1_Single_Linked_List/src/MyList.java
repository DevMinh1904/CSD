/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xType, int xRate, int xWing) {
        //You should write here appropriate statements to complete this function.        
        // add contrains 
        if(xType.charAt(0) == 'B'){
            // do nothing 
            return;
        }
        // new data of bird 
        Bird newBird = new Bird(xType, xRate, xWing);
        
        // new node contain bird data 
        Node newNode = new Node(newBird);
        
        if(isEmpty()){
            head = tail = newNode;
        }else{
            // last node connect to new node 
            tail.next = newNode;
            // new node is last node ( update tail ) 
            tail = newNode;
        }
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bird x, y;
        x = new Bird("X", 1, 2);
        y = new Bird("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insertPosition(3,new Node(x));
        insertPosition(5,new Node(y));
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    // insert a position k 
    void insertPosition(int pos, Node x){
        if(pos == 0){
            // insert head 
            x.next = head;
            head = x;
        }
        else{
            Node p = getIndex(pos-1);
            Node tempNextP = p.next;
            p.next = x;
            x.next = tempNextP;
        }
        
        
    }
    
    // 1->2->3
    // 0  1  2 
    // index 1 
    Node getIndex(int index){
        if(index < 0){
            return null;
        }
        int counter = 0;
        for(Node i = head; i != null; i = i.next){     
            if(counter == index){
                return i;
            }
            counter++;
        }
        return null;
    }


//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        changeSecondNode();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    void changeSecondNode(){
        // tạo counter ban đầu = 0 
        int counter = 0;
        // duyệt từ đầu tới cuối node 
        for(Node i = head; i != null; i=i.next){
            // nếu rate < 6 counter lên 1 
            if(i.info.rate < 6){
                counter++;
            }
            // nếu counter == 2 có nghĩa là mình đang truy cập tới second 
            // node có rate < 6
            // thay đổi luôn 
            if(counter == 2){
                i.info.wing = 99;
                break;
            }
        }
    }
//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // sort the sublist from head to maxRateNode 
        // lab211 : bubble sort 
        Node maxRateNode = findFirstMaxRate();
        // bubble sort 
        for(Node i = head; i != maxRateNode;i = i.next){
            for(Node j = i.next; j != maxRateNode.next; j = j.next){
                if(i.info.rate > j.info.rate){
                    // swap algorithm 
                    Bird temp = i.info;
                    i.info = j.info;
                    j.info = temp;
                }
            }
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    // 1->2->2->3->4->4->3
    // 4 : first max rate node 
    
    Node findFirstMaxRate(){
        if(head == null) return null;
        Node maxRateNode = head;
        for(Node i = head; i != null; i = i.next){
            if(i.info.rate > maxRateNode.info.rate){
                maxRateNode = i;
            }
        }
        return maxRateNode;
    }

    
   
}
