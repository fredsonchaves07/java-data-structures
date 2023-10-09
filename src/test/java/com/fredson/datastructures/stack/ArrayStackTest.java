package com.fredson.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void shouldCreateStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertEquals(3, stack.length());
    }

    @Test
    public void shouldCreateStackWithCapacity() {
        Stack<String> stack = new ArrayStack<>(3);
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertEquals(3, stack.length());
    }

    @Test
    public void shouldCreateStackEmpty() {
        Stack<String> vector = new ArrayStack<>();
        assertTrue(vector.isEmpty());
    }

    @Test
    public void shouldPrintStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        System.out.println(stack);
    }

    @Test
    public void shouldPeekStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        assertEquals("Java", stack.peek());
    }

    @Test
    public void shouldPopStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertEquals("Javascript", stack.pop());
        assertEquals(2, stack.length());
    }

    @Test
    public void shouldIteratorStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertTrue(stack.iterator().hasNext());
        assertEquals("Java", stack.iterator().next());
        assertEquals("Python", stack.iterator().next());
        assertEquals("Javascript", stack.iterator().next());
        assertFalse(stack.iterator().hasNext());
        assertNull(stack.iterator().next());
    }

    @Test
    public void shouldIteratorStackWithAppendNewElements() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertTrue(stack.iterator().hasNext());
        assertEquals("Java", stack.iterator().next());
        assertEquals("Python", stack.iterator().next());
        assertEquals("Javascript", stack.iterator().next());
        assertFalse(stack.iterator().hasNext());
        assertNull(stack.iterator().next());
        stack.push("Javascript");
        assertTrue(stack.iterator().hasNext());
        assertEquals("Javascript", stack.iterator().next());
        assertFalse(stack.iterator().hasNext());
        assertNull(stack.iterator().next());
        stack.push("Java");
        assertTrue(stack.iterator().hasNext());
        assertEquals("Java", stack.iterator().next());
        assertFalse(stack.iterator().hasNext());
        assertNull(stack.iterator().next());
    }

    @Test
    public void shouldNotIteratorIfStackIsEmpty() {
        Stack<String> stack = new ArrayStack<>();
        assertFalse(stack.iterator().hasNext());
        assertNull(stack.iterator().next());
    }

    @Test
    public void shouldNotIteratorIfRemoveElementsInStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertTrue(stack.iterator().hasNext());
        assertEquals("Java", stack.iterator().next());
        assertTrue(stack.iterator().hasNext());
        assertEquals("Python", stack.iterator().next());
        assertTrue(stack.iterator().hasNext());
        stack.pop();
        assertFalse(stack.iterator().hasNext());
        assertNull(stack.iterator().next());
    }
}
