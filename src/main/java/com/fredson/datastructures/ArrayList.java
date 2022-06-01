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
        for (int i = 0; i < elements.length; i ++) {
            if (elements[i] != null && elements[i].equals(element)) {
                if (elements.length - (i + 1) >= 0)
                    System.arraycopy(elements, i + 1, elements, i + 1 - 1, elements.length - (i + 1));
                length --;
            }

        }
    }

    @Override
    public void remove(int index) {
        if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
        if (elements.length - (index + 1) >= 0)
            System.arraycopy(elements, index + 1, elements, index + 1 - 1, elements.length - (index + 1));
        length --;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < elements.length; i ++) {
            if (elements[i] != null && elements[i].equals(element)) return i;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T getElement(int index) {
        if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
        return elements[index];
    }

    @Override
    public T getElement(T element) {
        for (T elementData : elements) {
            if (elementData != null && elementData.equals(element)) return elementData;
        }
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
