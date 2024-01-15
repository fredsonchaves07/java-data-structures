package com.fredson.datastructures;

import com.fredson.datastructures.iterator.Iterator;

public interface DataStructure<T> {

    int size();

    Iterator<T> iterator();
}
