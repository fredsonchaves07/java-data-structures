package com.fredson.algorithms;

public class Recursive {

    public static int factorialRecursive(int number) {
        if (number == 0) return 1;
        return number * factorialRecursive(number - 1);
    }

    public static int linearSum(int[] numbers, int size) {
        if (size == 1) return numbers[0];
        return linearSum(numbers, size - 1) + numbers[size - 1];
    }
}
