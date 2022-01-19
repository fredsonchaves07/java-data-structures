package datastructures;

import models.Node;

public class LinkedList <T>{

    protected int count = 0;
    protected Node<T> head;
    
    public LinkedList(){
        this.count = 0;
        head = null;
    }

    public void push(T element){
        Node<T> node = new Node<T>(element);
        Node<T> nodeCurrent;
        if(this.head == null){
            this.head = node;
        } else {
            nodeCurrent = this.head;
            while(nodeCurrent.getNext() != null){
                nodeCurrent = nodeCurrent.getNext();
            }
            nodeCurrent.setNext(node);
        }
        this.count ++;
    }

    public void removeAt(int index){
        Node<T> nodeCurrent;
        if(index == 0){
            nodeCurrent = this.head;
            this.head = nodeCurrent.getNext();
        } else {
            Node<T> previous = this.getElementAt(index - 1);
            nodeCurrent = previous.getNext();
            previous.setNext(nodeCurrent.getNext());
        }
        this.count --;
    }

    public void insert(T element, int index){
        if(index >= 0 && index <= this.count){
            Node<T> nodeCurrent;
            Node<T> node = new Node<T>(element);
            if(index == 0){
                nodeCurrent = this.head;
                node.setNext(nodeCurrent);
                this.head = node;
            } else {
                Node<T> nodePrevious = this.getElementAt(index - 1);
                nodeCurrent = nodePrevious.getNext();
                node.setNext(nodeCurrent);
                nodePrevious.setNext(node);
            }
            this.count ++;
        }
    }

    protected Node<T> getElementAt(int index){
        if(index >= 0 && index <= this.count){
            Node<T> node = this.head;
            for(int i = 0; i < index && node != null; i++){
                node = node.getNext();
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
            node = node.getNext();
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
        String objString = this.head.getElement().toString();
        Node nodeCurrent = this.head.getNext();
        for(int i = 0; i < this.size() && nodeCurrent != null; i ++){
            objString = objString + "," + nodeCurrent.getElement();
            nodeCurrent = nodeCurrent.getNext();
        }
        return objString;
    }
}
