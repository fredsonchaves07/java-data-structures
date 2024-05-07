package com.fredson.datastructures.sort;

import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;

public class MergeSort<T extends Comparable<T>> implements Sort {

    @Override
    public void sort() {

    }

    @Override
    public void sortReversed() {

    }

    public static <T extends Comparable<T>> List<T> sort(List<T> elements) {
        if (elements.length() == 1) return elements;
        return new ArrayList<>(sort(elements.toArray()));
    }

    public static <T extends Comparable<T>> T[] sort(T[] elements) {
        if (elements.length == 1) return elements;
        int mid = (elements.length / 2);
        T[] leftArray = (T[]) new Comparable[mid];
        T[] rightArray = (T[]) new Comparable[mid];
        for (int index = 0; index < mid; index ++) {
            leftArray[index] = elements[index];
        }
        int rightDivisionIndex = 0;
        for (int index = mid; index < elements.length; index ++) {
            rightArray[rightDivisionIndex] = elements[index];
            rightDivisionIndex ++;
        }
        return mergeSort(sort(leftArray), sort(rightArray));
    }

    private static <T extends Comparable<T>> T[] mergeSort(T[] leftArray, T[]  rightArray) {
        List<T> combined = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i].compareTo(rightArray[j]) < 0) {
                combined.push(leftArray[i]);
                i++;
            } else {
                combined.push(rightArray[j]);
                j++;
            }
        }
        while(i < leftArray.length) {
            combined.push(leftArray[i]);
            i++;
        }
        while(j < rightArray.length) {
            combined.push(rightArray[j]);
            j++;
        }
        return combined.toArray();
    }

    public static <T extends Comparable<T>>List<T> sortReversed(List<T> elements) {
        if (elements.length() == 1) return elements;
        return new ArrayList<>(sortReversed(elements.toArray()));
    }

    public static <T extends Comparable<T>> T[] sortReversed(T[] elements) {
        if (elements.length == 1) return elements;
        int mid = (elements.length / 2);
        T[] leftArray = (T[]) new Comparable[mid];
        T[] rightArray = (T[]) new Comparable[mid];
        for (int index = 0; index < mid; index ++) {
            leftArray[index] = elements[index];
        }
        int rightDivisionIndex = 0;
        for (int index = mid; index < elements.length; index ++) {
            rightArray[rightDivisionIndex] = elements[index];
            rightDivisionIndex ++;
        }
        return mergeSortReversed(sortReversed(leftArray), sortReversed(rightArray));
    }

    private static <T extends Comparable<T>> T[] mergeSortReversed(T[] leftArray, T[]  rightArray) {
        List<T> combined = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i].compareTo(rightArray[j]) > 0) {
                combined.push(leftArray[i]);
                i++;
            } else {
                combined.push(rightArray[j]);
                j++;
            }
        }
        while(i < leftArray.length) {
            combined.push(leftArray[i]);
            i++;
        }
        while(j < rightArray.length) {
            combined.push(rightArray[j]);
            j++;
        }
        return combined.toArray();
    }
}
