package com.fredson.datastructures.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HeapTest {

    @Test
    public void shouldInsertElementInMinHeap() {
        Heap<Integer> heap = new MinHeap<>();
        String heapListExpected = "[1, 2, 4, 5, 3]";
        String heapStringExpected = "1 -> (2 -> (5, 3), 4)";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertFalse(heap.isEmpty());
        assertEquals(5, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }
}
