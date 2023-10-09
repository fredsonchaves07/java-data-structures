package com.fredson.datastructures.queue;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.iterator.QueueIterator;
import com.fredson.models.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> node;

    private Node<T> headNode;

    private Iterator<T> iterator;

    private int length;

    public LinkedQueue() {
        node = null;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            headNode = newNode;
            node = headNode;
        } else {
            Node<T> nodeAux = node;
            nodeAux.setNextNode(newNode);
            node = newNode;
        }
        length += 1;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T element = headNode.getElement();
        headNode = headNode.getNextNode();
        length -= 1;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return headNode.getElement();
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
    public void clear() {
        headNode = null;
        node = null;
        length = 0;
    }

    @Override
    public Iterator<T> iterator() {
        if (iterator != null)
            return iterator;
        iterator = new QueueIterator<>(this);
        return iterator;
    }

    @Override
    public Queue<T> clone() {
        Queue<T> queue;
        try {
            queue = (Queue<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            queue = new ArrayQueue<>();
        }
        return queue;
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
