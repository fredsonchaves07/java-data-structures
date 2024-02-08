package com.fredson.datastructures.queue;

import com.fredson.datastructures.heap.Heap;
import com.fredson.datastructures.heap.MaxHeap;
import com.fredson.datastructures.heap.MinHeap;
import com.fredson.datastructures.iterator.Iterator;
import com.fredson.datastructures.iterator.QueueIterator;
import com.fredson.datastructures.list.List;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T>, QueueHeap<T> {

    private Heap<T> heap = new MaxHeap<>();

    private Iterator<T> iterator;

    private int length;

    public PriorityQueue() {

    }

    private PriorityQueue(PriorityQueue<T> queue) {
        List<T> elements = queue.toMaxHeap().toList().clone();
        while (elements.iterator().hasNext()) {
            this.enqueue(elements.iterator().next());
        }
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
        if (iterator != null)
            return iterator;
        iterator = new QueueIterator<>(this);
        return iterator;
    }


    @Override
    public void enqueue(T element) {
        heap.insert(element);
        length ++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T element = heap.extract();
        length --;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return heap.find();
    }

    @Override
    public void clear() {
        heap = null;
        length = 0;
    }

    @Override
    public Queue<T> clone() {
        return new PriorityQueue(this);
    }

    @Override
    public String toString() {
        return heap.toList().toString();
    }

    public Heap<T> toMaxHeap() {
        return heap.clone();
    }

    public Heap<T> toMinHeap() {
        return new MinHeap<>(heap.toTree());
    }
}
