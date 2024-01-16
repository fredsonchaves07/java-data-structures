package com.fredson.datastructures.list;

import com.fredson.datastructures.DataStructure;
import com.fredson.datastructures.iterator.Iterator;

public interface List<T> extends DataStructure<T> {

    void push(T element);

    void push(T element, int index);

    void remove(T element);

    void remove(int index);

    int indexOf(T element);

    T getElement(int index);

    T getElement(T element);

    void clear();

    Iterator<T> iterator();
}
