package com.fredson.datastructures.heap;

import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;


public class MinHeap<T extends Comparable<T>> implements Heap<T>{

    private final List<T> heap;

    private int length;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(T element) {
        if (isEmpty()) {
            heap.push(element);
            length ++;
        } else {
            heap.push(element);
            length ++;
            siftUp(length() - 1);
        }
    }

    private void siftUp(int index) {
        T element = heap.getElement(getParentIndex(index));
        while (index > 0 && element.compareTo(heap.getElement(index)) > 0) {
            swap(heap.getElement(index), element);
            index = getParentIndex(index);
            element = heap.getElement(getParentIndex(index));
        }
    }

    private void swap(T newElement, T oldElement) {
        int newElementIndex = heap.indexOf(newElement);
        int oldElementIndex = heap.indexOf(oldElement);
        heap.push(oldElement, newElementIndex);
        heap.push(newElement, oldElementIndex);
    }


    @Override
    public T extract() {
        return null;
    }

    @Override
    public T find() {
        return null;
    }

    @Override
    public List<T> toList() {
        return heap.clone();
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

    public T getMin() {
        return heap.getElement(0);
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String treeString = getMin().toString();
        treeString = toString(1, treeString);
        return treeString;
    }

    private String toString(int index, String treeString) {
        while (index  > 0 && index < length()) {
            treeString += " -> (";
            treeString += heap.getElement(index);
            int leftIndex = getLeftIndex(index);
            if (leftIndex < length()) {
                treeString = toString(getLeftIndex(index), treeString);
            }
            int rightIndex = index + 1;
            if (rightIndex < length()) {
                treeString += ", ";
                treeString += heap.getElement(rightIndex);
                treeString += ")";
                return treeString;
            }  else {
                break;
            }
        }
        return treeString;
    }
}
