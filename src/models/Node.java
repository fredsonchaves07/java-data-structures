package models;

public class Node <T>{
    
    private T element;
    private Node<T> next;

    public Node(T element){
        this.element = element;
        this.next = null;
    }

    public Node(T element, Node<T> next){
        this.element = element;
        this.next = next;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setNext(Node<T> node){
        this.next = node;
    }

    public T getElement(){
        return this.element;
    }
}