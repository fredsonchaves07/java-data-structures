package com.fredson.datastructures;

public class Vector<T> extends StaticDatastructures<T>{

    public Vector() {
        super();
    }

    public Vector(int capacity) {
       super(capacity);
    }

    public boolean push(T element){
        return super.push(element);
    }

    public boolean push(T element, int position) {
        return super.push(element, position);
    }

    public int lastIndexOf(T element) {
        return super.lastIndexOf(element);
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
            for (int i = position; i <= length - 1; i ++) {
                elements[i] = elements[i + 1];
            }
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
}
