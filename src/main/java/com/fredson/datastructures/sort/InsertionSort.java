package com.fredson.datastructures.sort;

import com.fredson.datastructures.list.ArrayList;
import com.fredson.datastructures.list.List;

public class InsertionSort<T extends Comparable<T>> implements Sort {

    private List<T> elementsDataStructure;

    private Object[] elementsArrayObject;


    public InsertionSort(List<T> elements) {
        this.elementsDataStructure = elements;
    }

    public InsertionSort(Object[] elements) {
        this.elementsArrayObject = elements;
    }


    @Override
    public void sort() {

    }

    @Override
    public void sortReversed() {

    }


    public static <T extends Comparable<T>> List<T> sort(List<T> elements) {
        T[] elementsArray = elements.toArray();
        for (int index = 1; index < elementsArray.length; index ++) {
            T actualElementIndex = elementsArray[index];
            int indexLoopControl = index - 1;
            T prevElementIndex = elementsArray[indexLoopControl];
            while (indexLoopControl >= 0 && prevElementIndex.compareTo(actualElementIndex) > 0) {
                elementsArray[indexLoopControl + 1] = elementsArray[indexLoopControl];
                indexLoopControl --;
                if (indexLoopControl >= 0) {
                    prevElementIndex = elementsArray[indexLoopControl];
                }
            }
            elementsArray[indexLoopControl + 1] = actualElementIndex;
        }
        return new ArrayList<>(elementsArray);
    }

//    public static void sort(Object[] elements) {
//
//    }

    public static <T extends Comparable<T>> List<T> sortReversed(List<T> elements) {
        T[] elementsArray = elements.toArray();
        for (int index = 1; index < elementsArray.length; index ++) {
            T actualElementIndex = elementsArray[index];
            int indexLoopControl = index - 1;
            T prevElementIndex = elementsArray[indexLoopControl];
            while (indexLoopControl >= 0 && prevElementIndex.compareTo(actualElementIndex) < 0) {
                elementsArray[indexLoopControl + 1] = elementsArray[indexLoopControl];
                indexLoopControl --;
                if (indexLoopControl >= 0) {
                    prevElementIndex = elementsArray[indexLoopControl];
                }
            }
            elementsArray[indexLoopControl + 1] = actualElementIndex;
        }
        return new ArrayList<>(elementsArray);
    }
//
//    public static void sortReversed(Object elements) {
//
//    }
}
