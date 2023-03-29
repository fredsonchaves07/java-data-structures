package com.fredson.datastructures.list;

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
        if (isEmpty())
            addElementFirstNode(element);
        else
            addElementLastNode(element);
    }

    @Override
    public void push(T element, int index) {
        if (isEmpty() || index == 0 || index < headNode.getIndex())
            addElementFirstNode(element, index);
        else if (index > tailNode.getIndex() || index == tailNode.getIndex())
            addElementLastNode(element, index);
        else
            addElementIndexNode(element, index);
    }

    private void addElementFirstNode(T element) {
        DoublyNode<T> node = new DoublyNode<>(element);
        if (headNode != null) {
            headNode.setPrevNode(node);
            node.setNextNode(headNode);
        }
        headNode = node;
        if (tailNode == null)
            tailNode = headNode;
        length += 1;
    }

    private void addElementFirstNode(T element, int index) {
        DoublyNode<T> node = new DoublyNode<>(element, index);
        if (isEmpty())
            addElemenFirstNodeListEmpty(node);
        else if (index < headNode.getIndex())
            addElementFirstNodeNotReplacing(node);
        else if (index == 0 && length() == 1)
            addElementFirstNodeReplacingListWithOneElement(node);
        else
            addElementFirstNodeReplacingListWithoutOneElement(node);
    }

    private void addElemenFirstNodeListEmpty(DoublyNode<T> node) {
        headNode = node;
        tailNode = node;
        length += 1;
    }

    private void addElementFirstNodeNotReplacing(DoublyNode<T> node) {
        node.setNextNode(headNode);
        headNode.setPrevNode(node);
        headNode = node;
        length += 1;
    }

    private void addElementFirstNodeReplacingListWithOneElement(DoublyNode<T> node) {
        headNode = node;
        tailNode = node;
    }

    private void addElementFirstNodeReplacingListWithoutOneElement(DoublyNode<T> node) {
        node.setNextNode(headNode.getNextNode());
        ((DoublyNode<T>) headNode.getNextNode()).setPrevNode(node);
        headNode = node;
    }

    private void addElementLastNode(T element) {
        DoublyNode<T> node = new DoublyNode<>(element, tailNode.getIndex() + 1);
        tailNode.setNextNode(node);
        node.setPrevNode(tailNode);
        tailNode = node;
        length += 1;
    }

    private void addElementLastNode(T element, int index) {
        DoublyNode<T> node = new DoublyNode<>(element, index);
        if (index > tailNode.getIndex())
            addLastNode(node);
        else if (length() == 1 && index == tailNode.getIndex())
            addLastNodeReplacingListWithOneElement(node);
        else
            addLastNodeReplacingListWithoutOneElement(node);
    }

    private void addLastNode(DoublyNode<T> node) {
        node.setPrevNode(tailNode);
        tailNode.setNextNode(node);
        tailNode = node;
        length += 1;
    }

    private void addLastNodeReplacingListWithOneElement(DoublyNode<T> node) {
        if (headNode == tailNode)
            headNode = node;
        tailNode = node;
    }

    private void addLastNodeReplacingListWithoutOneElement(DoublyNode<T> node) {
        tailNode.getPrevNode().setNextNode(node);
        tailNode = node;
    }

    private void addElementIndexNode(T element, int index) {
        DoublyNode<T> node = new DoublyNode<>(element, index);
        DoublyNode<T> currentNode = (DoublyNode<T>) headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                node.setNextNode(currentNode.getNextNode());
                currentNode.getPrevNode().setNextNode(node);
                break;
            } else if (index < currentNode.getIndex()) {
                node.setNextNode(currentNode);
                currentNode.getPrevNode().setNextNode(node);
                length += 1;
                break;
            }
            currentNode = (DoublyNode<T>) currentNode.getNextNode();
        }
    }

    @Override
    public void remove(T element) {
        if (length() == 1 && headNode.getElement().equals(element))
            removeElementAllNode();
        else if (headNode.getElement().equals(element))
            removeElementFirstNode();
        else if (tailNode.getElement().equals(element))
            removeElementLastNode();
        else
            removeElement(element);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > length())
            throw new IndexOutOfBoundsException();
        else if (index == 0 || index == headNode.getIndex())
            removeElementFirstNode();
        else if (index == length() - 1 || index == tailNode.getIndex())
            removeElementLastNode();
        else
            removeElementIndexNode(index);
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
        if (tailNode != null)
            tailNode.setNextNode(null);
        length -= 1;
    }

    private void removeElement(T element) {
        DoublyNode<T> nodeCurrent = headNode;
        while (nodeCurrent.getNextNode() != null) {
            if (nodeCurrent.getNextNode() != null && nodeCurrent.getElement().equals(element)) {
                DoublyNode<T> prevNode = (DoublyNode<T>) nodeCurrent.getPrevNode();
                DoublyNode<T> nextNode = (DoublyNode<T>) nodeCurrent.getNextNode();
                prevNode.setNextNode(nextNode);
                nextNode.setPrevNode(prevNode);
                length -= 1;
                break;
            }
            nodeCurrent = (DoublyNode<T>) nodeCurrent.getNextNode();
        }
    }

    private void removeElementIndexNode(int index) {
        DoublyNode<T> currentNode = (DoublyNode<T>) headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                DoublyNode<T> prevNode = (DoublyNode<T>) currentNode.getPrevNode();
                DoublyNode<T> nextNode = (DoublyNode<T>) currentNode.getNextNode();
                prevNode.setNextNode(nextNode);
                nextNode.setPrevNode(prevNode);
                length -= 1;
                break;
            }
            currentNode = (DoublyNode<T>) currentNode.getNextNode();
        }
    }

    @Override
    public int indexOf(T element) {
        if (headNode.getElement().equals(element))
            return getIndexFirstNodeElement();
        else if (tailNode.getElement().equals(element))
            return getIndexLastNodeElement();
        else
            return getIndexNodeElement(element);
    }

    private int getIndexFirstNodeElement() {
        return headNode.getIndex();
    }

    private int getIndexLastNodeElement() {
        return tailNode.getIndex();
    }

    private int getIndexNodeElement(T element) {
        DoublyNode<T> currentNode = (DoublyNode<T>) headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getElement().equals(element))
                return currentNode.getIndex();
            currentNode = (DoublyNode<T>) currentNode.getNextNode();
        }
        throw new NullPointerException("Elemento não encontrado");
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
        if (headNode.getElement().equals(element))
            return headNode.getElement();
        if (tailNode.getElement().equals(element))
            return tailNode.getElement();
        Node<T> nodeCurrent = headNode.getNextNode();
        while (nodeCurrent != null) {
            if (nodeCurrent.getElement().equals(element))
                return nodeCurrent.getElement();
            nodeCurrent = nodeCurrent.getNextNode();
        }
        return null;
    }

    @Override
    public T getElement(int index) {
        if (index == 0)
            return headNode.getElement();
        if (index == length() - 1)
            return tailNode.getElement();
        Node<T> nodeCurrent = headNode.getNextNode();
        int cont = 1;
        while (nodeCurrent != null) {
            if (cont == index)
                return nodeCurrent.getElement();
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
