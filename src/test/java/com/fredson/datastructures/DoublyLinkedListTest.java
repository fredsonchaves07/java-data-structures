package com.fredson.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedListTest {

    @Test
    public void shouldCreateList() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals(3, list.length());
    }

    @Test
    public void shouldInsertElementInIndex() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java", 1);
        list.push("Python", 0);
        list.push("Javascript", 11);
        list.push("C++", 4);
        assertEquals(4, list.length());
    }

    @Test
    public void shouldCreateListEmpty() {
        List<String> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldPrintList() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        System.out.println(list);
    }

    @Test
    public void shouldRemoveElement() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        list.remove("Javascript");
        assertEquals(2, list.length());
        System.out.println(list);
    }

    @Test
    public void shouldRemoveElementAtIndex() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        list.remove(1);
        assertEquals(2, list.length());
        System.out.println(list);
    }
}
