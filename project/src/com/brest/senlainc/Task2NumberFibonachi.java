package com.brest.senlainc;

import java.util.Scanner;

public class Task2NumberFibonachi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number N: ");
        int N = in.nextInt();
        in.close();

        for (int i = 1; i <= N; i++){
            System.out.println("fibonachi(" + i + ") = " + fibo(i));
        }
    }

    public static int fibo(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fibo(n-2) + fibo(n-1);
    }
}
