package com.fredson.models;

public class DoublyNode<T> extends Node<T> {

    private Node<T> prevNode;

    public DoublyNode(T element, Node<T> prevNode, Node<T> nextNode) {
        super(element, nextNode);
        this.prevNode = prevNode;
    }

    public DoublyNode(T element) {
        super(element);
    }

    public Node<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<T> prev) {
        this.prevNode = prev;
    }
}
