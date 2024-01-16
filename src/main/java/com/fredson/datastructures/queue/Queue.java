package com.fredson.datastructures.queue;

import com.fredson.datastructures.DataStructure;

public interface Queue<T> extends Cloneable, DataStructure<T> {

    void enqueue(T element);

    T dequeue();

    T peek();

    void clear();

    Queue<T> clone();
}
