package com.fredson.datastructures.queue;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.iterator.QueueIterator;

import java.util.Arrays;
import java.util.Objects;

public class ArrayQueue<T> implements Queue<T> {

    private static final int MAX_LENGTH_ELEMENTS = 10;

    private T[] elements;

    private int length;

    private int head;

    private Iterator<T> iterator;

    public ArrayQueue() {
        this(MAX_LENGTH_ELEMENTS);
    }

    public ArrayQueue(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    public ArrayQueue(Queue<T> queue) {
        this(queue.length());
        while (!queue.isEmpty()) {
            this.enqueue(queue.dequeue());
        }
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) increaseCapacity();
        elements[length] = element;
        length ++;
        if (length() == 1) head = 0;
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
        if (isEmpty()) return null;
        T element = elements[head];
        head ++;
        length --;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return this.elements[head];
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
    public Iterator<T> iterator() {
        if (iterator != null)
            return iterator;
        iterator = new QueueIterator<>(this);
        return iterator;
    }

    @Override
    public Queue<T> clone() {
        Queue<T> queue;
        try {
            queue = (Queue<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            queue = new ArrayQueue<>();
        }
        return queue;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements).filter(Objects::nonNull).toList().toString();
    }
}
