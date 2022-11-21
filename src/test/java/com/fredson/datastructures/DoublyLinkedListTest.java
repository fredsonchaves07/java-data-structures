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
    }

    @Test
    public void shouldRemoveElementAtIndex() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        list.remove(1);
        assertEquals(2, list.length());
    }

    @Test
    public void shouldGetIndexElement() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals(1, list.indexOf("Python"));
    }

    @Test
    public void shouldGetElementByElement() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals("Python", list.getElement("Python"));
    }

    @Test
    public void shouldGetElementByIndex() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals("Python", list.getElement(1));
    }

    @Test
    public void shouldClearList() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void shouldCreateListAfterClearList() {
        List<String> list = new DoublyLinkedList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        list.clear();
        list.push("Java");
        list.push("Python");
        assertEquals(2, list.length());
        assertEquals(0, list.indexOf("Java"));
        assertEquals(1, list.indexOf("Python"));
    }
}
