package com.fredson.datastructures.list;

import com.fredson.datastructures.iterator.Iterator;

public interface List<T> {

    void push(T element);

    void push(T element, int index);

    void remove(T element);

    void remove(int index);

    int indexOf(T element);

    T getElement(int index);

    T getElement(T element);

    int length();

    boolean isEmpty();

    void clear();

    Iterator<T> iterator();
}
