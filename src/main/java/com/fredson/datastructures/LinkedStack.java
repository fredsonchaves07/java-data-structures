package com.fredson.datastructures;

import com.fredson.models.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedStack<T> {

    Node<T> node;

    private int length;

    public LinkedStack() {
        node = null;
    }

    public boolean push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNextNode(node);
        node = newNode;
        length += 1;
        return true;
    }

    public T pop() {
        if (isEmpty()) return null;
        T element = node.getElement();
        node = node.getNextNode();
        length -= 1;
        return element;
    }

    public T peek() {
        if (isEmpty()) return null;
        return node.getElement();
    }

    public boolean isEmpty() {
        return length() == 0;
    }

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
