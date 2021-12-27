import datastructures.Stack;

public class App {
    public static void main(String[] args){
        /* Testes com pilha */
        runStack();

    }

    public static void runStack(){
        Stack<Integer> stack = new Stack<Integer>();

        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(8);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.push(11);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.toString());
    }
}
