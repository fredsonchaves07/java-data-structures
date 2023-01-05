package com.fredson.datastructures.stack;

public interface Stack<T> {

    void push(T element);

    T pop();

    T peek();

    int length();

    boolean isEmpty();
}
