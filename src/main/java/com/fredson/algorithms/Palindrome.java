package fredson.algorithms;

import fredson.datastructures.Stack;

public class Palindrome {
    
    public static boolean isPalindrome(String string){
        Stack<String> stack = new Stack<>();
        String[] charString = string.replaceAll(" ", "").toLowerCase().split("");
        String stringReverse = "";

        if(string == ""){
            return false;
        }

        for(int indexChar = 0; indexChar < charString.length; indexChar ++){
            stack.push(charString[indexChar]);
        }

        while(!stack.isEmpty()){
            stringReverse += stack.pop();
        }

        if(!stringReverse.equals(string.replaceAll(" ", "").toLowerCase())){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Ana"));
        System.out.println(isPalindrome("Jhon"));
        System.out.println(isPalindrome("A babá baba"));
        System.out.println(isPalindrome("Socorram me subi no onibus em Marrocos"));
        System.out.println(isPalindrome("O cachorro late"));
    }
}
