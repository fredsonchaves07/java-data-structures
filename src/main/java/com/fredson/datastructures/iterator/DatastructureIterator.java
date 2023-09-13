package com.fredson.datastructures.iterator;

public abstract class DatastructureIterator<T> implements Iterator {

    protected int size;

    public DatastructureIterator() {}

    protected abstract boolean hasLastElement();

    protected abstract void setLastDatastructureElement();
}
