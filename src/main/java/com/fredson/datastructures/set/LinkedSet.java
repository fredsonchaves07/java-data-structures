package com.fredson.datastructures.set;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
import com.fredson.models.Node;

public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    protected Node<T> headNode;

    protected Node<T> tailNode;

    protected int length;

    public LinkedSet(){}

    public LinkedSet(Set<T> set) {
        List<T> elements = set.values().clone();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            add(element);
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void add(T element) {
        if(!hasElement(element)) {
            if (isEmpty())
                addFirstNode(element);
            else
                addLastNode(element);
            length ++;
        }
    }

    private void addFirstNode(T element) {
        headNode = new Node<>(element);
        if (tailNode == null)
            tailNode = headNode;
    }

    private void addLastNode(T element) {
        Node<T> node = new Node<>(element);
        if (tailNode != null)
            tailNode.setNextNode(node);
        tailNode = node;
    }

    @Override
    public void delete(T element) {
        if (headNode.getElement().equals(element)) {
            headNode = headNode.getNextNode();
            length --;
        } else {
            Node<T> node = getNodeElement(element);
            if (node != null) {
                Node<T> beforeNode = getBeforeNodeElement(node);
                if (beforeNode != null) {
                    beforeNode.setNextNode(node.getNextNode());
                }
                node = null;
                length --;
            }
        }
    }

    public Node<T> getNodeElement(T element) {
        Node<T> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public Node<T> getBeforeNodeElement(Node<T> node) {
        Node<T> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.getNextNode().equals(node)) {
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    @Override
    public boolean hasElement(T element) {
        if (isEmpty()) return false;
        if (headNode != null && headNode.getElement().equals(element)) return true;
        if (tailNode != null && tailNode.getElement().equals(element)) return true;
        Node<T> currentNode = headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) return true;
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    @Override
    public void clear() {
        headNode = null;
        tailNode = null;
        length = 0;
    }

    @Override
    public List<T> values() {
        List<T> list = new ArrayList<>();
        Node<T> currentNode = headNode;
        while (currentNode != null) {
            list.push(currentNode.getElement());
            currentNode = currentNode.getNextNode();
        }
        return list;
    }

    @Override
    public Set<T> union(Set<T> set) {
        Set<T> unionSet = new LinkedSet<>(set);
        List<T> elements = values();
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            unionSet.add(element);
        }
        return unionSet;
    }

    @Override
    public Set<T> intersection(Set<T> set) {
        Set<T> intersectionSet = new LinkedSet<>();
        List<T> elements = getListElementsOfSmallerSet(set);
        Set<T> setHasElement = getBigSet(set);
        while (elements.iterator().hasNext()) {
            T element = elements.iterator().next();
            if (setHasElement.hasElement(element)) intersectionSet.add(element);
        }
        return intersectionSet;
    }

    private List<T> getListElementsOfSmallerSet(Set<T> otherSet) {
        if (otherSet.length() < length) return otherSet.values();
        return values();
    }

    private Set<T> getBigSet(Set<T> otherSet) {
        if (otherSet.length() < length) return otherSet;
        return this;
    }

    @Override
    public Set<T> difference(Set<T> set) {
        Set<T> differenceSet = new LinkedSet<>();
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
        java.util.List<T> elements = new java.util.ArrayList<>();
        Node<T> currentNode = this.headNode;
        while (currentNode != null) {
            elements.add(currentNode.getElement());
            currentNode = currentNode.getNextNode();
        }
        return elements.toString();
    }
}
