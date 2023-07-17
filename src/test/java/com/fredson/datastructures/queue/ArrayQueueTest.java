package com.fredson.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
}
