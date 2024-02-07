package com.fredson.datastructures.tree;

import com.fredson.datastructures.heap.Heap;
import com.fredson.datastructures.list.List;
import com.fredson.models.DoublyNode;

public class BinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T> {

    public BinarySearchTree() {}

    public BinarySearchTree(Heap<T> heap) {
        List<T> heapList = heap.toList().clone();
        while (heapList.iterator().hasNext()) {
            T element = heapList.iterator().next();
            insert(element);
        }
    }

    @Override
    public void insert(T nodeElement, T element) {
        if (isEmpty()) insert(element);
        DoublyNode<T> node = nodes.get(nodeElement);
        if (node == null) throw new Error("Node " + nodeElement + " not found in tree");
        if (nodeElement.compareTo(element) < 0 || nodeElement.compareTo(element) == 0) {
            if (node.getNextNode() == null) {
                DoublyNode<T> newNode = new DoublyNode<>(element);
                node.setNextNode(newNode);
                nodes.put(newNode.getElement(), newNode);
                size ++;
            } else {
                insert(node.getNextNode().getElement(), element);
            }
        } else if (nodeElement.compareTo(element) > 0) {
            if (node.getPrevNode() == null) {
                DoublyNode<T> newNode = new DoublyNode<>(element);
                node.setPrevNode(newNode);
                nodes.put(newNode.getElement(), newNode);
                size ++;
            } else {
                insert(node.getPrevNode().getElement(), element);
            }
        }
    }
}
