package com.fredson.datastructures.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultMapTest {

    @Test
    public void shouldAddElementInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[{'Primeira categoria':10}, {'Segunda categoria':65}, {'Terceira categoria':100}]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertFalse(map.isEmpty());
        assertEquals(3, map.length());
        assertEquals(Integer.valueOf(10), map.get("Primeira categoria"));
        assertEquals(Integer.valueOf(65), map.get("Segunda categoria"));
        assertEquals(Integer.valueOf(100), map.get("Terceira categoria"));
        assertEquals(expected, map.toString());
    }

    @Test
    public void notShouldAddElementIfElementIsNullInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[]";
        map.set("Primeira categoria", null);
        assertFalse(map.hasKey("Primeira categoria"));
        assertTrue(map.isEmpty());
        assertEquals(expected, map.toString());
    }

    @Test
    public void notShouldAddElementIfKeyIsNullInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[]";
        map.set(null, 10);
        assertFalse(map.hasKey(null));
        assertTrue(map.isEmpty());
        assertEquals(expected, map.toString());
    }

    @Test
    public void notShouldAddElementIfKeyAndElementIsNullInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[]";
        map.set(null, null);
        assertFalse(map.hasKey(null));
        assertTrue(map.isEmpty());
        assertEquals(expected, map.toString());
    }

    @Test
    public void shouldHasKeyInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertTrue(map.hasKey("Primeira categoria"));
        assertTrue(map.hasKey("Segunda categoria"));
        assertTrue(map.hasKey("Terceira categoria"));
    }

    @Test
    public void notShouldHasKeyInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertFalse(map.hasKey("Quarta categoria"));
    }

    @Test
    public void shouldRemoveElementInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[{'Primeira categoria':10}, {'Terceira categoria':100}]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        map.remove("Segunda categoria");
        assertEquals(2, map.length());
        assertFalse(map.hasKey("Segunda categoria"));
        assertEquals(expected, map.toString());
    }

    @Test
    public void notShouldRemoveElementIfKeyIsNull() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[{'Primeira categoria':10}, {'Segunda categoria':65}, {'Terceira categoria':100}]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        map.remove(null);
        assertEquals(3, map.length());
        assertTrue(map.hasKey("Primeira categoria"));
        assertTrue(map.hasKey("Segunda categoria"));
        assertTrue(map.hasKey("Terceira categoria"));
        assertEquals(expected, map.toString());
    }

    @Test
    public void notShouldRemoveElementIfKeyisNotExisting() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[{'Primeira categoria':10}, {'Segunda categoria':65}, {'Terceira categoria':100}]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        map.remove("test");
        assertEquals(3, map.length());
        assertTrue(map.hasKey("Primeira categoria"));
        assertTrue(map.hasKey("Segunda categoria"));
        assertTrue(map.hasKey("Terceira categoria"));
        assertEquals(expected, map.toString());
    }

    @Test
    public void getElementInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertEquals(Integer.valueOf(10), map.get("Primeira categoria"));
        assertEquals(Integer.valueOf(65), map.get("Segunda categoria"));
        assertEquals(Integer.valueOf(100), map.get("Terceira categoria"));
    }

    @Test
    public void notGetElementInMapIfKeyIsNull() {
        Map<String, Integer> map = new DefaultMap<>();
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertNull(map.get(null));
    }

    @Test
    public void notGetElementInMapIfNotExistingKey() {
        Map<String, Integer> map = new DefaultMap<>();
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertNull(map.get("Quarta"));
    }

    @Test
    public void shouldGetValuesInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[10, 65, 100]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertNotNull(map.values());
        assertFalse(map.values().isEmpty());
        assertEquals(expected, map.values().toString());
    }

    @Test
    public void shouldGetKeysInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[Primeira categoria, Segunda categoria, Terceira categoria]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertNotNull(map.keys());
        assertFalse(map.keys().isEmpty());
        assertEquals(expected, map.keys().toString());
    }

    @Test
    public void shouldGetKeyValueInMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[{'Primeira categoria':10}, {'Segunda categoria':65}, {'Terceira categoria':100}]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        assertNotNull(map.keysValues());
        assertFalse(map.keysValues().isEmpty());
        assertEquals(expected, map.keysValues().toString());
    }

    @Test
    public void shouldClearMap() {
        Map<String, Integer> map = new DefaultMap<>();
        String expected = "[]";
        map.set("Primeira categoria", 10);
        map.set("Segunda categoria", 65);
        map.set("Terceira categoria", 100);
        map.clear();
        assertEquals(0, map.length());
        assertTrue(map.isEmpty());
        assertEquals(expected, map.toString());
    }
}
