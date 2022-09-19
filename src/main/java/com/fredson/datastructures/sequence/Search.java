package com.fredson.datastructures.sequence;

import java.util.Arrays;
import java.util.Iterator;

public class Search {
    
    public Search() {
    }

    public static <T extends Comparable<T>> T binarySearch(T[] elements, T element) {
        if (!Search.isSorted(elements)) throw new RuntimeException("List is not ordered");
        return null;
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] elements) {
        Iterator<T> iterator = Arrays.stream(elements).iterator();
        if (!iterator.hasNext()) return true;
        T element = iterator.next();
        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (element == null || element.compareTo(nextElement) > 0) return false;
            element = nextElement;
        }
        return true;
    }
}
