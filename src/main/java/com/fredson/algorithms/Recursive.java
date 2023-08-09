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
        if (size == 0) return 0;
        if (size == 1) return numbers[i];
        int middle = size / 2;
        return binarySum(numbers, i, middle) + binarySum(numbers, i + middle, size - middle);
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

    public static int fibonacciBinaryRecursive(int number) {
        if (number <= 1) return number;
        return fibonacciBinaryRecursive(number - 1) + fibonacciBinaryRecursive(number - 2);
    }

    public static int fibonacciBinaryRecursiveDynamic(int number) {
        int[] fibonacci = new int[number];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        return fibonacciBinaryRecursiveDynamic(fibonacci, number);
    }

    private static int fibonacciBinaryRecursiveDynamic(int[] fibonacci, int number) {
        if (fibonacci[number - 1] > 0) return fibonacci[number - 1];
        fibonacci[number - 1] = fibonacciBinaryRecursiveDynamic(fibonacci, number - 1) + fibonacciBinaryRecursiveDynamic(fibonacci, number - 2);
        return fibonacci[number - 1];
    }
}
