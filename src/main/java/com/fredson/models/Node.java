package com.fredson.models;

import java.util.Objects;

public class Node<T> {
    
    private final T element;

    private Node<T> nextNode;

    private int index;

    public Node(T element) {
        this.element = element;
        this.nextNode = null;
        this.index = 0;
    }

    public Node(T element, Node<T> next) {
        this.element = element;
        this.nextNode = next;
        this.index = 0;
    }

    public Node(T element, int index) {
        this.element = element;
        this.nextNode = null;
        this.index = index;
    }

    public Node(T element, Node<T> nextNode, int index) {
        this.element = element;
        this.nextNode = nextNode;
        this.index = index;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public void setNextNode(Node<T> next){
        nextNode = next;
    }

    public T getElement(){
        return element;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return getElement().equals(node.getElement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElement());
    }
}