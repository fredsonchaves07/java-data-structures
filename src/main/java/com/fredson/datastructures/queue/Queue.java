package com.fredson.datastructures.queue;

import com.fredson.datastructures.iterator.Iterator;

public interface Queue<T> extends Cloneable {

    void enqueue(T element);

    T dequeue();

    T peek();

    boolean isEmpty();

    int length();

    void clear();

    Iterator<T> iterator();

    Queue<T> clone();
}
