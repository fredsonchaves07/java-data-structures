package com.fredson.datastructures;

import java.util.Arrays;
import java.util.Objects;

public class StaticDatastructures <T>{

    protected T[] elements;
    protected int length;

    public StaticDatastructures(int capacity) {
        elements = (T[]) new Object[capacity];
        length = 0;
    }

    public StaticDatastructures() {
        this(10);
    }

    protected boolean push(T element){
        if (isFull()) increaseCapacity();
        elements[length] = element;
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

    protected int lastIndexOf(T element) {
        for (int i = length - 1; i >= 0; i --) {
            if (elements[i].equals(element)) return i;
        }
        return - 1;
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
            T[] newElements = (T[]) new Object[elements.length * 2];
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
