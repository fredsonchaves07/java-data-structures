package com.fredson.datastructures;


public class ArrayStack<T> implements Stack<T>{

    private T[] elements;

    protected int length;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        elements = (T[]) new Object[capacity];
        length = 0;
    }

    @Override
    public boolean push(T element) {
        if (isFull()) increaseCapacity();
        elements[length] = element;
        length ++;
        return  true;
    }

    public boolean push(T element, int position) {
        if (isFull()) increaseCapacity();
        try {
            if (length + 1 - position >= 0)
                System.arraycopy(elements, position, elements, position + 1, length + 1 - position);
            elements[position] = element;
            length ++;
        } catch (ArrayIndexOutOfBoundsException error){
            throw new Error(error.getMessage());
        }
        return true;
    }

    private boolean isFull() { return length >= elements.length; }

    private void increaseCapacity() {
        if (length == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < length; i ++) {
                newElements[i] = elements[i];
            }
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
}
