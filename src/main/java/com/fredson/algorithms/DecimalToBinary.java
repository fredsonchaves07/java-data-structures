package com.fredson.algorithms;

import com.fredson.datastructures.stack.ArrayStack;
import com.fredson.datastructures.stack.Stack;

public class DecimalToBinary {

    public static String decimalToBinary(int number) {
        Stack<Integer> stack = new ArrayStack<>();
        StringBuilder binaryString = new StringBuilder();
        while(number > 0){
            int rem = number % 2;
            number = number / 2;
            stack.push(rem);
        }
        while(!stack.isEmpty())
            binaryString.append(stack.pop());
        return binaryString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(233));
        System.out.println(decimalToBinary(10));
        System.out.println(decimalToBinary(1000));
    }

}
