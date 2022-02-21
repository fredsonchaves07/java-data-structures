package com.fredson.datastructures;

import java.util.Arrays;

public class Vector<T> {

    private T[] elements;
    private Integer length;

    public Vector(int capacity) {
        this.elements = (T[]) new Object[capacity];
        length = 0;
    }

    public boolean push(T element){
        if (isFull()) increaseCapacity();
        this.elements[length] = element;
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
            return false;
        }
        return true;
    }

    public T getElement(int position) {
        try {
            return elements[position];
        } catch (ArrayIndexOutOfBoundsException error) {
            return null;
        }
    }

    public int lastIndexOf(T element) {
        for (int i = length - 1; i >= 0; i --) {
            if (elements[i].equals(element)) return i;
        }
        return - 1;
    }

    public Boolean contain(T element) {
        for (Object elementVector : elements) {
            if (elementVector != null && elementVector.equals(element)) return true;
        }
        return false;
    }

    public Boolean remove(int position) {
        try {
            for (int i = position; i <= length - 1; i ++) {
                elements[i] = elements[i + 1];
            }
            length --;
        } catch (ArrayIndexOutOfBoundsException error) {
            return false;
        }
        return true;
    }

    public Boolean remove(T element) {
        for (int i = 0; i <= length; i ++) {
            if (element.equals(getElement(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private boolean isFull() { return length >= elements.length; }

    private void increaseCapacity() {
        if (length == elements.length) {
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            for (int i = 0; i < length; i ++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
