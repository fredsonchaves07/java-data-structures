package com.fredson.datastructures.tree;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
import com.fredson.models.Node;

public interface Tree<T> {

    T replace(Node<T> node, T element);

    Node<T> root();

    Node<T> parent(Node<T> node);

    List<Node<T>> nodes();

    List<Node<T>> children(Node<T> node);

    boolean isInternal(Node<T> node);

    boolean isExternal(Node<T> node);

    boolean isRoot(Node<T> node);

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    default int depth(Node<T> node) {
        if (this.isEmpty()) return 0;
        return 1 + depth(this.parent(node));
    }

    default int height(Node<T> node) {
        if (this.isExternal(node)) return 0;
        int heigh = 0;
        while (this.children(node).iterator().hasNext()) {
            heigh = Math.max(heigh, height(this.children(node).iterator().next()));
        }
        return 1 + heigh;
    }

    default List<T> preOrder(Node<T> node) {
        List<T> elements = new ArrayList<>();
        getElementNodePreOrder(node, elements);
        return elements;
    }

    private T getElementNodePreOrder(Node<T> node, List<T> elements) {
        T element = node.getElement();
        while (this.children(node).iterator().hasNext()) {
            elements.push(getElementNodePreOrder(this.children(node).iterator().next(), elements));
        }
        return element;
    }

    private List<T> posOrder(Node<T> node) {
        List<T> elements = new ArrayList<>();
        getElementNodePosOrder(node, elements);
        return elements;
    }

    private T getElementNodePosOrder(Node<T> node, List<T> elements) {
        while (this.children(node).iterator().hasNext()) {
            elements.push(getElementNodePreOrder(this.children(node).iterator().next(), elements));
        }
        return node.getElement();
    }
}
