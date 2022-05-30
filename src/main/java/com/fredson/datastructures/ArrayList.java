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
    public void push(T element) {
        if (isFull()) increaseCapacity();
        elements[length] = element;
        length ++;
    }

    @Override
    public void push(T element, int index) {
        if (isFull()) increaseCapacity();
        if (index > elements.length) increaseCapacity();
        elements[index] = element;
        length ++;
    }

    private boolean isFull() {
        return length >= elements.length;
    }

    private void increaseCapacity() {
        T[] newElements = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, length);
        elements = newElements;
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public void removeAt(int index) {

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
        return length;
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
