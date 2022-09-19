package com.fredson.datastructures.sequence;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    @Test
    public void shouldGetNamesOnBinarySearch() {
        String[] names = {"Ana", "Carlos", "Beatriz", "Clelton", "Silva", "Maria"};
        Collections.sort(Arrays.asList(names));
        assertEquals("Maria", Search.binarySearch(names, "Maria"));
        assertEquals("Beatriz", Search.binarySearch(names, "Beatriz"));
        assertEquals("Ana", Search.binarySearch(names, "Ana"));
    }
}
