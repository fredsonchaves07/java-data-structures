package com.fredson.datastructures.algorithms;

import org.junit.Test;

import static com.fredson.algorithms.BaseConverter.baseConverter;
import static org.junit.Assert.assertEquals;

public class BaseConverterTest {

    @Test
    public void shouldConverterNumberToBase2() {
        assertEquals("11000011111111001", baseConverter(100345, 2));
    }

    @Test
    public void shouldConverterNumberToBase8() {
        assertEquals("303771", baseConverter(100345, 8));
    }

    @Test
    public void shouldConverterNumberToBase16() {
        assertEquals("187F9", baseConverter(100345, 16));
    }
}
