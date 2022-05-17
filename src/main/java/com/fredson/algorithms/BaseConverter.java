package com.fredson.algorithms;

import com.fredson.datastructures.ArrayStack;
import com.fredson.datastructures.Stack;

public class BaseConverter {

    final static String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String baseConverter(int number, int base){
        Stack<Integer> stack = new ArrayStack<>();
        StringBuilder baseConverterString = new StringBuilder();
        while (number > 0){
            int rem = number % base;
            number = number / base;
            stack.push(rem);
        }
        while (!stack.isEmpty()){
            baseConverterString.append(DIGITS.charAt(stack.pop()));
        }
        return baseConverterString.toString();
    }
}
