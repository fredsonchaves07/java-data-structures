package com.fredson.datastructures.queue;

public interface Queue<T> {

    void enqueue(T element);

    T dequeue();

    T peek();

    boolean isEmpty();

    int length();

    void clear();
}
