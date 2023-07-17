package com.fredson.algorithms;

import com.fredson.datastructures.queue.ArrayQueue;
import com.fredson.datastructures.queue.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotPotato {
    
    public static String hotPotato(List<String> elementsList, int quantity) {
        Queue<String> arrayQueue = new ArrayQueue<>();
        List<String> eliminatedList = new ArrayList<>();
        for(String element : elementsList)
            arrayQueue.enqueue(element);
        while(arrayQueue.length() > 1){
            for(int i = 0; i < quantity; i ++)
                arrayQueue.enqueue(arrayQueue.dequeue());
            eliminatedList.add(arrayQueue.dequeue());
        }
        return "eliminated: " + eliminatedList + "\nwinner: " + arrayQueue.dequeue();
    }

    public static void main(String[] args) {
        String[] names = {"Jhon", "Jack", "Camila", "Ingrid", "Carl"};
        System.out.println(hotPotato(Arrays.asList(names) , 7));
    }
}
