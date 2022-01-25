package fredson.datastructures;

import fredson.models.Node;

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
                    node.setNext(this.head);
                } else {
                    node.setNext(nodeCurrent);
                    nodeCurrent = this.getElementAt(this.size());
                    this.head = node;
                    nodeCurrent.setNext(this.head);
                }
            } else {
                Node previous = this.getElementAt(index - 1);
                node.setNext(previous.getNext());
                previous.setNext(node);
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
                    this.head = this.head.getNext();
                    nodeCurrent.setNext(this.head);
                    nodeCurrent = removed;
                }
            } else {
                Node previous = this.getElementAt(index - 1);
                nodeCurrent = previous.getNext();
                previous.setNext(nodeCurrent.getNext());
            }
            this.count --;
        }
    }
}
