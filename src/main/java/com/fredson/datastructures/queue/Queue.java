package com.fredson.datastructures.queue;

public interface Queue<T> {

    void enqueue(T element);

    T dequeue();

    T peek();

    boolean isEmpty();

    public int length();

    public void clear();
}
