package com.fredson.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArrayListTest {

    @Test
    public void shouldCreateList() {
        List<String> list = new ArrayList<>();
        assertTrue(list.push("Java"));
        assertTrue(list.push("Python"));
        assertTrue(list.push("Javascript"));
    }

    @Test
    public void shouldCreateListWithCapacity() {
        List<String> list = new ArrayList<>(3);
        assertTrue(list.push("Java"));
        assertTrue(list.push("Python"));
        assertTrue(list.push("Javascript"));
    }

    @Test
    public void shouldInsertElementInIndex() {
        List<String> list = new ArrayList<>();
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
