package com.fredson.datastructures.heap;

import com.fredson.datastructures.DataStructure;
import com.fredson.datastructures.list.List;

public interface Heap<T> extends DataStructure<T> {

    void insert(T element);

    T extract();

    T find();

    List<T> toList();

    default int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    default int getRightIndex(int index) {
        return 2 * index + 2;
    }

    default int getParentIndex(int index) {
        if (index == 0) return 0;
        return (int) Math.floor(((double) index - 1) / 2);
    }
}
