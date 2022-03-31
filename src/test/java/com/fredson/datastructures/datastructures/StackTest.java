package com.fredson.datastructures.datastructures;

import com.fredson.datastructures.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackTest {

    @Test
    public void shouldCreateStack() {
        Stack<String> stack = new Stack<>();
        assertTrue(stack.push("Java"));
        assertTrue(stack.push("Python"));
        assertTrue(stack.push("Javascript"));
    }

    @Test
    public void ShouldCreateStackWithCapacity() {
        Stack<String> stack = new Stack<>(3);
        assertTrue(stack.push("Java"));
        assertTrue(stack.push("Python"));
        assertTrue(stack.push("Javascript"));
    }

    @Test
    public void ShouldCreateStackEmpty() {
        Stack<String> vector = new Stack<>();
        assertTrue(vector.isEmpty());
    }

    @Test
    public void ShouldPrintStack() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        System.out.println(stack);
    }

    @Test
    public void ShouldPeekStack() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        assertEquals("Java", stack.peek());
    }

    @Test
    public void ShouldPopStack() {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        assertEquals("Javascript", stack.pop());
        assertEquals(2, stack.length());
    }
}
