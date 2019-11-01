package com.brest.senlainc;

import java.util.Scanner;

public class Task6DeleteNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string with numbers: ");
        String str = in.nextLine();
        in.close();

        System.out.println("String without numbers: " + str.replaceAll("[0-9]",""));
    }
}
