package com.fredson.algorithms;

import com.fredson.datastructures.list.List;

public class Recursive {

    public static int factorialRecursive(int number) {
        if (number == 0) return 1;
        return number * factorialRecursive(number - 1);
    }

    public static int linearSum(int[] numbers, int size) {
        if (size == 1) return numbers[0];
        return linearSum(numbers, size - 1) + numbers[size - 1];
    }

    public static int binarySum(int[] numbers, int size) {
        return binarySum(numbers, 0, size);
    }

    private static int binarySum(int[] numbers, int i, int size) {
        if (size == 1) return numbers[i];
        return binarySum(numbers, i, size / 2) + binarySum(numbers, (size / 2) + i, size / 2);
    }

    public static <T> void reverseList(List<T> list) {
        reverseList(list, 0, list.length() - 1);
    }

    private static <T> void reverseList(List<T> list, int i, int j) {
        if (i < j) {
            T firstElement = list.getElement(i);
            T secondElement = list.getElement(j);
            list.push(secondElement, i);
            list.push(firstElement, j);
            reverseList(list, i + 1, j - 1);
        }
    }
}
