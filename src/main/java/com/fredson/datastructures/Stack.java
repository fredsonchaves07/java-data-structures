package com.fredson.datastructures;


public class Stack<T> extends StaticDatastructures<T>{

    public Stack() {
        super();
    }

    public Stack(int capacity) {
        super(capacity);
    }

    public boolean push(T element) {
        return super.push(element);
    }

    public T pop() {
        if (isEmpty()) return null;
        return elements[--length];
    }

    public T peek() {
        if (isEmpty()) return null;
        return elements[length - 1];
    }
}
