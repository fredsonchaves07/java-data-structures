package com.fredson.datastructures.map;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
import com.fredson.models.KeyValue;

public class DefaultMap<E, T> implements Map<E, T> {

    private final List<KeyValue<E, T>> keysValues = new ArrayList<>();

    public DefaultMap() {

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
        if (isEmpty() || !hasKey(key)) {
            KeyValue<E, T> keyValue = new KeyValue<>(key, value);
            keysValues.push(keyValue);
        }
        else if (hasKey(key) && value != null) {
            setInExistingKey(key, value);
        }
    }

    private void setInExistingKey(E key, T value) {
        List<KeyValue<E, T>> keysValues = this.keysValues.clone();
        if (keysValues.iterator().hasNext()) {
            KeyValue<E, T> keyValue = keysValues.iterator().next();
            E nextKey = keyValue.key();
            if (nextKey.equals(key)) {
                keysValues.push(new KeyValue<>(key, value), keysValues.indexOf(keyValue));
            }
        }
    }

    @Override
    public void remove(E key) {
        if (hasKey(key)) {
            while (keysValues.iterator().hasNext()) {
                KeyValue<E, T> keyValue = keysValues.iterator().next();
                E nextKey = keyValue.key();
                if(nextKey.equals(key)) {
                    keysValues.remove(keyValue);
                }
            }
        }
    }

    @Override
    public boolean hasKey(E key) {
        if (key == null) return false;
        if (isEmpty()) return false;
        List<KeyValue<E, T>> keysValues = this.keysValues.clone();
        while (keysValues.iterator().hasNext()) {
            E nextKey = keysValues.iterator().next().key();
            if(nextKey.equals(key)) {
                return true;
            };
        }
        return false;
    }

    @Override
    public T get(E key) {
        if (hasKey(key)) {
            List<KeyValue<E, T>> keyValues = this.keysValues.clone();
            while (keyValues.iterator().hasNext()) {
                KeyValue<E, T> keyValue = keyValues.iterator().next();
                if(keyValue.key().equals(key)) {
                    return keyValue.value();
                }
            }
        }
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
        return this.keysValues.clone().iterator();
    }

    @Override
    public String toString() {
        return keysValues.toString();
    }
}
