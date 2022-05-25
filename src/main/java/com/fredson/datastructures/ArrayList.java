package com.fredson.datastructures;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {

    private T[] elements;

    protected int length;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public boolean push(T element) {
        if (isFull()) increaseCapacity();
        elements[length] = element;
        length ++;
        return  true;
    }

    private boolean isFull() {
        return length >= elements.length;
    }

    private void increaseCapacity() {
        if (length == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, length);
            elements = newElements;
        }
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public boolean insert(T element, int index) {
        return false;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public T getElementAt(int index) {
        return null;
    }

    @Override
    public T getElement(T element) {
        return null;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements).filter(Objects::nonNull).toList().toString();
    }
}
