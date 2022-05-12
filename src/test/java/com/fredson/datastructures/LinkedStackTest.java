package com.fredson.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LinkedStackTest {

    @Test
    public void shouldCreateStack() {
        LinkedStack<String> stack = new LinkedStack<>();
        assertTrue(stack.push("Java"));
        assertTrue(stack.push("Python"));
        assertTrue(stack.push("Javascript"));
    }

    @Test
    public void ShouldCreateStackEmpty() {
        LinkedStack<String> vector = new LinkedStack<>();
        assertTrue(vector.isEmpty());
    }

    @Test
    public void ShouldPrintStack() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("Javascript");
        System.out.println(stack);
    }
}
