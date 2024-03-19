package com.fredson.datastructures.map;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
import com.fredson.models.Table;

public class DefaultMap<E, T> implements Map<E, T> {

    private final List<Table<E, T>> tables = new ArrayList<>();

    public DefaultMap() {

    }

    @Override
    public int length() {
        return tables.length();
    }

    @Override
    public boolean isEmpty() {
        return tables.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    @Override
    public void set(E key, T value) {
        if (isEmpty() || (!hasKey(key) && key != null && value != null)) {
            Table<E, T> table = new Table<>(key, value);
            tables.push(table);
        }
        else if (hasKey(key) && value != null) {
            setInExistingKey(key, value);
        }
    }

    private void setInExistingKey(E key, T value) {
        List<Table<E, T>> tables = this.tables.clone();
        if (tables.iterator().hasNext()) {
            Table<E, T> table = tables.iterator().next();
            E nextKey = table.key();
            if (nextKey.equals(key)) {
                tables.push(new Table<>(key, value), tables.indexOf(table));
            }
        }
    }

    @Override
    public void remove(E key) {

    }

    @Override
    public boolean hasKey(E key) {
        if (key == null) return false;
        if (isEmpty()) return false;
        List<Table<E, T>> tables = this.tables.clone();
        while (tables.iterator().hasNext()) {
            E nextKey = tables.iterator().next().key();
            if(nextKey.equals(key)) {
                return true;
            };
        }
        return false;
    }

    @Override
    public T get(E key) {
        if (hasKey(key)) {
            List<Table<E, T>> tables = this.tables.clone();
            while (tables.iterator().hasNext()) {
                Table<E, T> table = tables.iterator().next();
                if(table.key().equals(key)) {
                    return table.value();
                }
            }
        }
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public List<T> values() {
        return null;
    }

    @Override
    public List<E> keys() {
        return null;
    }

    @Override
    public Iterator<T> forEach() {
        return null;
    }

    @Override
    public String toString() {
        return tables.toString();
    }
}
