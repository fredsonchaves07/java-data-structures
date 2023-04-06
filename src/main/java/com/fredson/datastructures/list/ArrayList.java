package com.fredson.datastructures.list;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {

    private T[] elements;

    private int length;

    private int capacity;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) {
        if (isFull())
            increaseCapacity();
        for (int index = capacity - 1; index >= 0; index --) {
            if (elements[index] != null) {
                elements[index + 1] = element;
                break;
            }
            if (elements[index] == null && index == 0) {
                elements[index] = element;
            }
        }
        length += 1;
    }

    @Override
    public void push(T element, int index) {
        if (isFull() || index > elements.length)
            increaseCapacity();
        if (isEmpty() || index == 0)
            addElementFirstIndex(element, index);
        else {
            addElementIndex(element, index);
        }
    }

    private boolean isFull() {
        return length >= elements.length;
    }

    private void increaseCapacity() {
        capacity = elements.length * 2;
        T[] newElements = (T[]) new Object[capacity];
        System.arraycopy(elements, 0, newElements, 0, length);
        elements = newElements;
    }

    private void addElementFirstIndex(T element,int index) {
        if (isEmpty() || elements[index] == null) {
            elements[index] = element;
            length ++;
        } else {
            elements[index] = element;
        }
    }

    private void addElementIndex(T element, int index) {
        elements[index] = element;
        length ++;
    }

    @Override
    public void remove(T element) {
        for (int i = 0; i < elements.length; i ++) {
            if (elements[i] != null && elements[i].equals(element)) {
                elements[i] = null;
                length --;
            }

        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > length())
            throw new IndexOutOfBoundsException();
        for (int i = 0; i < capacity; i ++) {
            if (i == index) {
                if (elements[i] != null) {
                    elements[i] = null;
                }
                break;
            }
        }
        length --;
    }

    @Override
    public int indexOf(T element) {
        for (int index = 0; index < elements.length; index ++)
            if (elements[index] != null && elements[index].equals(element))
                return index;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T getElement(int index) {
        if (index >= length() || index < 0)
            throw new IndexOutOfBoundsException();
        return elements[index];
    }

    @Override
    public T getElement(T element) {
        for (T elementData : elements)
            if (elementData != null && elementData.equals(element))
                return elementData;
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

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i ++)
            elements[i] = null;
        capacity = 0;
        length = 0;
    }
}
