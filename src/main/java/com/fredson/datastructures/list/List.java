package com.fredson.datastructures.list;

import com.fredson.datastructures.DataStructure;
import com.fredson.datastructures.iterator.Iterator;

public interface List<T extends Comparable<T>> extends Cloneable, DataStructure<T> {

    void push(T element);

    void push(T element, int index);

    void remove(T element);

    void remove(int index);

    int indexOf(T element);

    T getElement(int index);

    T getElement(T element);

    void clear();

    Iterator<T> iterator();

    List<T> clone();

    default T[] toArray() {
        T[] array = (T[]) new Comparable[length()];
        for (int index = 0; index < length(); index++) {
            T element = getElement(index);
            if (element != null) {
                array[index] = element;
            }
        }
        return array;
    }

    @SafeVarargs
    static <E extends Comparable<E>> List<E> of(E... elements) {
        return new ArrayList<>(elements);
    }
}
