package com.fredson.models;

public record KeyValue<E, T>(E key, T value) implements Comparable<KeyValue<E, T>>{

    @Override
    public String toString() {
        return "{'" + key.toString() + "':" + value.toString() + "}";
    }

    @Override
    public int compareTo(KeyValue<E, T> o) {
        if (o.equals(this)) return 0;
        return -1;
    }
}
