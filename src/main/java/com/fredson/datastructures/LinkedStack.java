package com.fredson.datastructures;

import com.fredson.models.Node;

public class LinkedStack<T> {

    Node<T> node;

    public LinkedStack() {
        node = null;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNextNode(node);
        node = newNode;
    }

    public T push() {
        if (isEmpty()) return null;
        T element = node.getElement();
        node = node.getNextNode();
        return element;
    }

    public T peek() {
        if (isEmpty()) return null;
        return node.getElement();
    }

    public boolean isEmpty() {
        return node == null;
    }
}
