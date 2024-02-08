package com.fredson.datastructures.queue;

import com.fredson.datastructures.heap.Heap;

public interface QueueHeap<T> {

    Heap<T> toMaxHeap();

    Heap<T> toMinHeap();
}