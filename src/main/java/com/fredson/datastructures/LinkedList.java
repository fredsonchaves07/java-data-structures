package com.fredson.datastructures;

import com.fredson.models.Node;

import java.util.ArrayList;

public class LinkedList<T> implements List<T> {

    private Node<T> node;

    protected int length;
    
    public LinkedList() {
        clear();
    }

    @Override
    public void push(T element) {
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

    @Override
    public void remove(T element) {
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
        node = node.getNextNode();
        length -= 1;
    }

    private void removeElementLastNode() {
        Node<T> currentNode = node;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        if (currentNode.getNextNode() == null) {
            T element = currentNode.getElement();
            remove(element);
        }
    }

    private void removeElementIndexNode(int index) {
        Node<T> currentNode = node;
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
        Node<T> currentNode = node;
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
        Node<T> currentNode = node;
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
        Node<T> currentNode = node;
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
        if (node != null) clear(node);
        node = null;
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
        Node<T> verifyElement = node;
        while (verifyElement != null) {
            elements.add(verifyElement.getElement());
            verifyElement = verifyElement.getNextNode();
        }
        return elements.toString();
    }
}
