package com.fredson.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursiveTest {

    @Test
    public void shouldFactorialRecursiveNumber5() {
        int number = 5;
        int expected = 120;
        assertEquals(expected, Recursive.factorialRecursive(number));
    }

    @Test
    public void shouldFactorialRecursiveNumber3() {
        int number = 3;
        int expected = 6;
        assertEquals(expected, Recursive.factorialRecursive(number));
    }

    @Test
    public void shouldFactorialRecursiveNumber100() {
        int number = 10;
        int expected = 3628800;
        assertEquals(expected, Recursive.factorialRecursive(number));
    }

    @Test
    public void shouldSumNumbersWithRecursiveLinear() {
        int[] numbers = {10, 5, 3, 100, 50, 30, 100, 6, 8, 100, 6, 20, 56, 7};
        assertEquals(501, Recursive.linearSum(numbers, numbers.length));
    }
}
