package com.fredson.datastructures;

public interface List<T> {

    void push(T element);

    void remove(T element);

    void remove(int index);

    int indexOf(T element);

    T getElement(int index);

    T getElement(T element);

    int length();

    boolean isEmpty();
}
