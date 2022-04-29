package com.fredson.datastructures;

import com.fredson.models.Node;

public class CircularLinkedList <T> extends LinkedList <T>{

    public CircularLinkedList() {
        super();
    }

    @Override
    public void insert(T element, int index) {
        if (index >= 0 && index <= this.count) {
            Node node = new Node(element);
            Node nodeCurrent = this.head;
            if (index == 0) {
                if (this.head == null) {
                    this.head = node;
                    node.setNextNode(this.head);
                } else {
                    node.setNextNode(nodeCurrent);
                    nodeCurrent = this.getElementAt(this.size());
                    this.head = node;
                    nodeCurrent.setNextNode(this.head);
                }
            } else {
                Node previous = this.getElementAt(index - 1);
                node.setNextNode(previous.getNextNode());
                previous.setNextNode(node);
            }
            this.count ++;
        }
    }

    @Override
    public void removeAt(int index) {
        if (index >= 0 && index < this.count) {
            Node nodeCurrent = this.head;
            if (index == 0) {
                if (this.size() == 1) {
                    this.head = null;
                } else {
                    Node removed = this.head;
                    nodeCurrent = this.getElementAt(this.size());
                    this.head = this.head.getNextNode();
                    nodeCurrent.setNextNode(this.head);
                    nodeCurrent = removed;
                }
            } else {
                Node previous = this.getElementAt(index - 1);
                nodeCurrent = previous.getNextNode();
                previous.setNextNode(nodeCurrent.getNextNode());
            }
            this.count --;
        }
    }
}
