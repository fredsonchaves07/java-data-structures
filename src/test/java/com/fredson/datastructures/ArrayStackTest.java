package com.fredson.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayStackTest {

    @Test
    public void shouldCreateStack() {
        Stack<String> stack = new ArrayStack<>();
        assertTrue(stack.push("Java"));
        assertTrue(stack.push("Python"));
        assertTrue(stack.push("Javascript"));
    }

    @Test
    public void ShouldCreateStackWithCapacity() {
        Stack<String> stack = new ArrayStack<>(3);
        assertTrue(stack.push("Java"));
        assertTrue(stack.push("Python"));
        assertTrue(stack.push("Javascript"));
    }

    @Test
    public void ShouldCreateStackEmpty() {
        Stack<String> vector = new ArrayStack<>();
        assertTrue(vector.isEmpty());
    }

    @Test
    public void ShouldPrintStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        System.out.println(stack);
    }

    @Test
    public void ShouldPeekStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        assertEquals("Java", stack.peek());
    }

    @Test
    public void ShouldPopStack() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertEquals("Javascript", stack.pop());
        assertEquals(2, stack.length());
    }
}
