package com.fredson.datastructures;

import com.fredson.models.Node;

public class LinkedList <T>{

    protected int count;
    protected Node<T> head;
    
    public LinkedList(){
        this.count = 0;
        head = null;
    }

    public void push(T element){
        Node<T> node = new Node<>(element);
        Node<T> nodeCurrent;
        if(this.head == null){
            this.head = node;
        } else {
            nodeCurrent = this.head;
            while(nodeCurrent.getNextNode() != null){
                nodeCurrent = nodeCurrent.getNextNode();
            }
            nodeCurrent.setNextNode(node);
        }
        this.count ++;
    }

    public void removeAt(int index){
        Node<T> nodeCurrent;
        if(index == 0){
            nodeCurrent = this.head;
            this.head = nodeCurrent.getNextNode();
        } else {
            Node<T> previous = this.getElementAt(index - 1);
            nodeCurrent = previous.getNextNode();
            previous.setNextNode(nodeCurrent.getNextNode());
        }
        this.count --;
    }

    public void insert(T element, int index){
        if(index >= 0 && index <= this.count){
            Node<T> nodeCurrent;
            Node<T> node = new Node<>(element);
            if(index == 0){
                nodeCurrent = this.head;
                node.setNextNode(nodeCurrent);
                this.head = node;
            } else {
                Node<T> nodePrevious = this.getElementAt(index - 1);
                nodeCurrent = nodePrevious.getNextNode();
                node.setNextNode(nodeCurrent);
                nodePrevious.setNextNode(node);
            }
            this.count ++;
        }
    }

    protected Node<T> getElementAt(int index){
        if(index >= 0 && index <= this.count){
            Node<T> node = this.head;
            for(int i = 0; i < index && node != null; i++){
                node = node.getNextNode();
            }
            return node;
        }
        return null;
    }

    public void remove(T element){
        int index = this.indexOf(element);
        this.removeAt(index);
    }


    public int indexOf(T element){
        Node<T> node = this.head;
        for(int i = 0; i < this.count && node != null; i ++){
            if(node.getElement().equals(element)){
                return i;
            }
            node = node.getNextNode();
        }
        return -1;
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public Node<T> getHead(){
        return this.head;
    }

    @Override
    public String toString() {
        if(this.head == null){
            return "";
        }
        StringBuilder objString = new StringBuilder(this.head.getElement().toString());
        Node<T> nodeCurrent = this.head.getNextNode();
        for(int i = 0; i < this.size() && nodeCurrent != null; i ++){
            objString.append(",").append(nodeCurrent.getElement());
            nodeCurrent = nodeCurrent.getNextNode();
        }
        return objString.toString();
    }
}
