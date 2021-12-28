package algorithms;

import datastructures.Stack;

public class DecimalToBinary {

    public static String decimalToBinary(int number){
        Stack<Integer> stack = new Stack<>();
        String binaryString = "";

        while(number > 0){
            int rem = number % 2;
            number = number / 2;
            stack.push(rem);
        }

        while(!stack.isEmpty()){
            binaryString += stack.pop();
        }

        return binaryString;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(233));
        System.out.println(decimalToBinary(10));
        System.out.println(decimalToBinary(1000));
    }

}
