package com.fredson.datastructures.vector;

import org.junit.Test;

import static org.junit.Assert.*;


public class VectorTest {

    @Test
    public void shouldCreateVector() {
        Vector<String> vector = new Vector<>();
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        assertEquals(3, vector.length());
    }

    @Test
    public void ShouldCreateVectorWithCapacity() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        assertEquals(3, vector.length());
    }

    @Test
    public void ShouldCreateVectorEmpty() {
        Vector<String> vector = new Vector(5);
        assertTrue(vector.isEmpty());
    }

    @Test
    public void ShouldPrintVector() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        System.out.println(vector);
        assertTrue(true);
    }

    @Test
    public void ShouldGetElement() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        assertEquals("Java", vector.getElement(0));
    }

    @Test
    public void ShouldNotGetElementWithInvalidPosition() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        assertNull(vector.getElement(15));
    }

    @Test
    public void ShouldGetElementByElement() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        assertTrue(vector.contain("Java"));
    }

    @Test
    public void ShouldNotGetElementInvalid() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        assertFalse(vector.contain("C"));
    }

    @Test
    public void ShouldCreateVectorWithPosition() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript", 1);
        assertEquals(3, vector.length());
        System.out.println(vector);
    }

    @Test
    public void ShouldIncreaseVector() {
        Vector<String> vector = new Vector(3);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        vector.push("C");
        assertEquals(4, vector.length());
        System.out.println(vector);
    }

    @Test
    public void ShouldRemoveElementByPosition() {
        Vector<String> vector = new Vector(3);
        vector.push("Java");
        vector.push("Python");
        vector.remove(0);
        assertEquals(1, vector.length());
        System.out.println(vector);
    }

    @Test
    public void ShouldRemoveElement() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        vector.remove("Python");
        assertEquals(2, vector.length());
        System.out.println(vector);
    }

    @Test
    public void ShouldCreateGenericVector() {
        Vector<String> vectorString = new Vector(5);
        Vector<Integer> vectorNumber = new Vector(3);
        vectorString.push("Java");
        vectorString.push("Python");
        vectorString.push("Javascript");
        assertEquals(3, vectorString.length());
        vectorNumber.push(2);
        vectorNumber.push(5);
        vectorNumber.push(1);
        assertEquals(3, vectorNumber.length());
    }

    @Test
    public void ShouldLastIndexOf() {
        Vector<String> vectorString = new Vector(5);
        vectorString.push("Java");
        vectorString.push("Python");
        vectorString.push("Java");
        assertEquals(2, vectorString.lastIndexOf("Java"));
    }
}
