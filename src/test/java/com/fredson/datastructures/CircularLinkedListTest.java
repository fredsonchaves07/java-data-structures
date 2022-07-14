package com.fredson.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircularLinkedListTest {

    @Test
    public void shouldCreateList() {
        List<String> list = new CircularLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals(3, list.length());
        System.out.println(list);
    }
}
