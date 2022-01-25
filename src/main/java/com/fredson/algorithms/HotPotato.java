package fredson.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fredson.datastructures.Queue;

public class HotPotato {
    
    public static String hotPotato(List<String> elementsList, int quantity){
        Queue<String> queue = new Queue<>();
        List<String> eliminatedList = new ArrayList<>();
        for(String element : elementsList){
            queue.enqueue(element);
        }
        while(queue.size() > 1){
            for(int i = 0; i < quantity; i ++){
                queue.enqueue(queue.dequeue());
            }
            eliminatedList.add(queue.dequeue());
        }
        return "eliminated: " + eliminatedList + "\nwinner: " + queue.dequeue(); 
    }

    public static void main(String[] args) {
        String[] names = {"Jhon", "Jack", "Camila", "Ingrid", "Carl"};
        System.out.println(hotPotato(Arrays.asList(names) , 7));
    }
}
