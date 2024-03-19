package com.fredson.datastructures.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
}
