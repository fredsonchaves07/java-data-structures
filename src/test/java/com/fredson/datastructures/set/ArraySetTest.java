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
        set.delete("Python");
        set.delete("Java");
        assertFalse(set.hasElement("Java"));
        assertFalse(set.hasElement("Python"));
        assertEquals(3, set.length());
        set.add("Java");
        assertTrue(set.hasElement("Java"));
        set.delete("C");
        assertFalse(set.hasElement("C"));
    }

    @Test
    public void shouldClearSet() {
        Set<String> set = new ArraySet<>();
        set.add("Java");
        set.add("Python");
        set.add("Javascript");
        set.add("C");
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void shouldAddElementAfterClearSet() {
        Set<String> set = new ArraySet<>();
        set.add("Java");
        set.add("Python");
        set.add("Javascript");
        set.add("C");
        set.clear();
        assertTrue(set.isEmpty());
        set.add("Python");
        set.add("Javascript");
        assertFalse(set.isEmpty());
        assertEquals(2, set.length());
    }

    @Test
    public void shouldGetElements() {
        Set<String> set = new ArraySet<>();
        String expected = "[Java, Python, Javascript, C]";
        set.add("Java");
        set.add("Python");
        set.add("Javascript");
        set.add("C");
        assertEquals(expected, set.values().toString());
    }

    @Test
    public void unionSet() {
        Set<String> set1 = new ArraySet<>();
        Set<String> set2 = new ArraySet<>();
        String expected = "[Java, Python, C]";
        set1.add("Java");
        set1.add("Python");
        set2.add("Java");
        set2.add("Python");
        set2.add("C");
        Set<String> unionSet = set2.union(set1);
        assertEquals(3, unionSet.length());
        assertFalse(unionSet.isEmpty());
        assertTrue(unionSet.hasElement("Java"));
        assertTrue(unionSet.hasElement("Python"));
        assertTrue(unionSet.hasElement("C"));
        assertEquals(expected, unionSet.toString());
    }

    @Test
    public void intersectionSet() {
        Set<String> set1 = new ArraySet<>();
        Set<String> set2 = new ArraySet<>();
        String expected = "[Java, Python]";
        set1.add("Java");
        set1.add("Python");
        set2.add("Java");
        set2.add("Python");
        set2.add("C");
        Set<String> intersectionSet = set2.intersection(set1);
        assertEquals(2, intersectionSet.length());
        assertFalse(intersectionSet.isEmpty());
        assertTrue(intersectionSet.hasElement("Java"));
        assertTrue(intersectionSet.hasElement("Python"));
        assertEquals(expected, intersectionSet.toString());
    }

    @Test
    public void differenceSet() {
        Set<String> set1 = new ArraySet<>();
        Set<String> set2 = new ArraySet<>();
        String expected = "[C]";
        set1.add("Java");
        set1.add("Python");
        set1.add("C");
        set2.add("Java");
        set2.add("Python");
        Set<String> intersectionSet = set1.difference(set2);
        assertEquals(1, intersectionSet.length());
        assertFalse(intersectionSet.isEmpty());
        assertTrue(intersectionSet.hasElement("C"));
        assertEquals(expected, intersectionSet.toString());
    }

    @Test
    public void isSubSetOf() {
        Set<String> set1 = new ArraySet<>();
        Set<String> set2 = new ArraySet<>();
        set1.add("Java");
        set1.add("Python");
        set2.add("Java");
        set2.add("Python");
        set2.add("C");
        assertTrue(set1.isSubSetOf(set2));
    }

    @Test
    public void isNotSubSetOf() {
        Set<String> set1 = new ArraySet<>();
        Set<String> set2 = new ArraySet<>();
        set1.add("C++");
        set1.add("Javascript");
        set2.add("Java");
        set2.add("Python");
        set2.add("C");
        assertFalse(set1.isSubSetOf(set2));
    }
}
