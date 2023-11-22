package com.fredson.datastructures.tree;

import com.fredson.datastructures.DataStructure;
import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
import com.fredson.models.Node;

public interface Tree<T> extends DataStructure<T> {

    void insert(T element);

    void insert(T nodeElement, T element);

    T replace(Node<T> node, T element);

    T root();

    List<T> parent(T node);

    T getFirstParent(T node);

    List<T> nodes();

    List<T> children(T node);

    boolean isInternal(Node<T> node);

    boolean isExternal(Node<T> node);

    //TODO -> Implementar cenários de teste
    boolean isRoot(T nodeElement);

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    T min();

    T max();

    void remove(T element);

    boolean search(T element);

    //TODO -> Alterar a implementação
//    default int depth(Node<T> node) {
//        if (this.isEmpty()) return 0;
//        return 1 + depth(this.parent(node));
//    }

    //TODO -> Alterar implementação
//    default int height(Node<T> node) {
//        if (this.isExternal(node)) return 0;
//        int heigh = 0;
//        while (this.children(node).iterator().hasNext()) {
//            heigh = Math.max(heigh, height(this.children(node).iterator().next()));
//        }
//        return 1 + heigh;
//    }

    default List<T> preOrder() {
        List<T> elements = new ArrayList<>();
        T root = root();
        if (root != null) {
            elements.push(root);
            getElementNodePreOrder(root, elements);
        }
        return elements;
    }

    default List<T> toList() {
        return nodes();
    }

    private void getElementNodePreOrder(T elementNode, List<T> elements) {
        List<T> children = this.children(elementNode);
        while (children.iterator().hasNext()) {
            T next = children.iterator().next();
            elements.push(next);
            getElementNodePreOrder(next, elements);
        }
    }

    default List<T> posOrder() {
        List<T> elements = new ArrayList<>();
        T root = root();
        if (root != null) {
            getElementNodePosOrder(root, elements);
            elements.push(root);
        }
        return elements;
    }

    private T getElementNodePosOrder(T elementNode, List<T> elements) {
        List<T> children = this.children(elementNode);
        while (children.iterator().hasNext()) {
            T next = children.iterator().next();
            elements.push(getElementNodePosOrder(next, elements));
        }
        return elementNode;
    }

    default List<T> inOrder() {
        return nodes();
    }
}
