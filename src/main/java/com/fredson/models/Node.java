package com.fredson.models;

public class Node<T> {
    
    private final T element;

    private Node<T> nextNode;

    public Node(T element) {
        this.element = element;
        this.nextNode = null;
    }

    public Node(T element, Node<T> next) {
        this.element = element;
        this.nextNode = next;
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
}