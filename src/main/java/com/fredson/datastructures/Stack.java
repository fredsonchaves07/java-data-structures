package com.fredson.datastructures;

public interface Stack<T> {

    boolean push(T element);

    T pop();

    T peek();

    int length();

    boolean isEmpty();
}
