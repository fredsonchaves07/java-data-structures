package com.fredson.datastructures.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySetTest {

    @Test
    public void shouldAddElement() {
        Set<String> set = new ArraySet<>();
        String stringExpected = "[Java, Python, Javascript, C]";
        set.add("Java");
        set.add("Python");
        set.add("Javascript");
        set.add("C");
        assertTrue(set.hasElement("Java"));
        assertTrue(set.hasElement("Python"));
        assertTrue(set.hasElement("Javascript"));
        assertTrue(set.hasElement("C"));
        assertFalse(set.isEmpty());
        assertEquals(4, set.length());
        assertEquals(stringExpected, set.toString());
    }

    @Test
    public void notShouldHasElement() {
        Set<String> set = new ArraySet<>();
        String stringExpected = "[Java, Python, Javascript, C]";
        set.add("Java");
        set.add("Python");
        set.add("Javascript");
        set.add("C");
        assertFalse(set.hasElement("Kotlin"));
        assertEquals(stringExpected, set.toString());
    }

    @Test
    public void shouldDeleteElement() {
        Set<String> set = new ArraySet<>();
        String stringExpected = "[Java, Python, C]";
        set.add("Java");
        set.add("Python");
        set.add("Javascript");
        set.add("C");
        set.delete("Javascript");
        assertFalse(set.hasElement("Javascript"));
        assertEquals(3, set.length());
        assertEquals(stringExpected, set.toString());
    }

    @Test
    public void shouldDeleteAndAddElementInSet() {
        Set<String> set = new ArraySet<>();
        set.add("Java");
        set.add("Python");
        set.add("Javascript");
        set.add("C");
        set.delete("Javascript");
        assertFalse(set.hasElement("Javascript"));
        assertEquals(3, set.length());
        set.add("Kotlin");
        set.add("C++");
        assertEquals(5, set.length());
        set.delete("Py");
        set.delete("Java");
        assertFalse(set.hasElement("Java"));
        assertFalse(set.hasElement("Javascript"));
        assertEquals(3, set.length());
        set.add("Java");
        assertTrue(set.hasElement("Java"));
        set.delete("C");
        assertFalse(set.hasElement("C"));
    }
}
