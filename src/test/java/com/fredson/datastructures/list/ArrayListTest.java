package com.fredson.datastructures.list;

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
        List<String> list = new ArrayList<>(3);
        list.push("Java");
        list.push("Javascript");
        list.push("Python", 0);
        list.push("C++", 2);
        assertEquals(3, list.length());
        assertEquals("[Python, Javascript, C++]", list.toString());
    }

    @Test
    public void shouldInsertElementFirstLastAndIndex() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Javascript");
        list.push("Python", 0);
        list.push("C++", 2);
        assertEquals(3, list.length());
        assertEquals("[Python, Javascript, C++]", list.toString());
    }

    @Test
    public void shouldInsertElementFirstIndexAndLast() {
        List<String> list = new ArrayList<>();
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

    @Test
    public void shouldRemoveElement() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        list.remove("Python");
        assertEquals(2, list.length());
    }

    @Test
    public void shouldRemoveElementAtIndex() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        list.remove(2);
        assertEquals(2, list.length());
    }

    @Test
    public void shouldGetIndexElement() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals(1, list.indexOf("Python"));
    }

    @Test
    public void shouldGetElementByElement() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals("Python", list.getElement("Python"));
    }

    @Test
    public void shouldGetElementByIndex() {
        List<String> list = new ArrayList<>();
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        assertEquals("Python", list.getElement(1));
    }
}
