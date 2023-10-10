package com.fredson.datastructures.stack;


import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.iterator.StackIterator;

import java.util.Arrays;
import java.util.Objects;

public class ArrayStack<T> implements Stack<T> {

    private T[] elements;

    private int length;

    private Iterator<T> iterator;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    public ArrayStack(Stack<T> stack) {
        this(stack.length());
        while (!stack.isEmpty()) {
            this.push(stack.pop());
        }
    }

    @Override
    public void push(T element) {
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
    public T pop() {
        if (isEmpty()) return null;
        return elements[--length];
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return elements[length - 1];
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
        if (iterator != null)
            return iterator;
        iterator = new StackIterator<>(this);
        return iterator;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements).filter(Objects::nonNull).toList().toString();
    }

    @Override
    public Stack<T> clone() {
        Stack<T> stack;
        try {
            stack = (Stack<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            stack = new ArrayStack<>();
        }
        return stack;
    }
}
