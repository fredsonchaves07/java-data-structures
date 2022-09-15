package com.fredson.datastructures.sequence;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    @Test
    public void shouldGetNamesOnBinarySearch() {
        List<String> names = Arrays.asList("Ana", "Carlos", "Beatriz", "Clelton", "Silva", "Maria");
        Collections.sort(names);
        Search<String> search = new Search<>(names);
        assertEquals("Maria", search.binarySearch("Maria"));
        assertEquals("Beatriz", search.binarySearch("Beatriz"));
        assertEquals("Ana", search.binarySearch("Ana"));
    }
}
