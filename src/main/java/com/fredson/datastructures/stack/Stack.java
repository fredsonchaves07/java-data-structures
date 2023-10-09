package com.fredson.datastructures.stack;

import com.fredson.datastructures.iterator.Iterator;

public interface Stack<T> extends Cloneable {

    void push(T element);

    T pop();

    T peek();

    int length();

    boolean isEmpty();

    Iterator<T> iterator();

    Stack<T> clone();
}
