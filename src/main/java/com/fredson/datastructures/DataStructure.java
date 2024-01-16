package com.fredson.datastructures;

import com.fredson.datastructures.iterator.Iterator;

public interface DataStructure<T> {

    int length();

    boolean isEmpty();

    Iterator<T> iterator();
}
