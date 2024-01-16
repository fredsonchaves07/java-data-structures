package com.fredson.datastructures.stack;

import com.fredson.datastructures.DataStructure;

public interface Stack<T> extends Cloneable, DataStructure<T> {

    void push(T element);

    T pop();

    T peek();

    Stack<T> clone();
}
