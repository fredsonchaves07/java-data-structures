package com.fredson.datastructures.set;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;

import java.util.Arrays;
import java.util.Objects;

public class ArraySet<T> implements Set<T> {

    private T[] elements;

    private int length;

    private Iterator<T> iterator;

    public ArraySet() {
        this(10);
    }

    public ArraySet(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    public ArraySet(Set<T> set) {
        this(10);
        List<T> elements = set.values().clone();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            add(element);
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void add(T element) {
        if (!hasElement(element)) {
            if (isFull()) increaseCapacity();
            for (int index = elements.length - 1; index >= 0; index --) {
                if (elements[index] != null) {
                    elements[index + 1] = element;
                    break;
                }
                if (elements[index] == null && index == 0) {
                    elements[index] = element;
                }
            }
            length++;
        }
    }

    private boolean isFull() { return length >= elements.length; }

    private void increaseCapacity() {
        if (length == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, length);
            elements = newElements;
        }
    }

    @Override
    public void delete(T element) {
        if (hasElement(element)) {
            for (int i = 0; i < elements.length; i ++)
                if (elements[i] != null && elements[i].equals(element)) elements[i] = null;
            length --;
        }
    }

    @Override
    public boolean hasElement(T element) {
        if (isEmpty()) return false;
        for (T elementArray : elements)
            if (elementArray!= null && elementArray.equals(element)) return true;
        return false;
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[10];
        length = 0;
    }

    @Override
    public List<T> values() {
        return new ArrayList<>(elements);
    }

    @Override
    public Set<T> union(Set<T> set) {
        Set<T> unionSet = new ArraySet<>(set);
        List<T> elements = values().clone();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            unionSet.add(element);
        }
        return unionSet;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements).filter(Objects::nonNull).toList().toString();
    }
}
