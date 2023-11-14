package com.fredson.datastructures.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedBinaryTreeTest {

    @Test
    public void shouldCreateBinaryTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String listStringExpected = "[Empresa A, Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria]";
        String treeStringExpected = "" +
                "Empresa A -> (Financeiro -> (Contas a pagar, Contas a receber), Academico -> (Secretaria))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        assertEquals(6, tree.size());
        assertFalse(tree.nodes().isEmpty());
        assertEquals(6, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldInsertNodesInBinaryTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String listStringExpected =
                "[Empresa A, Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria, Tesouraria]";
        String treeStringExpected =
                "Empresa A -> (Financeiro -> (Contas a pagar, Contas a receber -> (Tesouraria)), Academico -> (Secretaria))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(7, tree.size());
        assertFalse(tree.nodes().isEmpty());
        assertEquals(7, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldPrintNodesInOrderInTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String listStringExpected
                = "[Empresa A, Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria, Tesouraria]";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(listStringExpected, tree.inOrder().toString());
    }

    @Test
    public void shouldPrintNodesPreOrderInTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String listStringExpected =
                "[Empresa A, Financeiro, Contas a pagar, Contas a receber, Tesouraria, Academico, Secretaria]";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(listStringExpected, tree.preOrder().toString());
    }

    @Test
    public void shouldPrintNodesPosOrderInTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String listStringExpected =
                "[Contas a pagar, Tesouraria, Contas a receber, Financeiro, Secretaria, Academico, Empresa A]";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(listStringExpected, tree.posOrder().toString());
    }

    @Test
    public void shouldReturnMinValueInTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String expected = "Contas a pagar";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(expected, tree.min());
    }

    @Test
    public void shouldReturnMaxValueInTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String expected = "Academico";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(expected, tree.max());
    }

    @Test
    public void shouldSearchElementInTree() {
        Tree<String> tree = new LinkedBinaryTree<>();
        String expected = "Tesouraria";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertTrue(expected, tree.search("Tesouraria"));
        assertTrue(expected, tree.search("Secretaria"));
        assertTrue(expected, tree.search("Contas a pagar"));
        assertTrue(expected, tree.search("Empresa A"));
        assertTrue(expected, tree.search("Financeiro"));
        assertTrue(expected, tree.search("Academico"));
        assertTrue(expected, tree.search("Contas a receber"));
        assertFalse(expected, tree.search("Administrativo"));
    }
}
