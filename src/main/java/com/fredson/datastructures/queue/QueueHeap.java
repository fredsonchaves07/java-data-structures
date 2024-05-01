package com.fredson.datastructures.queue;

import com.fredson.datastructures.heap.Heap;

public interface QueueHeap<T extends Comparable<T>> {

    Heap<T> toMaxHeap();

    Heap<T> toMinHeap();
}