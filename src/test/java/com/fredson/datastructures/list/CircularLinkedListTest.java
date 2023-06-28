package com.fredson.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CircularLinkedListTest {

    @Test
    public void shouldCreateList() {
        List<String> list = new CircularLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals(3, list.length());
        assertEquals("[Java, Python, Javascript]", list.toString());
    }

    @Test
    public void shouldInsertElementInIndex() {
        List<String> list = new CircularLinkedList<>();
        list.push("Java", 1);
        list.push("Python", 0);
        list.push("Javascript", 11);
        list.push("C++", 2);
        assertEquals(4, list.length());
        assertEquals("[Python, Java, C++, Javascript]", list.toString());
    }

    @Test
    public void shouldInsertElementFirstLastAndIndex() {
        List<String> list = new CircularLinkedList<>();
        list.push("Java");
        list.push("Javascript");
        list.push("Python", 0);
        list.push("C++", 2);
        assertEquals(3, list.length());
        assertEquals("[Python, Javascript, C++]", list.toString());
    }

    @Test
    public void shouldInsertElementFirstIndexAndLast() {
        List<String> list = new CircularLinkedList<>();
        list.push("C++", 2);
        list.push("Java");
        list.push("Javascript");
        list.push("Python", 0);
        list.push("Delphi", 1);
        assertEquals(5, list.length());
        assertEquals("[Python, Delphi, C++, Java, Javascript]", list.toString());
    }

    @Test
    public void shouldCreateListEmpty() {
        List<String> list = new CircularLinkedList<>();
        assertTrue(list.isEmpty());
    }
}
