package com.fredson.datastructures.set;

import com.fredson.datastructures.DataStructure;
import com.fredson.datastructures.list.List;

public interface Set<T> extends DataStructure<T> {

    void add(T element);

    void delete(T element);

    boolean hasElement(T element);

    void clear();

    List<T> values();

    Set<T> union(Set<T> set);

    Set<T> intersection(Set<T> set);

    Set<T> difference(Set<T> set);

    boolean isSubSetOf(Set<T> set);
}
