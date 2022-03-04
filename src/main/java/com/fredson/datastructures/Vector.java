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

    public T getElement(int position) {
        return super.getElement(position);
    }

    public int lastIndexOf(T element) {
        return super.lastIndexOf(element);
    }

    public boolean contain(T element) {
        return super.contain(element);
    }

    public boolean remove(int position) {
        return super.remove(position);
    }

    public boolean remove(T element) {
        return super.remove(element);
    }
}
