package com.fredson.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void shouldCreateQueuePriority() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        assertEquals(3, queue.length());
    }

    @Test
    public void shouldCreateQueueEmpty() {
        Queue<String> queue = new PriorityQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldPeekQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(10), queue.peek());
    }

    @Test
    public void shouldIteratorQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        assertTrue(queue.iterator().hasNext());
        assertEquals(Integer.valueOf(10), queue.iterator().next());
        assertEquals(Integer.valueOf(5), queue.iterator().next());
        assertEquals(Integer.valueOf(3), queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
    }

    @Test
    public void shouldIteratorQueueWithAppendNewElements() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        assertTrue(queue.iterator().hasNext());
        assertEquals(Integer.valueOf(10), queue.iterator().next());
        assertEquals(Integer.valueOf(5), queue.iterator().next());
        assertEquals(Integer.valueOf(3), queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
        queue.enqueue(6);
        assertTrue(queue.iterator().hasNext());
        assertEquals(Integer.valueOf(6), queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
        queue.enqueue(100);
        assertTrue(queue.iterator().hasNext());
        assertEquals(Integer.valueOf(100), queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
    }

    @Test
    public void shouldDequeQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(10), queue.dequeue());
        assertEquals(2, queue.length());
    }

    @Test
    public void shouldDequeQueueWithInsertNewElement() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(10), queue.dequeue());
        assertEquals(2, queue.length());
        queue.enqueue(0);
        queue.enqueue(6);
        assertEquals(Integer.valueOf(6), queue.dequeue());
        assertEquals(3, queue.length());
        queue.enqueue(8);
        assertEquals(Integer.valueOf(8), queue.dequeue());
        assertEquals(3, queue.length());
        assertEquals(Integer.valueOf(5), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(Integer.valueOf(0), queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldGetMaxHeapWithPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(0);
        queue.enqueue(6);
        queue.enqueue(8);
        assertNotNull(queue.toMaxHeap());
        assertEquals(Integer.valueOf(10), queue.toMaxHeap().find());
    }

    @Test
    public void shouldGetMinHeapWithPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.enqueue(0);
        queue.enqueue(6);
        queue.enqueue(8);
        assertNotNull(queue.toMinHeap());
        assertEquals(Integer.valueOf(0), queue.toMinHeap().find());
    }

    @Test
    public void shouldClearQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(3);
        queue.clear();;
        assertEquals(0, queue.length());
        assertTrue(queue.isEmpty());
    }
}
