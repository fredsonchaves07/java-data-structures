package com.fredson.datastructures;

import com.fredson.models.Node;

import java.util.ArrayList;

public class LinkedList <T> implements List<T> {

    private Node<T> node;

    private int length;
    
    public LinkedList(){
        node = null;
    }

    @Override
    public void push(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            node = newNode;
        } else {
            Node<T> currentNode = node;
            while (currentNode.getNextNode() != null) currentNode = currentNode.getNextNode();
            currentNode.setNextNode(newNode);
        }
        length += 1;
    }

    @Override
    public void push(T element, int index) {
        if (isEmpty()) {
            push(element);
        } else if (index == 0) {
            addElementFirstNode(element);
        } else if (index > length()) {
            addElementLastNode(element);
        } else {
            addElementIndexNode(element, index);
        }
    }

    private void addElementFirstNode(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> currentNode = node;
        newNode.setNextNode(currentNode);
        node = newNode;
        length += 1;
    }

    private void addElementLastNode(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> currentNode = node;
        while (currentNode.getNextNode() != null) {
            currentNode = node.getNextNode();
        }
        currentNode.setNextNode(newNode);
        length += 1;
    }

    private void addElementIndexNode(T element, int index) {
        Node<T> newNode = new Node<>(element);
        Node<T> currentNode = node;
        int contIndex = 1;
        while (currentNode != null) {
            if (contIndex == index) {
               Node<T> nodeAux = currentNode;
               Node<T> beforeNode = getBeforeNode(currentNode);
               currentNode = newNode;
               beforeNode.setNextNode(currentNode);
               currentNode.setNextNode(nodeAux);
               break;
            }
            contIndex += 1;
            currentNode = currentNode.getNextNode();
        }
        length += 1;
    }

    private Node<T> getBeforeNode(Node<T> node) {
        Node<T> currentNode = this.node;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getNextNode().equals(node)) return currentNode;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public void removeAt(int index){
//        Node<T> nodeCurrent;
//        if(index == 0){
//            nodeCurrent = this.head;
//            this.head = nodeCurrent.getNextNode();
//        } else {
//            Node<T> previous = this.getElementAt(index - 1);
//            nodeCurrent = previous.getNextNode();
//            previous.setNextNode(nodeCurrent.getNextNode());
//        }
//        this.count --;
    }

    public void insert(T element, int index){
//        if(index >= 0 && index <= this.count){
//            Node<T> nodeCurrent;
//            Node<T> node = new Node<>(element);
//            if(index == 0){
//                nodeCurrent = this.head;
//                node.setNextNode(nodeCurrent);
//                this.head = node;
//            } else {
//                Node<T> nodePrevious = this.getElementAt(index - 1);
//                nodeCurrent = nodePrevious.getNextNode();
//                node.setNextNode(nodeCurrent);
//                nodePrevious.setNextNode(node);
//            }
//            this.count ++;
//        }
    }

    protected Node<T> getElementAt(int index){
//        if(index >= 0 && index <= this.count){
//            Node<T> node = this.head;
//            for(int i = 0; i < index && node != null; i++){
//                node = node.getNextNode();
//            }
//            return node;
//        }
        return null;
    }

    @Override
    public void remove(T element){
        Node<T> currentNode = node;
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                Node<T> beforeNode = getBeforeNode(currentNode);
                Node<T> nextNode = currentNode.getNextNode();
                if (beforeNode != null) {
                    beforeNode.setNextNode(nextNode);
                } else {
                    this.node = nextNode;
                }
                length -= 1;
                break;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    @Override
    public void remove(int index) {

    }


    public int indexOf(T element){
//        Node<T> node = this.head;
//        for(int i = 0; i < this.count && node != null; i ++){
//            if(node.getElement().equals(element)){
//                return i;
//            }
//            node = node.getNextNode();
//        }
        return -1;
    }

    @Override
    public T getElement(int index) {
        return null;
    }

    @Override
    public T getElement(T element) {
        return null;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty(){
        return length() == 0;
    }

    public Node<T> getHead(){
//        return this.head;
        return null;
    }

    @Override
    public String toString() {
        java.util.List<T> elements = new ArrayList<>();
        Node<T> verifyElement = node;
        while (verifyElement != null) {
            elements.add(verifyElement.getElement());
            verifyElement = verifyElement.getNextNode();
        }
        return elements.toString();
    }
}
