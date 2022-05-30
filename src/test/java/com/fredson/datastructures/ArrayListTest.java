package com.fredson.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {

    @Test
    public void shouldCreateList() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals(3, list.length());
    }

    @Test
    public void shouldCreateListWithCapacity() {
        List<String> list = new ArrayList<>(3);
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

    @Test
    public void shouldCreateListEmpty() {
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldPrintList() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        System.out.println(list);
    }
}
