package com.fredson.models;

public record Table<E, T>(E key, T value) implements Comparable<Table<E, T>>{

    @Override
    public String toString() {
        return "{'" + key.toString() + "':" + value.toString() + "}";
    }

    @Override
    public int compareTo(Table<E, T> o) {
        if (o.equals(this)) return 0;
        return -1;
    }
}
