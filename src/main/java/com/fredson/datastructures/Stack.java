package com.fredson.datastructures;

public interface Stack<T> {

    void push(T element);

    T pop();

    T peek();

    int length();

    boolean isEmpty();
}
