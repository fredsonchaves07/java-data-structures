package com.fredson.datastructures.queue;

import java.util.Arrays;
import java.util.Objects;

public class ArrayQueue<T> implements Queue<T> {

    private static final int MAX_LENGTH_ELEMENTS = 10;

    private T[] elements;

    private int length;

    public ArrayQueue() {
        this(MAX_LENGTH_ELEMENTS);
    }

    public ArrayQueue(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) increaseCapacity();
        elements[length] = element;
        length ++;
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
    public T dequeue() {
        T element = elements[0];
        elements[0] = null;
        length--;
        return element;
    }

    @Override
    public T peek() {
        return this.elements[0];
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i ++) {
            elements[i] = null;
        }
        length = 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements).filter(Objects::nonNull).toList().toString();
    }
}
