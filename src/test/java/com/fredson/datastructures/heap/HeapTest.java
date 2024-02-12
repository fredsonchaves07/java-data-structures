package com.fredson.datastructures.heap;

import com.fredson.datastructures.tree.LinkedBinaryTree;
import com.fredson.datastructures.tree.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void shouldInsertElementInMinHeap() {
        Heap<Integer> heap = new MinHeap<>();
        String heapListExpected = "[1, 2, 4, 5, 3]";
        String heapStringExpected = "1 -> (2 -> (5, 3), 4)";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertFalse(heap.isEmpty());
        assertEquals(5, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldInsertElementInMaxHeap() {
        Heap<Integer> heap = new MaxHeap<>();
        String heapListExpected = "[5, 4, 3, 2, 1]";
        String heapStringExpected = "5 -> (4 -> (2, 1), 3)";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertFalse(heap.isEmpty());
        assertEquals(5, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldReturnMinHeapIsEmpty() {
        Heap<Integer> heap = new MinHeap<>();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.length());
        assertEquals("[]", heap.toList().toString());
        assertEquals("[]", heap.toString());
    }

    @Test
    public void shouldReturnMaxHeapIsEmpty() {
        Heap<Integer> heap = new MaxHeap<>();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.length());
        assertEquals("[]", heap.toList().toString());
        assertEquals("[]", heap.toString());
    }

    @Test
    public void shouldReturnMinHeapWithBinaryTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String heapListExpected = "[Academico, Contas a pagar, Empresa A, Financeiro, Contas a receber, Secretaria, Tesouraria]";
        String heapStringExpected = "Academico -> (Contas a pagar -> (Financeiro, Contas a receber), Empresa A -> (Secretaria, Tesouraria))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        Heap<String> heap = new MinHeap<>(tree);
        assertFalse(heap.isEmpty());
        assertEquals(7, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldReturnMaxHeapWithBinaryTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String heapListExpected = "[Tesouraria, Empresa A, Secretaria, Contas a pagar, Contas a receber, Academico, Financeiro]";
        String heapStringExpected = "Tesouraria -> (Empresa A -> (Contas a pagar, Contas a receber), Secretaria -> (Academico, Financeiro))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        Heap<String> heap = new MaxHeap<>(tree);
        assertFalse(heap.isEmpty());
        assertEquals(7, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldFindMinValueInHeap() {
        Heap<Integer> heap = new MinHeap<>();
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertEquals(Integer.valueOf(1), heap.find());
    }

    @Test
    public void shouldFindMaxValueInHeap() {
        Heap<Integer> heap = new MaxHeap<>();
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertEquals(Integer.valueOf(5), heap.find());
    }

    @Test
    public void shouldExtractValueMinInHeap() {
        Heap<Integer> heap = new MinHeap<>();
        String heapListExpected = "[2, 3, 4, 5]";
        String heapStringExpected = "2 -> (3 -> (5), 4)";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertEquals(Integer.valueOf(1), heap.extract());;
        assertFalse(heap.isEmpty());
        assertEquals(4, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldExtractValueMaxInHeap() {
        Heap<Integer> heap = new MaxHeap<>();
        String heapListExpected = "[4, 2, 3, 1]";
        String heapStringExpected = "4 -> (2 -> (1), 3)";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertEquals(Integer.valueOf(5), heap.extract());;
        assertFalse(heap.isEmpty());
        assertEquals(4, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldExtractValueMinInHeapWithOneElement() {
        Heap<Integer> heap = new MinHeap<>();
        String heapStringExpected = "[]";
        heap.insert(2);
        assertEquals(Integer.valueOf(2), heap.extract());;
        assertTrue(heap.isEmpty());
        assertTrue(heap.toList().isEmpty());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldExtractValueMaxInHeapWithOneElement() {
        Heap<Integer> heap = new MaxHeap<>();
        String heapStringExpected = "[]";
        heap.insert(2);
        assertEquals(Integer.valueOf(2), heap.extract());;
        assertTrue(heap.isEmpty());
        assertTrue(heap.toList().isEmpty());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldInsertElementWithExtractValueInMinHeap() {
        Heap<Integer> heap = new MinHeap<>();
        String heapListExpected = "[0, 3, 2, 5, 8, 4, 6]";
        String heapStringExpected = "0 -> (3 -> (5, 8), 2 -> (4, 6))";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertEquals(Integer.valueOf(1), heap.extract());;
        assertFalse(heap.isEmpty());
        assertEquals(4, heap.length());
        heap.insert(8);
        heap.insert(0);
        heap.insert(6);
        assertEquals(Integer.valueOf(0), heap.find());
        assertEquals(7, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldInsertElementWithExtractValueInMaxHeap() {
        Heap<Integer> heap = new MaxHeap<>();
        String heapListExpected = "[8, 4, 6, 1, 2, 0, 3]";
        String heapStringExpected = "8 -> (4 -> (1, 2), 6 -> (0, 3))";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(1);
        assertEquals(Integer.valueOf(5), heap.extract());;
        assertFalse(heap.isEmpty());
        assertEquals(4, heap.length());
        heap.insert(8);
        heap.insert(0);
        heap.insert(6);
        assertEquals(Integer.valueOf(8), heap.find());
        assertEquals(7, heap.length());
        assertEquals(heapListExpected, heap.toList().toString());
        assertEquals(heapStringExpected, heap.toString());
    }

    @Test
    public void shouldConvertMinHeapInTree() {
        Heap<Integer> heap = new MinHeap<>();
        String treeStringExpected = "0 -> (3 -> (2, 5 -> (4, 8 -> (6))))";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(8);
        heap.insert(0);
        heap.insert(6);
        assertEquals(treeStringExpected, heap.toTree().toString());
    }

    @Test
    public void shouldConvertMaxHeapInTree() {
        Heap<Integer> heap = new MaxHeap<>();
        String treeStringExpected = "8 -> (5 -> (2 -> (0, 4 -> (3)), 6))";
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(8);
        heap.insert(0);
        heap.insert(6);
        assertEquals(treeStringExpected, heap.toTree().toString());
    }
}
