package com.fredson.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
}
