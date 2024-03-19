package com.fredson.datastructures.map;

import com.fredson.datastructures.DataStructure;
import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.List;

public interface Map<E, T> extends DataStructure<E>, Iterator<E> {

    void set(E key, T value);

    void remove(E key);

    boolean hasKey(E key);

    T get(E key);

    void clear();

    List<T> values();

    List<E> keys();

    Iterator<T> forEach();
}
