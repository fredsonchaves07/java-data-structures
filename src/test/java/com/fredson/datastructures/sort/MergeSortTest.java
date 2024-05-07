package com.fredson.datastructures.sort;

import com.fredson.datastructures.list.LinkedList;
import com.fredson.datastructures.list.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTest {

    @Test
    public void shouldSortStringElements() {
        List<String> persons = new LinkedList<>();
        String expected = "[Antonio, Carlos, Rafaela, Zeus]";
        persons.push("Carlos");
        persons.push("Antonio");
        persons.push("Zeus");
        persons.push("Rafaela");
        persons = MergeSort.sort(persons);
        assertEquals(expected, persons.toString());
    }

    @Test
    public void shouldSortIntegerElements() {
        List<Integer> persons = new LinkedList<>();
        String expected = "[0, 1, 3, 5, 9, 20, 50, 1000]";
        persons.push(1000);
        persons.push(3);
        persons.push(5);
        persons.push(0);
        persons.push(9);
        persons.push(20);
        persons.push(50);
        persons.push(1);
        persons = MergeSort.sort(persons);
        assertEquals(expected, persons.toString());
    }

    @Test
    public void shouldReverseStringElements() {
        List<String> persons = new LinkedList<>();
        String expected = "[Zeus, Rafaela, Carlos, Antonio]";
        persons.push("Carlos");
        persons.push("Antonio");
        persons.push("Zeus");
        persons.push("Rafaela");
        persons = MergeSort.sortReversed(persons);
        assertEquals(expected, persons.toString());
    }

    @Test
    public void shouldReverseIntegerElements() {
        List<Integer> persons = new LinkedList<>();
        String expected = "[1000, 50, 20, 9, 5, 3, 1, 0]";
        persons.push(1000);
        persons.push(3);
        persons.push(5);
        persons.push(0);
        persons.push(9);
        persons.push(20);
        persons.push(50);
        persons.push(1);
        persons = MergeSort.sortReversed(persons);
        assertEquals(expected, persons.toString());
    }
}
