package com.fredson.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    @Test
    public void shouldCreateList() {
        List<String> list = new LinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals(3, list.length());
    }

    @Test
    public void shouldInsertElementInIndex() {
        List<String> list = new ArrayList<>();
        list.push("Java", 1);
        list.push("Python", 0);
        list.push("Javascript", 11);
        assertEquals(3, list.length());
    }
}
