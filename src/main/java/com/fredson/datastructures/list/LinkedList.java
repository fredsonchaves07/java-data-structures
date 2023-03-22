package com.fredson.datastructures.list;

import com.fredson.models.Node;

import java.util.ArrayList;
import java.util.Objects;

public class LinkedList<T> implements List<T> {

    private Node<T> headNode;

    private Node<T> tailNode;

    protected int length;
    
    public LinkedList() {
        clear();
    }

    @Override
    public void push(T element) {
        if (isEmpty()) addElementFirstNode(element);
        else addElementLastNode(element);
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
        headNode = new Node<>(element);
        if (tailNode == null) tailNode = headNode;
        length += 1;
    }

    private void addElementLastNode(T element) {
        Node<T> node = new Node<>(element);
        if (headNode == tailNode) {
            tailNode = node;
            headNode.setNextNode(node);
        } else {
            tailNode.setNextNode(node);
            tailNode = node;
        }
        currentNode.setNextNode(newNode);
        length += 1;
    }

    private void addElementIndexNode(T element, int index) {
        Node<T> newNode = new Node<>(element);
        Node<T> currentNode = headNode;
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
        Node<T> currentNode = headNode;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getNextNode().equals(node)) return currentNode;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    @Override
    public void remove(T element) {
        if (headNode.getElement().equals(element)) removeElementFirstNode();
        else if (tailNode.getElement().equals(element)) removeElementLastNode();
        else removeElementNode(element);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length()) throw new IndexOutOfBoundsException();
        if (index == 0){
            removeElementFirstNode();
        } else if (index == length() - 1) {
            removeElementLastNode();
        } else {
            removeElementIndexNode(index);
        }
    }

    private void removeElementFirstNode() {
        headNode = headNode.getNextNode();
        length -= 1;
    }

    private void removeElementLastNode() {
        tailNode = getBeforeNode(tailNode);
        if (tailNode != null) tailNode.setNextNode(null);
        length -= 1;
    }

    private void removeElementNode(T element) {
        Node<T> currentNode = headNode;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getElement().equals(element)) {
                Objects.requireNonNull(getBeforeNode(currentNode)).setNextNode(currentNode.getNextNode());
                length -= 1;
            }
            currentNode = currentNode.getNextNode();
        }
        if (currentNode.getNextNode() == null) {
            T element = currentNode.getElement();
            remove(element);
        }
    }

    private void removeElementIndexNode(int index) {
        Node<T> currentNode = headNode;
        int contIndex = 0;
        while (currentNode != null) {
            if (contIndex == index) {
                T element = currentNode.getElement();
                remove(element);
            }
            currentNode = currentNode.getNextNode();
            contIndex += 1;
        }
    }

    @Override
    public int indexOf(T element) {
        Node<T> currentNode = headNode;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                return index;
            }
            currentNode = currentNode.getNextNode();
            index += 1;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T getElement(int index) {
        Node<T> currentNode = headNode;
        int contIndex = 0;
        while (currentNode != null) {
            if (index == contIndex) {
                return currentNode.getElement();
            }
            currentNode = currentNode.getNextNode();
            contIndex += 1;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T getElement(T element) {
        Node<T> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) return currentNode.getElement();
            currentNode = currentNode.getNextNode();
        }
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

    @Override
    public void clear() {
        if (headNode != null) clear(headNode);
        headNode = null;
        length = 0;
    }

    private void clear(Node<T> node) {
        if (node.getNextNode() != null) {
            clear(node.getNextNode());
        }
         node.setNextNode(null);
    }

    @Override
    public String toString() {
        java.util.List<T> elements = new ArrayList<>();
        Node<T> verifyElement = headNode;
        while (verifyElement != null) {
            elements.add(verifyElement.getElement());
            verifyElement = verifyElement.getNextNode();
        }
        return elements.toString();
    }
}
