package com.fredson.datastructures;

import com.fredson.datastructures.Vector;
import org.junit.Test;

import static org.junit.Assert.*;


public class VectorTest {

    @Test
    public void shouldCreateVector() {
        Vector<String> vector = new Vector<>();
        assertTrue(vector.push("Java"));
        assertTrue(vector.push("Python"));
        assertTrue(vector.push("Javascript"));
    }

    @Test
    public void ShouldCreateVectorWithCapacity() {
        Vector<String> vector = new Vector(5);
        assertTrue(vector.push("Java"));
        assertTrue(vector.push("Python"));
        assertTrue(vector.push("Javascript"));
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
        assertTrue(vector.push("Javascript", 1));
        System.out.println(vector);
    }

    @Test
    public void ShouldIncreaseVector() {
        Vector<String> vector = new Vector(3);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        vector.push("C");
        assertTrue(true);
        System.out.println(vector);
    }

    @Test
    public void ShouldRemoveElementByPosition() {
        Vector<String> vector = new Vector(3);
        vector.push("Java");
        vector.push("Python");
        assertTrue(vector.remove(0));
        System.out.println(vector);
    }

    @Test
    public void ShouldRemoveElement() {
        Vector<String> vector = new Vector(5);
        vector.push("Java");
        vector.push("Python");
        vector.push("Javascript");
        assertTrue(vector.remove("Python"));
        System.out.println(vector);
    }

    @Test
    public void ShouldCreateGenericVector() {
        Vector<String> vectorString = new Vector(5);
        Vector<Integer> vectorNumber = new Vector(3);
        assertTrue(vectorString.push("Java"));
        assertTrue(vectorString.push("Python"));
        assertTrue(vectorString.push("Javascript"));
        assertTrue(vectorNumber.push(2));
        assertTrue(vectorNumber.push(5));
        assertTrue(vectorNumber.push(1));
    }

    @Test
    public void ShouldLastIndexOf() {
        Vector<String> vectorString = new Vector(5);
        assertTrue(vectorString.push("Java"));
        assertTrue(vectorString.push("Python"));
        assertTrue(vectorString.push("Java"));
        assertEquals(2, vectorString.lastIndexOf("Java"));
    }
}
