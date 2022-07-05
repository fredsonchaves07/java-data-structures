package com.fredson.datastructures;

import com.fredson.models.DoublyNode;
import com.fredson.models.Node;

public class DoublyLinkedList<T> extends LinkedList<T> {

    private DoublyNode<T> headNode;
    private DoublyNode<T> tailNode;

    public DoublyLinkedList() {
        super();
    }

    @Override
    public void push(T element) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        if (isEmpty()) {
            headNode = doublyNode;
        } else {
            DoublyNode<T> currentNode = headNode;
            while (currentNode.getNextNode() != null) {
                currentNode = (DoublyNode<T>) currentNode.getNextNode();
            }
            currentNode.setNextNode(doublyNode);
            doublyNode.setPrevNode(currentNode);
        }
        length += 1;
        tailNode = doublyNode;
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
//        if(index >= 0 && index <= this.length()){
//            DoublyNode<T> node = new DoublyNode(element);
//            DoublyNode<T> nodeCurrent = this.headNode;
//            if(index == 0){
//                if(this.headNode == null){
//                    this.headNode = node;
//                    this.tailNode = node;
//                } else {
//                    node.setNextNode(this.headNode);
//                    nodeCurrent.setPrevNode(node);
//                    this.headNode = node;
//                }
//            } else if(index == this.length()){
//                nodeCurrent = this.tailNode;
//                nodeCurrent.setNextNode(node);
//                node.setPrevNode(nodeCurrent);
//                this.tailNode = node;
//            } else {
//                Node<T> previous = this.getElement(index - 1);
//                nodeCurrent = (DoublyNode<T>) previous.getNextNode();
//                node.setNextNode(nodeCurrent);
//                previous.setNextNode(node);
//                nodeCurrent.setPrevNode(node);
//                node.setPrevNode(previous);
//            }
//            this.length() ++;
//        }


    }

    private void addElementFirstNode(T element) {
        DoublyNode<T> doublyNode = new DoublyNode<>(element);
        DoublyNode<T> currentNode = headNode;
        currentNode.setPrevNode(doublyNode);
        doublyNode.setNextNode(currentNode);
        headNode = doublyNode;
        while (currentNode != null) {
            if (currentNode.getNextNode() == null){
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
        int contIndex = 1;
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
            tailNode.setPrevNode(doublyNode);
            doublyNode.setNextNode(tailNode);
            doublyNode.setPrevNode(tailNode.getPrevNode());
        }
        length += 1;
    }

    public void removeAt(int index) {
//        if (index >= 0 && index < this.count) {
//            DoublyNode<T> nodeCurrent = this.headNode;
//            if (index == 0) {
//                this.headNode = (DoublyNode<T>) nodeCurrent.getNextNode();
//                if (this.count == 1) {
//                    this.tailNode = null;
//                } else {
//                    this.headNode.setPrev(null);
//                }
//            } else if (index == this.count - 1) {
//             nodeCurrent = this.tailNode;
//             this.tailNode = (DoublyNode<T>) nodeCurrent.getPrev();
//             this.tailNode.setNextNode(null);
//            } else {
//                nodeCurrent = (DoublyNode<T>) this.getElementAt(index);
//                Node previous = nodeCurrent.getPrev();
//                previous.setNextNode(nodeCurrent.getNextNode());
//                /* TODO -> Ajustar herança */
//                /* nodeCurrent.getNext().setPrev(previous);*/
//            }
//            this.count --;
//        }
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
}
