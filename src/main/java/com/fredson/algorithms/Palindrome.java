package com.fredson.algorithms;

import com.fredson.datastructures.Stack;

public class Palindrome {
    
    public static boolean isPalindrome(String string){
        Stack<String> stack = new Stack<>();
        String[] charString = string.replaceAll(" ", "").toLowerCase().split("");
        StringBuilder stringReverse = new StringBuilder();
        if(string.equals("")){
            return false;
        }
        for (String s : charString) {
            stack.push(s);
        }
        while(!stack.isEmpty()){
            stringReverse.append(stack.pop());
        }
        return stringReverse.toString().equals(string.replaceAll(" ", "").toLowerCase());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Ana"));
        System.out.println(isPalindrome("Jhon"));
        System.out.println(isPalindrome("A babá baba"));
        System.out.println(isPalindrome("Socorram me subi no onibus em Marrocos"));
        System.out.println(isPalindrome("O cachorro late"));
    }
}
