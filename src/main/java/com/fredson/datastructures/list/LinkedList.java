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
        if (isEmpty())
            addElementFirstNode(element);
        else
            addElementLastNode(element);
    }

    @Override
    public void push(T element, int index) {
          if (isEmpty() || index == 0 || index < headNode.getIndex())
              addElementFirstNode(element, index);
          else if (index > tailNode.getIndex() || index == tailNode.getIndex()) {
              addElementLastNode(element, index);
          } else {
              addElementIndexNode(element, index);
          }
    }

    private void addElementFirstNode(T element) {
        headNode = new Node<>(element);
        if (tailNode == null)
            tailNode = headNode;
        length += 1;
    }

    private void addElementFirstNode(T element, int index) {
        Node<T> node = new Node<>(element, index);
          if (isEmpty())
              addElemenFirstNodeListEmpty(node);
          else if (index < headNode.getIndex())
              addElementFirstNodeNotReplacing(node);
          else if (index == 0 && length() == 1)
              addElementFirstNodeReplacingListWithOneElement(node);
          else
              addElementFirstNodeReplacingListWithoutOneElement(node);
    }

    private void addElemenFirstNodeListEmpty(Node<T> node) {
        headNode = node;
        tailNode = node;
        length += 1;
    }

    private void addElementFirstNodeNotReplacing(Node<T> node) {
        node.setNextNode(headNode);
        headNode = node;
        length += 1;
    }

    private void addElementFirstNodeReplacingListWithOneElement(Node<T> node) {
        headNode = node;
        tailNode = node;
    }

    private void addElementFirstNodeReplacingListWithoutOneElement(Node<T> node) {
        node.setNextNode(headNode.getNextNode());
        headNode = node;
    }

    private void addElementLastNode(T element) {
        Node<T> node = new Node<>(element, tailNode.getIndex() + 1);
        if (headNode == tailNode) {
            tailNode = node;
            headNode.setNextNode(node);
        } else {
            tailNode.setNextNode(node);
            tailNode = node;
        }
        length += 1;
    }

    private void addElementLastNode(T element, int index) {
        Node<T> node = new Node<>(element, index);
        if (index > tailNode.getIndex()) {
            addElementLastNode(node);
        } else if (length() == 1 && index == tailNode.getIndex()) {
            addElementLastNodeReplacingListWithOneElement(node);
        } else {
            addElementLastNodeReplacingListWithoutOneElement(node);
        }
    }

    private void addElementLastNode(Node<T> node) {
        tailNode.setNextNode(node);
        tailNode = node;
        length += 1;
    }

    private void addElementLastNodeReplacingListWithOneElement(Node<T> node) {
        if (headNode == tailNode)
            headNode = node;
        tailNode = node;
    }

    private void addElementLastNodeReplacingListWithoutOneElement(Node<T> node) {
        Objects.requireNonNull(getBeforeNode(tailNode)).setNextNode(node);
        tailNode = node;
    }

    private void addElementIndexNode(T element, int index) {
        Node<T> node = new Node<>(element, index);
        Node<T> currentNode = headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                node.setNextNode(currentNode.getNextNode());
                Objects.requireNonNull(getBeforeNode(currentNode)).setNextNode(node);
                break;
            } else if (index < currentNode.getIndex()) {
                node.setNextNode(currentNode);
                Objects.requireNonNull(getBeforeNode(currentNode)).setNextNode(node);
                length += 1;
                break;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    private Node<T> getBeforeNode(Node<T> node) {
        Node<T> currentNode = headNode;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getNextNode().equals(node))
                return currentNode;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    @Override
    public void remove(T element) {
        if (headNode.getElement().equals(element))
            removeElementFirstNode();
        else if (tailNode.getElement().equals(element))
            removeElementLastNode();
        else
            removeElementNode(element);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > length())
            throw new IndexOutOfBoundsException();
        if (index == 0 || index == headNode.getIndex()){
            removeElementFirstNode();
        } else if (index == length() - 1 || index == tailNode.getIndex()) {
            removeElementLastNode();
        } else {
            removeElementIndexNode(index);
        }
    }

    private void removeElementFirstNode() {
        if (headNode == tailNode)
            tailNode = headNode.getNextNode();
        headNode = headNode.getNextNode();
        length -= 1;
    }

    private void removeElementLastNode() {
        tailNode = getBeforeNode(tailNode);
        if (tailNode != null)
            tailNode.setNextNode(null);
        length -= 1;
    }

    private void removeElementNode(T element) {
        Node<T> currentNode = headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                Objects.requireNonNull(getBeforeNode(currentNode)).setNextNode(currentNode.getNextNode());
                length -= 1;
                break;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    private void removeElementIndexNode(int index) {
        Node<T> currentNode = headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                Objects.requireNonNull(getBeforeNode(currentNode)).setNextNode(currentNode.getNextNode());
                length -= 1;
                break;
            }
            currentNode = currentNode.getNextNode();
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
        Node<T> currentNode = headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getElement().equals(element))
                return currentNode.getIndex();
            currentNode = currentNode.getNextNode();
        }
        throw new NullPointerException("Elemento não encontrado");
    }

    @Override
    public T getElement(int index) {
        if (headNode.getIndex() == index)
            return getFirstNodeElement();
        else if (tailNode.getIndex() == index)
            return getLastNodeElement();
        else
            return getIndexNodeElement(index);
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

    private T getFirstNodeElement() {
        return headNode.getElement();
    }

    private T getLastNodeElement() {
        return tailNode.getElement();
    }

    private T getIndexNodeElement(int index) {
        Node<T> currentNode = headNode.getNextNode();
        while (currentNode != null) {
            if (currentNode.getIndex() == index)
                return currentNode.getElement();
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
