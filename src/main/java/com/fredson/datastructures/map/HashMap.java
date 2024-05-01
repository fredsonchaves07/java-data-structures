package com.fredson.datastructures.map;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.LinkedList;
import com.fredson.datastructures.list.List;
import com.fredson.models.KeyValue;

public class HashMap<E extends Comparable<E>, T extends Comparable<T>> implements Map<E, T>{

    private final List<KeyValue<E, T>> keysValues = new LinkedList<>();

    public HashMap() {

    }

    private int hashCode(E key) {
        if (key instanceof Number) return ((Number) key).shortValue();
        int hash = 0;
        String keyString = key.toString();
        for (int i = 0; i < keyString.length(); i ++) {
            hash += keyString.charAt(i);
        }
        return hash % 37;
    }

    @Override
    public int length() {
        return keysValues.length();
    }

    @Override
    public boolean isEmpty() {
        return keysValues.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }


    @Override
    public void set(E key, T value) {
        if (key == null || value == null) return;
        int hashCode = hashCode(key);
        KeyValue<E, T> keyValue = new KeyValue<>(key, value);
        keysValues.push(keyValue, hashCode);
    }

    @Override
    public void remove(E key) {
        if (hasKey(key)) keysValues.remove(hashCode(key));
    }

    @Override
    public boolean hasKey(E key) {
        if (isEmpty()) return false;
        if (key == null) return false;
        return keysValues.getElement(hashCode(key)) != null;
    }

    @Override
    public T get(E key) {
        if (hasKey(key)) return keysValues.getElement(hashCode(key)).value();
        return null;
    }

    @Override
    public void clear() {
        keysValues.clear();
    }

    @Override
    public List<T> values() {
        List<T> list = new ArrayList<>();
        List<KeyValue<E, T>> keyValues = this.keysValues.clone();
        while (keyValues.iterator().hasNext()) {
            KeyValue<E, T> keyValue = keyValues.iterator().next();
            list.push(keyValue.value());
        }
        return list;
    }

    @Override
    public List<E> keys() {
        List<E> list = new ArrayList<>();
        List<KeyValue<E, T>> keyValues = this.keysValues.clone();
        while (keyValues.iterator().hasNext()) {
            KeyValue<E, T> keyValue = keyValues.iterator().next();
            list.push(keyValue.key());
        }
        return list;
    }

    @Override
    public List<KeyValue<E, T>> keysValues() {
        return keysValues.clone();
    }

    @Override
    public Iterator<KeyValue<E, T>> forEach() {
        return keysValues.clone().iterator();
    }

    @Override
    public String toString() {
        return keysValues.toString();
    }

    @Override
    public int compareTo(Map<E, T> o) {
        return 0;
    }
}
