package com.brest.senlainc;

import java.util.Scanner;

public class Task4NODandNOK {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number N1: ");
        int n1 = in.nextInt();
        System.out.print("Input a number N2: ");
        int n2 = in.nextInt();
        in.close();

        System.out.println("NOD N1 and N2: " + NOD(n1, n2));
        System.out.println("NOK N1 and N2: " + NOK(n1, n2));
    }

    public static int NOD(int n1, int n2){
        if(n2 == 0)
            return n1;
        return NOD(n2, n1 % n2);
    }

    public static int NOK(int n1, int n2){
        return n1*n2/NOD(n1, n2);
    }
}
