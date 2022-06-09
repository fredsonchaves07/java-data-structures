package com.fredson.datastructures;

import com.fredson.models.Node;

public class LinkedList <T> implements List<T> {

    private Node<T> node;

    private int length;
    
    public LinkedList(){
        node = null;
    }

    @Override
    public void push(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            node = newNode;
        } else {
            Node<T> nodeCurrent = node;
            while (nodeCurrent.getNextNode() != null) nodeCurrent = nodeCurrent.getNextNode();
            nodeCurrent.setNextNode(newNode);
        }
        length += 1;
    }

    public void removeAt(int index){
//        Node<T> nodeCurrent;
//        if(index == 0){
//            nodeCurrent = this.head;
//            this.head = nodeCurrent.getNextNode();
//        } else {
//            Node<T> previous = this.getElementAt(index - 1);
//            nodeCurrent = previous.getNextNode();
//            previous.setNextNode(nodeCurrent.getNextNode());
//        }
//        this.count --;
    }

    public void insert(T element, int index){
//        if(index >= 0 && index <= this.count){
//            Node<T> nodeCurrent;
//            Node<T> node = new Node<>(element);
//            if(index == 0){
//                nodeCurrent = this.head;
//                node.setNextNode(nodeCurrent);
//                this.head = node;
//            } else {
//                Node<T> nodePrevious = this.getElementAt(index - 1);
//                nodeCurrent = nodePrevious.getNextNode();
//                node.setNextNode(nodeCurrent);
//                nodePrevious.setNextNode(node);
//            }
//            this.count ++;
//        }
    }

    protected Node<T> getElementAt(int index){
//        if(index >= 0 && index <= this.count){
//            Node<T> node = this.head;
//            for(int i = 0; i < index && node != null; i++){
//                node = node.getNextNode();
//            }
//            return node;
//        }
        return null;
    }

    public void remove(T element){
//        int index = this.indexOf(element);
//        this.removeAt(index);
    }

    @Override
    public void remove(int index) {

    }


    public int indexOf(T element){
//        Node<T> node = this.head;
//        for(int i = 0; i < this.count && node != null; i ++){
//            if(node.getElement().equals(element)){
//                return i;
//            }
//            node = node.getNextNode();
//        }
        return -1;
    }

    @Override
    public T getElement(int index) {
        return null;
    }

    @Override
    public T getElement(T element) {
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

    public Node<T> getHead(){
//        return this.head;
        return null;
    }

    @Override
    public String toString() {
//        if(this.head == null){
//            return "";
//        }
//        StringBuilder objString = new StringBuilder(this.head.getElement().toString());
//        Node<T> nodeCurrent = this.head.getNextNode();
//        for(int i = 0; i < this.size() && nodeCurrent != null; i ++){
//            objString.append(",").append(nodeCurrent.getElement());
//            nodeCurrent = nodeCurrent.getNextNode();
//        }
//        return objString.toString();
        return "";
    }
}
