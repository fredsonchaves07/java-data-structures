package com.fredson.datastructures.set;

import com.fredson.datastructures.DataStructure;

public interface Set<T> extends DataStructure<T> {

    void add(T element);

    void delete(T element);

    boolean hasElement(T element);

    void clear();

    T[] values();
}
