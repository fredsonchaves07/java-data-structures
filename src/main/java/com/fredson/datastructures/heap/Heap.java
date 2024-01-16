package com.fredson.datastructures.heap;

import com.fredson.datastructures.DataStructure;

public interface Heap<T> extends DataStructure<T> {

    void insert(T element);

    T extract();

    T find();


}
