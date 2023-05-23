package com.fredson.datastructures.sequence;

import java.util.Arrays;
import java.util.Iterator;

public class Search {

    public static <T extends Comparable<T>> T binarySearch(T[] elements, T element) {
        if (!Search.isSorted(elements))
            throw new RuntimeException("List is not ordered");
        int firstIndex = 0;
        int lastIndex = elements.length - 1;
        return binarySearch(elements, element, firstIndex, lastIndex);
    }

    private static <T extends Comparable<T>> T binarySearch(T[] elements, T element, int firstIndex, int lastIndex) {
        int lastIndexPos = lastIndex;
        int firstIndexPos = firstIndex;
        if (firstIndexPos == elements.length || lastIndex == 0 )
            return null;
        int midleIndex = (lastIndexPos + firstIndexPos) / 2;
        if ((midleIndex == lastIndex || midleIndex == firstIndex) && firstIndex > lastIndex)
            return null;
        if (elements[midleIndex].equals(element))
            return element;
        else if (elements[midleIndex].compareTo(element) < 0) {
            firstIndexPos = midleIndex + 1;
            return binarySearch(elements, element, firstIndexPos, lastIndexPos);
        } else if (elements[midleIndex].compareTo(element) > 0) {
            lastIndexPos = midleIndex - 1;
            return binarySearch(elements, element, firstIndexPos, lastIndexPos);
        }
        return null;
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] elements) {
        Iterator<T> iterator = Arrays.stream(elements).iterator();
        if (!iterator.hasNext())
            return true;
        T element = iterator.next();
        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (element == null || element.compareTo(nextElement) > 0)
                return false;
            element = nextElement;
        }
        return true;
    }
}
