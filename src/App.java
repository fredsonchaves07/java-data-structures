import datastructures.Queue;
import datastructures.Stack;

public class App {
    public static void main(String[] args){
        /* Testes com pilha */
        /*runStack();*/

        /*Testes com fila */
        runQueue();

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

    public static void runQueue(){
        Queue<String> queue = new Queue<>();
        System.out.println(queue.isEmpty());
        queue.enqueue("Jhon");
        queue.enqueue("Jack");
        System.out.println(queue);
        queue.enqueue("Camila");
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
