package com.fredson.datastructures.heap;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
import com.fredson.datastructures.tree.BinarySearchTree;
import com.fredson.datastructures.tree.Tree;


public class MinHeap<T extends Comparable<T>> implements Heap<T>{

    private final List<T> heap = new ArrayList<>();

    private int length;

    private T minElement;

    public MinHeap() {
    }

    public MinHeap(Tree<T> tree) {
        List<T> treeList = tree.toList().clone();
        while (treeList.iterator().hasNext()) {
            T element = treeList.iterator().next();
            insert(element);
        }
    }

    @Override
    public void insert(T element) {
        if (isEmpty()) {
            heap.push(element);
            minElement = element;
            length ++;
        } else {
            heap.push(element);
            length ++;
            siftUp(heap.getElement(element));
        }
    }

    private void siftUp(T element) {
        int index = heap.indexOf(element);
        T elementHeap = heap.getElement(getParentIndex(index));
        while (index >= 0 && elementHeap != null && elementHeap.compareTo(element) > 0) {
            swap(element, elementHeap);
            index = getParentIndex(heap.indexOf(element));
            elementHeap = heap.getElement(index);
            while (elementHeap == null && index == 0) {
                index ++;
                elementHeap = heap.getElement(index);
                if (elementHeap != null) {
                    swap(element, elementHeap);
                    index = 0;
                }
            }
        }
    }

    private void siftDown(int index) {
        int elementIndex = index;
        if (index == 0) {
            swap(heap.getElement(length() - 1), minElement);
            heap.remove(minElement);
        }
        int leftIndex = getLeftIndex(index);
        int rigthIndex = getRightIndex(index);
        T leftElement = null;
        if (leftIndex < length()) {
            leftElement = heap.getElement(leftIndex);
        }
        T rigthElement = null;
        if (rigthIndex < length()) {
            rigthElement = heap.getElement(rigthIndex);
        }
        T element = heap.getElement(index);
        if (leftElement != null && leftElement.compareTo(element) < 0) {
            swap(leftElement, element);
            elementIndex = leftIndex;
        } else if (rigthElement != null && rigthElement.compareTo(element) < 0) {
            swap(leftElement, element);
            elementIndex = rigthIndex;
        }
        if (index != elementIndex) {
            siftDown(elementIndex);
        }
    }

    private void swap(T newElement, T oldElement) {
        int newElementIndex = heap.indexOf(newElement);
        int oldElementIndex;
        if (oldElement.equals(minElement)) {
            oldElementIndex = 0;
        } else {
            oldElementIndex = heap.indexOf(oldElement);
        }
        heap.push(oldElement, newElementIndex);
        heap.push(newElement, oldElementIndex);
        if (!minElement.equals(newElement) && minElement.compareTo(newElement) > 0)
            minElement = newElement;
    }

    @Override
    public T extract() {
        if (isEmpty()) return null;
        T element = minElement;
        if (length() != 1) {
            siftDown(0);
        } else {
            heap.remove(minElement);
        }
        minElement = heap.getElement(0);
        length --;
        return element;
    }

    @Override
    public T find() {
        if (isEmpty()) return null;
        return minElement;
    }

    @Override
    public List<T> toList() {
        return heap.clone();
    }

    @Override
    public Tree<T> toTree() {
        return new BinarySearchTree<>(this);
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String treeString = minElement.toString();
        treeString = toString(0, treeString);
        return treeString;
    }

    private String toString(int index, String treeString) {
        int leftIndex = getLeftIndex(index);
        int rightIndex = getRightIndex(index);
        T leftElement = null;
        T rigthElement = null;
        if (leftIndex <= length()) leftElement = heap.getElement(leftIndex);
        if (rightIndex <= length()) rigthElement = heap.getElement(rightIndex);
        if (leftElement != null) {
            treeString += " -> (";
            treeString += leftElement;
            treeString = toString(leftIndex, treeString);
            if (rigthElement == null) {
                treeString += ")";
            }
        }
        if (rigthElement != null) {
            treeString += ", ";
            treeString += rigthElement;
            treeString = toString(rightIndex, treeString);
            treeString += ")";
        }
        return treeString;
    }
}
