package com.fredson.algorithms;

import com.fredson.datastructures.stack.ArrayStack;
import com.fredson.datastructures.stack.Stack;

public class Palindrome {
    
    public static boolean isPalindrome(String string){
        if (isValidString(string)) return false;
        Stack<String> stack = new ArrayStack<>();
        String[] charStringVector = convertToCharString(string);
        StringBuilder stringReverse = new StringBuilder();
        for (String charString : charStringVector) stack.push(charString);
        while(!stack.isEmpty()) stringReverse.append(stack.pop());
        return isStringReverseEqualsString(stringReverse, string);
    }

    private static boolean isValidString(String string) {
        return string.equals("");
    }

    private static String[] convertToCharString(String string) {
        return string.replaceAll(" ", "").toLowerCase().split("");
    }

    private static boolean isStringReverseEqualsString(StringBuilder stringReverse, String string) {
        return stringReverse.toString().equals(string.replaceAll(" ", "").toLowerCase());
    }
}
