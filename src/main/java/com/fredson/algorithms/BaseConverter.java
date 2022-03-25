package com.fredson.algorithms;

import com.fredson.datastructures.Stack;

public class BaseConverter {

    public static String baseConverter(int number, int base){
        Stack<Integer> stack = new Stack<>();
        StringBuilder baseConverterString = new StringBuilder();
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while(number > 0){
            int rem = number % base;
            number = number / base;
            stack.push(rem);
        }
        while(!stack.isEmpty()){
            baseConverterString.append(digits.charAt(stack.pop()));
        }
        return baseConverterString.toString();
    }
    public static void main(String[] args) {
        System.out.println(baseConverter(100345, 2));
        System.out.println(baseConverter(100345, 8));
        System.out.println(baseConverter(100345, 16));
    }
}
