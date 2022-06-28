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
        DoublyNode<T> node = new DoublyNode<>(element);
        DoublyNode<T> currentNode = headNode;
        if (isEmpty()) {
            push(element);
        } else if (index == 0) {
            headNode = node;
            tailNode = node;
        } else if (index >= 1 && index <= length()) {
            node.setNextNode(this.headNode);
            currentNode.setPrevNode(node);
            headNode = node;
        } else if (index == this.length()) {
            currentNode = tailNode;
            currentNode.setNextNode(node);
            node.setPrevNode(currentNode);
            tailNode = node;
        } else {

        }
        length += 1;
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
}
