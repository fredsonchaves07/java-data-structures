package com.fredson.datastructures;

import com.fredson.models.DoublyNode;
import com.fredson.models.Node;

public class DoublyLinkedList<T> extends LinkedList<T> {

    protected DoublyNode<T> headNode;

    protected DoublyNode<T> tailNode;

    private DoublyNode<T> doublyNode;

    public DoublyLinkedList() {
        super();
    }

    @Override
    public void push(T element) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        if (isEmpty()) {
            headNode = doublyNode;
        } else {
            DoublyNode<T> currentDoublyNode = headNode;
            while (currentDoublyNode.getNextNode() != null)
                currentDoublyNode = (DoublyNode<T>) currentDoublyNode.getNextNode();
            currentDoublyNode.setNextNode(doublyNode);
            doublyNode.setPrevNode(currentDoublyNode);
        }
        tailNode = doublyNode;
        length += 1;
    }

    @Override
    public void push(T element, int index) {
        if (isEmpty()) {
            push(element);
        } else if (index == 0) {
            addElementFirstNode(element);
        } else if (index <= length() + 1) {
            addElementIndexNode(element, index);
        } else {
            addElementLastNode(element);
        }
    }

    private void addElementFirstNode(T element) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        DoublyNode<T> currentNode = headNode;
        currentNode.setPrevNode(doublyNode);
        doublyNode.setNextNode(currentNode);
        headNode = doublyNode;
        while (currentNode != null) {
            if (currentNode.getNextNode() == null) {
                tailNode = currentNode;
                break;
            }
            currentNode = (DoublyNode<T>) currentNode.getNextNode();
        }
        length += 1;
    }

    private void addElementLastNode(T element) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        Node<T> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.equals(tailNode)) {
                tailNode = doublyNode;
                tailNode.setPrevNode(currentNode);
                currentNode.setNextNode(tailNode);
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        length += 1;
    }

    private void addElementIndexNode(T element, int index) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        DoublyNode<T> currentNode = headNode;
        int contIndex = 0;
        while (currentNode != null) {
            if (contIndex == index) {
                DoublyNode<T> prevNode = (DoublyNode<T>) currentNode.getPrevNode();
                doublyNode.setNextNode(currentNode);
                currentNode.setPrevNode(doublyNode);
                doublyNode.setPrevNode(prevNode);
                prevNode.setNextNode(doublyNode);
                currentNode = headNode;
                while (currentNode != null) {
                    if (currentNode.getNextNode() == null){
                        tailNode = currentNode;
                        break;
                    }
                    currentNode = (DoublyNode<T>) currentNode.getNextNode();
                }
                break;
            }
            contIndex += 1;
            currentNode = (DoublyNode<T>) currentNode.getNextNode();
        }
        if (currentNode == null) {
            DoublyNode<T> prevNode = (DoublyNode<T>) tailNode.getPrevNode();
            prevNode.setNextNode(doublyNode);
            doublyNode.setPrevNode(prevNode);
            doublyNode.setNextNode(tailNode);
            tailNode.setPrevNode(doublyNode);
        }
        length += 1;
    }

    @Override
    public void remove(T element) {
        DoublyNode<T> currentNode = headNode;
        while(currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                DoublyNode<T> prevNode = (DoublyNode<T>) currentNode.getPrevNode();
                DoublyNode<T> nextNode = (DoublyNode<T>) currentNode.getNextNode();
                if (prevNode == null) {
                    headNode = nextNode;
                }
                if (nextNode == null) {
                    tailNode = prevNode;
                }
                if (prevNode != null) {
                    prevNode.setNextNode(nextNode);
                }
                if (nextNode != null) {
                    nextNode.setPrevNode(prevNode);
                }
                length -= 1;
                break;
            }
            currentNode = (DoublyNode<T>) currentNode.getNextNode();
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length()) throw new IndexOutOfBoundsException();
        if (isEmpty()) return;
        if (index == 0) {
            removeElementFirstNode();
        } else if (index == length() - 1) {
            removeElementLastNode();
        } else {
            removeElementIndexNode(index);
        }
    }

    private void removeElementFirstNode() {
        headNode = (DoublyNode<T>) headNode.getNextNode();
        headNode.setPrevNode(null);
        length -= 1;
    }

    private void removeElementLastNode() {
        tailNode = (DoublyNode<T>) tailNode.getPrevNode();
        tailNode.setNextNode(null);
        length -= 1;
    }

    private void removeElementIndexNode(int index) {
        int cont = 0;
        DoublyNode<T> nodeCurrent = headNode;
        while (nodeCurrent != null) {
            if (cont == index) {
                DoublyNode<T> prevNode = (DoublyNode<T>) nodeCurrent.getPrevNode();
                DoublyNode<T> nextNode = (DoublyNode<T>) nodeCurrent.getNextNode();
                prevNode.setNextNode(nextNode);
                nextNode.setPrevNode(prevNode);
                break;
            }
            cont += 1;
            nodeCurrent = (DoublyNode<T>) nodeCurrent.getNextNode();
        }
        length -= 1;
    }

    @Override
    public int indexOf(T element){
        if (headNode.getElement().equals(element)) return 0;
        if (tailNode.getElement().equals(element)) return length() - 1;
        int cont = 0;
        DoublyNode<T> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)){
                break;
            }
            cont += 1;
            currentNode = (DoublyNode<T>) currentNode.getNextNode();
        }
        return cont;
    }

    @Override
    public String toString() {
        List<T> elements = new ArrayList<>();
        Node<T> nodeCurrent = headNode;
        while (nodeCurrent != null) {
            elements.push(nodeCurrent.getElement());
            nodeCurrent = nodeCurrent.getNextNode();
        }
        return elements.toString();
    }

    @Override
    public T getElement(T element) {
        if (headNode.getElement().equals(element)) return headNode.getElement();
        if (tailNode.getElement().equals(element)) return tailNode.getElement();
        Node<T> nodeCurrent = headNode;
        T findElement = null;
        while (nodeCurrent != null) {
            if (nodeCurrent.getElement().equals(element)) {
                findElement = nodeCurrent.getElement();
                break;
            }
            nodeCurrent = nodeCurrent.getNextNode();
        }
        return findElement;
    }

    @Override
    public T getElement(int index) {
        if (index == 0) return headNode.getElement();
        if (index == length() - 1) return tailNode.getElement();
        Node<T> nodeCurrent = headNode;
        int cont = 0;
        while (nodeCurrent != null) {
            if (cont == index) return nodeCurrent.getElement();
            cont += 1;
            nodeCurrent = nodeCurrent.getNextNode();
        }
        throw new IndexOutOfBoundsException();
    }
}
