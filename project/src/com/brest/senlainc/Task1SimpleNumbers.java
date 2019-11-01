package com.brest.senlainc;

import java.util.Scanner;

public class Task1SimpleNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number N: ");
        int N = in.nextInt();
        in.close();

        System.out.println(simpleNum(N));
    }

    private static String simpleNum(int n) {
        String string = "";
        if(n <= 1){
            return  "Error. Enter a other number!";
        }
        for (int i = 2; i < n; i++){
            boolean flag = false;
            for (int j = i - 1; j >= 2; j--){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                string += i + " ";
            }
        }
        return string;
    }
}
