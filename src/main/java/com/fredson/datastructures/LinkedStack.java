package com.fredson.datastructures;

import com.fredson.models.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> node;

    private int length;

    public LinkedStack() {
        node = null;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNextNode(node);
        node = newNode;
        length += 1;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T element = node.getElement();
        node = node.getNextNode();
        length -= 1;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return node.getElement();
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public String toString() {
        List<T> elements = new ArrayList<>();
        Node<T> verifyElement = node;
        while (verifyElement != null) {
            elements.add(verifyElement.getElement());
            verifyElement = verifyElement.getNextNode();
        }
        return elements.toString();
    }
}
