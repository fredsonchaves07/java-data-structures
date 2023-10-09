package com.fredson.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    @Test
    public void shouldCreateQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        assertEquals(3, queue.length());
    }

    @Test
    public void shouldCreateQueueWithCapacity() {
        Queue<String> queue = new ArrayQueue<>(3);
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        queue.enqueue("C++");
        assertEquals(4, queue.length());
    }

    @Test
    public void shouldCreateQueueEmpty() {
        Queue<String> queue = new ArrayQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldPeekQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        assertEquals("Java", queue.peek());
    }

    @Test
    public void shouldDequeQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        assertEquals("Java", queue.dequeue());
        assertEquals(2, queue.length());
    }

    @Test
    public void shouldClearQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        queue.clear();;
        assertEquals(0, queue.length());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldIteratorQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        assertTrue(queue.iterator().hasNext());
        assertEquals("Java", queue.iterator().next());
        assertEquals("Python", queue.iterator().next());
        assertEquals("Javascript", queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
    }

    @Test
    public void shouldIteratorQueueWithAppendNewElements() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        assertTrue(queue.iterator().hasNext());
        assertEquals("Java", queue.iterator().next());
        assertEquals("Python", queue.iterator().next());
        assertEquals("Javascript", queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
        queue.enqueue("Javascript");
        assertTrue(queue.iterator().hasNext());
        assertEquals("Javascript", queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
        queue.enqueue("Java");
        assertTrue(queue.iterator().hasNext());
        assertEquals("Java", queue.iterator().next());
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
    }

    @Test
    public void shouldNotIteratorIfQueueIsEmpty() {
        Queue<String> queue = new ArrayQueue<>();
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
    }

    @Test
    public void shouldNotIteratorIfRemoveElementsInQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("Java");
        queue.enqueue("Python");
        queue.enqueue("Javascript");
        assertTrue(queue.iterator().hasNext());
        assertEquals("Java", queue.iterator().next());
        assertTrue(queue.iterator().hasNext());
        assertEquals("Python", queue.iterator().next());
        assertTrue(queue.iterator().hasNext());
        queue.dequeue();
        assertFalse(queue.iterator().hasNext());
        assertNull(queue.iterator().next());
    }
}
