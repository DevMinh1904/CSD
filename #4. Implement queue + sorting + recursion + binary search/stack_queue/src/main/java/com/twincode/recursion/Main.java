package com.twincode.recursion;

public class Main {
    // tinh giai thua cua n so nguyen ( n >= 0)
    // 5! = 5*4*2*...*1
    // 0! = 1
    // 1! = 1
    // 2! = 2
    // 3! = 1*2*3 = 6
    // 4!
    // 2 yeu to
    // bai toan co so ( 0! = 1)
    // cong thuc quy nap
    // n! = (n-1)!*n
    
    public static long factorial(int n){
        if(n == 0) return 1;
        System.out.println("n = " + n);
        return factorial(n-1)*n;
    }

    // fabonnanci 
    // 1 1 2 3 5 8 ...
    // 0 1 2 3 4 5 
    public static int fibo(int n){
        if(n <= 1) return 1;
        System.out.println(">> n " + n);
        // cong thuc quy nap 
        return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        // long result = factorial(4);
        int result = fibo(10);
        System.out.println(result);
    }
}
