package com.brest.senlainc;

import java.util.Scanner;

//множество реализаций через String, массив Char, остановился на  StringBuilder
public class Task5PalindromeWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a word: ");
        String str = in.nextLine();
        in.close();

        System.out.println("Palindrome?: " + isPalindrome(str));
    }

    private static  boolean isPalindrome(String string){
        StringBuilder reverseStringBuilder = new StringBuilder(string).reverse();
        String reverseStr = reverseStringBuilder.toString();
        return string.equals(reverseStr);
    }
}

