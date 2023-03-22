package com.fredson.models;

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
        return this.nextNode;
    }

    public void setNextNode(Node<T> node){
        this.nextNode = node;
    }

    public T getElement(){
        return this.element;
    }

    public int getIndex() {
        return index;
    }
}