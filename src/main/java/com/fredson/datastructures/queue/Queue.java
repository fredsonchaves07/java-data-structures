package com.fredson.datastructures.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    
    private List<T> items;

    public Queue(){
        this.items = new ArrayList<>();
    }

    public void enqueue(T element){
        this.items.add(element);
    }

    public T dequeue(){
        return this.items.remove(0);
    }

    public T peek(){
        return this.items.get(0);
    }

    public boolean isEmpty(){
        return this.items.size() == 0;
    }

    public int size(){
        return this.items.size();
    }

    public void clear(){
        this.items.clear();
    }

    @Override
    public String toString() {
        return this.items.toString();
    }
}
