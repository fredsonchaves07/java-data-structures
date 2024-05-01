package com.fredson.datastructures.list;

import com.fredson.models.Node;

import java.util.ArrayList;

public class CircularLinkedList <T extends Comparable<T>> extends LinkedList<T> {

    public CircularLinkedList() {
        super();
    }

    @Override
    public void push(T element) {
        super.push(element);
        if (tailNode.getNextNode() != headNode && !tailNode.equals(headNode))
            insertCircularNode();
    }

    @Override
    public void push(T element, int index) {
        super.push(element, index);
        if (tailNode.getNextNode() != headNode && !tailNode.equals(headNode))
            insertCircularNode();
    }

    @Override
    public void remove(T element) {
        super.remove(element);
        if (tailNode.getNextNode() != headNode && !tailNode.equals(headNode))
            insertCircularNode();
    }

    @Override
    public void remove(int index) {
        super.remove(index);
        if (tailNode.getNextNode() != headNode && !tailNode.equals(headNode))
            insertCircularNode();
    }

    private void insertCircularNode() {
        tailNode.setNextNode(new Node<>(headNode.getElement()));
    }

    @Override
    public String toString() {
        java.util.List<T> elements = new ArrayList<>();
        Node<T> currentNode = this.headNode;
        while (currentNode != null) {
            elements.add(currentNode.getElement());
            currentNode = currentNode.getNextNode();
            if (currentNode != null && currentNode.equals(headNode)) break;
        }
        return elements.toString();
    }
}
