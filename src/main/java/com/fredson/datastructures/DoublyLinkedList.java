package com.fredson.datastructures;

import com.fredson.models.DoublyNode;
import com.fredson.models.Node;

public class DoublyLinkedList <T> extends LinkedList<T> {

    DoublyNode<T> tail;
    DoublyNode<T> head;

    public DoublyLinkedList() {
        super();
    }

    @Override
    public void push(T element, int index) {
        if(index >= 0 && index <= this.length()){
            DoublyNode<T> node = new DoublyNode(element);
            DoublyNode<T> nodeCurrent = this.head;
            if(index == 0){
                if(this.head == null){
                    this.head = node;
                    this.tail = node;
                } else {
                    node.setNextNode(this.head);
                    nodeCurrent.setPrevNode(node);
                    this.head = node;
                }
            } else if(index == this.length()){
                nodeCurrent = this.tail;
                nodeCurrent.setNextNode(node);
                node.setPrevNode(nodeCurrent);
                this.tail = node;
            } else {
                Node<T> previous = this.getElement(index - 1);
                nodeCurrent = (DoublyNode<T>) previous.getNextNode();
                node.setNextNode(nodeCurrent);
                previous.setNextNode(node);
                nodeCurrent.setPrevNode(node);
                node.setPrevNode(previous);
            }
            this.length() ++;
        }
    }

    @Override
    public void removeAt(int index) {
        if (index >= 0 && index < this.count) {
            DoublyNode<T> nodeCurrent = this.head;
            if (index == 0) {
                this.head = (DoublyNode<T>) nodeCurrent.getNextNode();
                if (this.count == 1) {
                    this.tail = null;
                } else {
                    this.head.setPrev(null);
                }
            } else if (index == this.count - 1) {
             nodeCurrent = this.tail;
             this.tail = (DoublyNode<T>) nodeCurrent.getPrev();
             this.tail.setNextNode(null);
            } else {
                nodeCurrent = (DoublyNode<T>) this.getElementAt(index);
                Node previous = nodeCurrent.getPrev();
                previous.setNextNode(nodeCurrent.getNextNode());
                /* TODO -> Ajustar herança */
                /* nodeCurrent.getNext().setPrev(previous);*/
            }
            this.count --;
        }
    }
}
