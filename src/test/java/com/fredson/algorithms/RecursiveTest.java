package com.fredson.algorithms;

import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;
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

    @Test
    public void shouldSumNumbersWithRecursiveBinary() {
        int[] numbers = {10, 5, 3, 100, 50, 30, 100, 6, 8, 100, 6, 20, 56, 7};
        assertEquals(501, Recursive.binarySum(numbers, numbers.length));
    }

    @Test
    public void shouldReverseList() {
        List<String> list = new ArrayList<>();
        String expected = "[Javascript, Python, Java]";
        list.push("Java");
        list.push("Python");
        list.push("Javascript");
        Recursive.reverseList(list);
        assertEquals(expected, list.toString());
    }

    @Test
    public void shouldReturnFibonacciWithBinaryRecursive() {
        int expected = 21;
        assertEquals(expected, Recursive.fibonacciBinaryRecursive(8));
    }

    @Test
    public void shouldReturnFibonnaciWithDynamicProgram() {
        int expected = 21;
        assertEquals(expected, Recursive.fibonacciBinaryRecursiveDynamic(8));
    }
}
