package com.fredson.datastructures;

import com.fredson.models.DoublyNode;
import com.fredson.models.Node;

public class DoublyLinkedList<T> extends LinkedList<T> {

    protected DoublyNode<T> headNode;

    protected DoublyNode<T> tailNode;

    public DoublyLinkedList() {
        super();
    }

    @Override
    public void push(T element) {
        if (isEmpty()) {
            addElementFirstNode(element);
        } else {
            addElementLastNode(element);
        }
    }

    @Override
    public void push(T element, int index) {
        if (isEmpty() || index == 0) {
            addElementFirstNode(element);
        } else if (index <= length() + 1) {
            addElementIndexNode(element, index);
        } else {
            addElementLastNode(element);
        }
    }

    private void addElementFirstNode(T element) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        if (headNode != null) {
            headNode.setPrevNode(doublyNode);
            doublyNode.setNextNode(headNode);
        }
        headNode = doublyNode;
        if (tailNode == null) tailNode = headNode;
        length += 1;
    }

    private void addElementLastNode(T element) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        tailNode.setNextNode(doublyNode);
        doublyNode.setPrevNode(tailNode);
        tailNode = doublyNode;
        length += 1;
    }

    private void addElementIndexNode(T element, int index) {
        DoublyNode<T> node = headNode;
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        for (int i = 0; i <= index; i ++) {
            if (i == index && node != tailNode) {
                doublyNode.setNextNode(node.getNextNode());
                doublyNode.setPrevNode(node.getPrevNode());
                node.getPrevNode().setNextNode(doublyNode);
                node = doublyNode;
            } else if (node.getNextNode() == null) {
                addAfterNode(doublyNode, (DoublyNode<T>) node.getPrevNode());
                addBeforeNode(doublyNode, tailNode);
                break;
            }
            node = (DoublyNode<T>) node.getNextNode();
        }
        length += 1;
    }

    private void addBeforeNode(DoublyNode<T> currentNode, DoublyNode<T> beforeNode) {
        currentNode.setNextNode(beforeNode);
        beforeNode.setPrevNode(currentNode);
    }

    private void addAfterNode(DoublyNode<T> currentNode, DoublyNode<T> afterNode) {
        afterNode.setNextNode(currentNode);
        currentNode.setPrevNode(afterNode);
    }

    @Override
    public void remove(T element) {
        if (length() == 1 && headNode.getElement().equals(element)) {
            removeElementAllNode();
        } else if (headNode.getElement().equals(element)) {
            removeElementFirstNode();
        } else if (tailNode.getElement().equals(element)) {
            removeElementLastNode();
        } else {
            removeElement(element);
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

    private void removeElementAllNode() {
        setNullHeadNode();
        setNullTailNode();
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

    private void removeElement(T element) {
        DoublyNode<T> nodeCurrent = headNode;
        while (nodeCurrent.getNextNode() != null) {
            if (nodeCurrent.getNextNode() != null && nodeCurrent.getElement().equals(element)) {
                DoublyNode<T> prevNode = (DoublyNode<T>) nodeCurrent.getPrevNode();
                DoublyNode<T> nextNode = (DoublyNode<T>) nodeCurrent.getNextNode();
                addAfterNode(nextNode, prevNode);
                length -= 1;
                nodeCurrent = null;
                break;
            }
            nodeCurrent = (DoublyNode<T>) nodeCurrent.getNextNode();
        }
    }

    private void removeElementIndexNode(int index) {
        int cont = 1;
        DoublyNode<T> nodeCurrent = (DoublyNode<T>) headNode.getNextNode();
        while (nodeCurrent != null) {
            if (cont == index) {
                DoublyNode<T> prevNode = (DoublyNode<T>) nodeCurrent.getPrevNode();
                DoublyNode<T> nextNode = (DoublyNode<T>) nodeCurrent.getNextNode();
                addBeforeNode(prevNode, nextNode);
                length -= 1;
                nodeCurrent = null;
                break;
            }
            cont += 1;
            nodeCurrent = (DoublyNode<T>) nodeCurrent.getNextNode();
        }
    }

    @Override
    public int indexOf(T element) {
        if (headNode.getElement().equals(element)) return 0;
        if (tailNode.getElement().equals(element)) return length() - 1;
        int cont = 1;
        DoublyNode<T> currentNode = (DoublyNode<T>) headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) break;
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
        Node<T> nodeCurrent = headNode.getNextNode();
        while (nodeCurrent != null) {
            if (nodeCurrent.getElement().equals(element)) return nodeCurrent.getElement();
            nodeCurrent = nodeCurrent.getNextNode();
        }
        return null;
    }

    @Override
    public T getElement(int index) {
        if (index == 0) return headNode.getElement();
        if (index == length() - 1) return tailNode.getElement();
        Node<T> nodeCurrent = headNode.getNextNode();
        int cont = 1;
        while (nodeCurrent != null) {
            if (cont == index) return nodeCurrent.getElement();
            cont += 1;
            nodeCurrent = nodeCurrent.getNextNode();
        }
        return null;
    }

    @Override
    public void clear() {
        if (headNode != null && tailNode != null) {
            while (headNode.getNextNode() != null) {
                DoublyNode<T> doublyNodeNext = (DoublyNode<T>) headNode.getNextNode();
                setNullHeadNode();
                setNullTailNode();
                headNode = doublyNodeNext;
            }
        }
        headNode = null;
        tailNode = null;
        length = 0;
    }

    private void setNullHeadNode() {
        headNode.setNextNode(null);
        headNode.setPrevNode(null);
    }

    private void setNullTailNode() {
        tailNode.setPrevNode(null);
        tailNode.setNextNode(null);
    }
}
