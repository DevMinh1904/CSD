
package stackdemo;

public class Stack {
    // declare max capacity for stack 
    static final int MAX = 100;
    // top index to tracking top element 
    int top = -1;
    // declare array to store stack 
    int a[] = new int[MAX];
    
    // push() : add  
    boolean push(int valueWantPush){
        // stack if full 
        // top >= (MAX - 1) 
        if(top >= (MAX-1)){
            System.out.println("Stack overflow");
            return false;
        }else{
            top++;
            a[top] = valueWantPush;
            System.out.println(valueWantPush + " pushed into stack");
            return true;
        }
    }
    // pop() : remove 
    int pop(){ // vừa xóa phần tử trên cùng và vừa trả về phần tử trên cùng 
        if(top < 0){
            System.out.println("Stack Underflow");
            return 0;
        }else{
            int x = a[top];
            // giảm index top xuống 
            top--;
            return x;
        }
    }
    
    // chỉ lấy ra phần tủ trên cùng 
    int peek(){
        if(top < 0){
            System.out.println("Stack underflow");
            return 0;
        }else{
            int x = a[top];
            return x;
        }
    }
}
