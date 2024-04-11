package com.fredson.datastructures.sequence;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

    @Test
    public void shouldGetNamesOnBinarySearch() {
        String[] names = {"Ana", "Carlos", "Beatriz", "Clelton", "Silva", "Maria"};
        Arrays.sort(names);
        assertEquals("Maria", Search.binarySearch(names, "Maria"));
        assertEquals("Beatriz", Search.binarySearch(names, "Beatriz"));
        assertEquals("Ana", Search.binarySearch(names, "Ana"));
    }

    @Test
    public void shouldGetNumbersOnBinarySearch() {
        Integer[] numbers = generate0to1000NumbersArray();
        Arrays.sort(numbers);
        assertEquals(Integer.valueOf(0), Search.binarySearch(numbers, 0));
        assertEquals(Integer.valueOf(100), Search.binarySearch(numbers, 100));
        assertEquals(Integer.valueOf(500), Search.binarySearch(numbers, 500));
        assertEquals(Integer.valueOf(300), Search.binarySearch(numbers, 300));
        assertEquals(Integer.valueOf(999), Search.binarySearch(numbers, 999));
        assertEquals(Integer.valueOf(600), Search.binarySearch(numbers, 600));
    }

    private Integer[] generate0to1000NumbersArray() {
        Integer[] numbers = new Integer[1000];
        for (int i = 0; i < numbers.length; i ++) numbers[i] = i;
        return numbers;
    }
}
