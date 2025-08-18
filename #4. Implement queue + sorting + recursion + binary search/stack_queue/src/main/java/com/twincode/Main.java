package com.twincode;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

interface IStackQueue {
    boolean push(int value);

    int pop();

    boolean isFull();

    boolean isEmpty();

    void show();
}

class MyQueueByArray implements IStackQueue {
    int[] array;
    int SIZE;
    int head;
    int tail;

    public MyQueueByArray(int size) {
        SIZE = size;
        array = new int[SIZE];
        head = -1;
        tail = -1;
    }

    @Override
    public boolean push(int value) {
        if (isFull()) {
            System.err.println("Overflow!");
            return false;
        }
        if (isEmpty()) { // hang doi rong ( head = tail = -1)
            head = 0;
        }
        array[++tail] = value;
        return true;
    }

    @Override
    public int pop() {
        int result = -1;
        if (isEmpty()) {
            return result;
        }
        result = array[head++];
        if (head > tail)
            head = tail = -1;
        return result;
    }

    @Override
    public boolean isFull() {
        return tail == SIZE - 1;
    }

    @Override
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    @Override
    public void show() {
        for (int i = head; i <= tail; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // xuong dong
    }

}

class MyStackByArray implements IStackQueue {
    int[] array;
    int SIZE;
    int topIndex;

    public MyStackByArray(int size) {
        SIZE = size;
        array = new int[SIZE];
        topIndex = -1;
    }

    @Override
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stackoverflow");
            return false;
        }

        array[++topIndex] = value;
        return true;
    }

    @Override
    public int pop() {
        if (isEmpty())
            return -1;
        return array[topIndex--];
    }

    @Override
    public boolean isFull() {
        return topIndex == SIZE - 1;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public void show() {
        for (int i = topIndex; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

class MyQueueByLinkedList implements IStackQueue {
    Node head, tail;

    public MyQueueByLinkedList() {
        head = tail = null;
    }

    @Override
    public boolean push(int value) {
        if (isFull())
            return false;

        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }


    @Override
    public int pop() {
        if (isEmpty())
            return -1;
        int result = head.value;
        head = head.next; // xoa head, cap nhat lai head
        if (head == tail.next) {
            head = tail = null;
        }
        return result;

    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Queue empty");
            return;
        } 
        for(Node i = head; i != null;i=i.next){
            System.out.print(i.value+ " ");
        }
        System.out.println();
    }

}

public class Main {
    public static void main(String[] args) {
        MyQueueByLinkedList myQueue = new MyQueueByLinkedList();
        myQueue.push(5);
        myQueue.push(4);
        myQueue.push(3);
        myQueue.push(2);
        myQueue.push(1);
        System.out.println(myQueue.push(10));
        myQueue.show();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.show();
        // System.out.println(">>head: "+myQueue.head);
        // System.out.println(">>tail: "+myQueue.tail);
        // myQueue.pop();
        // System.out.println(myQueue.push(10));
        // myQueue.show();
        // MyStackByArray myStack = new MyStackByArray(4);
        // myStack.push(4);
        // myStack.push(3);
        // myStack.push(2);
        // myStack.push(1);
        // myStack.push(10);
        // System.out.println(">>pop: " + myStack.pop());
        // myStack.show();
    }
}