package com.fredson.datastructures.set;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;

public class HashSet <T> implements Set<T> {

    private List<T> elements = new ArrayList<>();

    private int hashCode = 0;

    public HashSet() {}

    public HashSet(Set<T> set) {
        List<T> elements = set.values().clone();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            add(element);
        }
    }

    @Override
    public int length() {
        return elements.length();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private int hashCode(T element) {
        if (element instanceof Number) return ((Number) element).shortValue();
        int hash = 0;
        String keyString = element.toString();
        for (int i = 0; i < keyString.length(); i ++) {
            hash += keyString.charAt(i);
        }
        return hash % 37;
    }


    @Override
    public void add(T element) {
        if (element == null) return;
        if(!hasElement(element)) elements.push(element, hashCode(element));
    }

    @Override
    public void delete(T element) {
        if (element == null) return;
        if (hasElement(element)) elements.remove(hashCode(element));
    }

    @Override
    public boolean hasElement(T element) {
        if (isEmpty()) return false;
        if (element == null) return false;
        return elements.getElement(hashCode(element)) != null;
    }

    @Override
    public void clear() {
        elements = new ArrayList<>();
    }

    @Override
    public List<T> values() {
        return elements.clone();
    }

    @Override
    public Set<T> union(Set<T> set) {
        Set<T> unionSet = new ListSet<>(set);
        List<T> elements = values();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            unionSet.add(element);
        }
        return unionSet;
    }

    @Override
    public Set<T> intersection(Set<T> set) {
        Set<T> intersectionSet = new ListSet<>();
        List<T> elements = getListElementsOfSmallerSet(set);
        Set<T> setHasElement = getBigSet(set);
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            if (setHasElement.hasElement(element)) intersectionSet.add(element);
        }
        return intersectionSet;
    }

    private List<T> getListElementsOfSmallerSet(Set<T> otherSet) {
        if (otherSet.length() < elements.length()) return otherSet.values();
        return values();
    }

    private Set<T> getBigSet(Set<T> otherSet) {
        if (otherSet.length() < elements.length()) return otherSet;
        return this;
    }

    @Override
    public Set<T> difference(Set<T> set) {
        Set<T> differenceSet = new ListSet<>();
        List<T> elements = values();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            if (!set.hasElement(element)) differenceSet.add(element);
        }
        return differenceSet;
    }

    @Override
    public boolean isSubSetOf(Set<T> set) {
        if (length() > set.length()) return false;
        List<T> elements = values();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            if (!set.hasElement(element)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
