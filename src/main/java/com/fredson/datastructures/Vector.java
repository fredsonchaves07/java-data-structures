package com.fredson.datastructures;

import java.util.Arrays;
import java.util.Objects;

public class Vector<T> {

    private T[] elements;

    private int length;

    public Vector() {
        this(10);
    }

    public Vector(int capacity) {
        elements = (T[]) new Object[capacity];
        length = 0;
    }

    public boolean push(T element){
        if (isFull()) increaseCapacity();
        elements[length] = element;
        length ++;
        return true;
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

    public int lastIndexOf(T element) {
        for (int i = length - 1; i >= 0; i --) {
            if (elements[i].equals(element)) return i;
        }
        return - 1;
    }

    public T getElement(int position) {
        try {
            return elements[position];
        } catch (ArrayIndexOutOfBoundsException error) {
            return null;
        }
    }

    public boolean remove(T element) {
        for (int i = 0; i <= length; i ++) {
            if (element.equals(getElement(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int position) {
        try {
            if (length - position >= 0)
                System.arraycopy(elements, position + 1, elements, position, length - position);
            length --;
        } catch (ArrayIndexOutOfBoundsException error) {
            return false;
        }
        return true;
    }

    public boolean contain(T element) {
        for (Object elementVector : elements) {
            if (elementVector != null && elementVector.equals(element)) return true;
        }
        return false;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements).filter(Objects::nonNull).toList().toString();
    }
}
