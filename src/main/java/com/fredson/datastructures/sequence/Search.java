package com.fredson.datastructures.sequence;

import java.util.List;

public class Search<T> {

    private final List list;
    
    public Search(List list) {
        this.list = list;
    }

    public T binarySearch(T element) {
        if (!isSort(list)) throw new RuntimeException("List is not ordered");
        List firstBinaryList = list.subList(0, list.size() / 2);
        return null;
    }

    private boolean isSort(List list) {
        return false;
    }
}
