package com.fredson.datastructures;

public interface List<T> {

    boolean push(T element);

    boolean remove(T element);

    boolean removeAt(int index);

    boolean insert(T element, int index);

    int indexOf(T element);

    T getElementAt(int index);

    T getElement(T element);

    int length();

    boolean isEmpty();
}
