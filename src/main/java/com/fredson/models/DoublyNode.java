package fredson.models;

public class DoublyNode <T> extends  Node<T>{

    private Node<T> prev;

    public DoublyNode(T element, Node<T> next, Node<T> prev) {
        super(element, next);
        this.prev = prev;
    }

    public DoublyNode(T element) {
        super(element);
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
