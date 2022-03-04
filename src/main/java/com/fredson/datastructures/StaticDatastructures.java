package com.fredson.datastructures;

import java.util.Arrays;
import java.util.Objects;

public class StaticDatastructures <T>{

    protected T[] elements;
    protected Integer length;

    public StaticDatastructures(int capacity) {
        this.elements = (T[]) new Object[capacity];
        length = 0;
    }

    public StaticDatastructures() {
        this(10);
    }

    protected boolean push(T element){
        if (isFull()) increaseCapacity();
        this.elements[length] = element;
        length ++;
        return  true;
    }

    protected boolean push(T element, int position) {
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

    protected T getElement(int position) {
        try {
            return elements[position];
        } catch (ArrayIndexOutOfBoundsException error) {
            return null;
        }
    }

    protected boolean remove(int position) {
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

    protected boolean remove(T element) {
        for (int i = 0; i <= length; i ++) {
            if (element.equals(getElement(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    protected int lastIndexOf(T element) {
        for (int i = length - 1; i >= 0; i --) {
            if (elements[i].equals(element)) return i;
        }
        return - 1;
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

    protected boolean isFull() { return length >= elements.length; }

    protected void increaseCapacity() {
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
        return Arrays.stream(elements).filter(Objects::nonNull).toList().toString();
    }
}
