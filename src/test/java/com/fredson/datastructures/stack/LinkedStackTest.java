package com.fredson.datastructures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {

    @Test
    public void shouldCreateStack() {
        Stack<String> stack = new LinkedStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertEquals(3, stack.length());
    }

    @Test
    public void ShouldCreateStackEmpty() {
        Stack<String> vector = new LinkedStack<>();
        assertTrue(vector.isEmpty());
    }

    @Test
    public void ShouldPrintStack() {
        Stack<String> stack = new LinkedStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        System.out.println(stack);
    }

    @Test
    public void ShouldPeekStack() {
        Stack<String> stack = new LinkedStack<>();
        stack.push("Java");
        assertEquals("Java", stack.peek());
    }

    @Test
    public void ShouldPopStack() {
        Stack<String> stack = new LinkedStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertEquals("Javascript", stack.pop());
        assertEquals(2, stack.length());
    }

    @Test
    public void shouldIteratorStack() {
        Stack<String> stack = new LinkedStack<>();
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
        Stack<String> stack = new LinkedStack<>();
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
        Stack<String> stack = new LinkedStack<>();
        assertFalse(stack.iterator().hasNext());
        assertNull(stack.iterator().next());
    }

    @Test
    public void shouldNotIteratorIfRemoveElementsInStack() {
        Stack<String> stack = new LinkedStack<>();
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
