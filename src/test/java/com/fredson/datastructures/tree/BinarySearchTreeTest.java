package com.fredson.datastructures.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void shouldCreateBinarySearchTree() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected = "[Empresa A, Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria]";
        String treeStringExpected = "" +
                "Empresa A -> (Financeiro -> (Secretaria), Academico -> (Contas a pagar -> (Contas a receber)))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        assertEquals(6, tree.length());
        assertFalse(tree.isEmpty());
        assertEquals(6, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldInsertNodesInBinarySearchTree() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected =
                "[Empresa A, Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria, Tesouraria]";
        String treeStringExpected =
                "Empresa A -> (Financeiro -> (Contas a pagar -> (Contas a receber -> (Tesouraria))), Academico -> (Secretaria))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(7, tree.length());
        assertFalse(tree.isEmpty());
        assertEquals(7, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldPrintNodesInOrderInTree() {
        Tree<String> tree = new BinarySearchTree<>();
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
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected =
                "[Empresa A, Financeiro, Secretaria, Academico, Contas a pagar, Contas a receber, Tesouraria]";
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
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected =
                "[Secretaria, Financeiro, Tesouraria, Contas a receber, Contas a pagar, Academico, Empresa A]";
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
        Tree<String> tree = new BinarySearchTree<>();
        String expected = "Secretaria";
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
        Tree<String> tree = new BinarySearchTree<>();
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
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertTrue(tree.search("Tesouraria"));
        assertTrue(tree.search("Secretaria"));
        assertTrue(tree.search("Contas a pagar"));
        assertTrue(tree.search("Empresa A"));
        assertTrue(tree.search("Financeiro"));
        assertTrue(tree.search("Academico"));
        assertTrue(tree.search("Contas a receber"));
        assertFalse(tree.search("Administrativo"));
    }

    @Test
    public void notShouldRemoveElementInTree() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected =
                "[Empresa A, Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria, Tesouraria]";
        String treeStringExpected =
                "Empresa A -> (Financeiro -> (Secretaria), Academico -> (Contas a pagar -> (Contas a receber -> (Tesouraria))))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        tree.remove("Administrativo");
        assertTrue(tree.search("Tesouraria"));
        assertTrue(tree.search("Secretaria"));
        assertTrue(tree.search("Contas a pagar"));
        assertTrue(tree.search("Empresa A"));
        assertTrue(tree.search("Financeiro"));
        assertTrue(tree.search("Academico"));
        assertTrue(tree.search("Contas a receber"));
        assertFalse(tree.search("Administrativo"));
        assertEquals(7, tree.length());
        assertFalse(tree.nodes().isEmpty());
        assertEquals(7, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldRemoveElementInTree() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected =
                "[Empresa A, Financeiro, Academico, Contas a pagar, Secretaria, Tesouraria]";
        String treeStringExpected =
                "Empresa A -> (Financeiro -> (Secretaria), Academico -> (Contas a pagar -> (Tesouraria)))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        tree.remove("Contas a receber");
        assertFalse(tree.search("Contas a receber"));
        assertTrue(tree.search("Secretaria"));
        assertTrue(tree.search("Contas a pagar"));
        assertTrue(tree.search("Empresa A"));
        assertTrue(tree.search("Financeiro"));
        assertTrue(tree.search("Academico"));
        assertTrue(tree.search("Tesouraria"));
        assertEquals(6, tree.length());
        assertFalse(tree.nodes().isEmpty());
        assertEquals(6, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldRemoveRootElementInTree() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected =
                "[Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria, Tesouraria]";
        String treeStringExpected =
                "Financeiro -> (Secretaria, Academico -> (Contas a pagar -> (Contas a receber -> (Tesouraria))))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        tree.remove("Empresa A");
        assertTrue(tree.search("Contas a receber"));
        assertTrue(tree.search("Secretaria"));
        assertTrue(tree.search("Contas a pagar"));
        assertFalse(tree.search("Empresa A"));
        assertTrue(tree.search("Financeiro"));
        assertTrue(tree.search("Academico"));
        assertTrue(tree.search("Tesouraria"));
        assertEquals(6, tree.length());
        assertFalse(tree.nodes().isEmpty());
        assertEquals(6, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldRemoveNodeWithTwoElements() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected =
                "[Empresa A, Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria, Teste 2]";
        String treeStringExpected =
                "Empresa A -> (Financeiro -> (Secretaria), Academico -> (Contas a pagar -> (Contas a receber -> (Teste 2))))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        tree.insert("Tesouraria", "Teste 2");
        tree.remove("Tesouraria");
        assertTrue(tree.search("Contas a receber"));
        assertTrue(tree.search("Secretaria"));
        assertTrue(tree.search("Contas a pagar"));
        assertTrue(tree.search("Empresa A"));
        assertTrue(tree.search("Teste 2"));
        assertTrue(tree.search("Financeiro"));
        assertTrue(tree.search("Academico"));
        assertFalse(tree.search("Tesouraria"));
        assertEquals(7, tree.length());
        assertFalse(tree.nodes().isEmpty());
        assertEquals(7, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldRemoveRootBalanced() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected = "[Financeiro, Academico, Contas a pagar, Contas a receber, Secretaria, Tesouraria, Conta 1, Conta 2, Conta receber 2, Arquivo, Arquivo 1, Arquivo 2, Secretaria 1, Secretaria 2]";
        String treeStringExpected = "" +
                "Financeiro -> (Secretaria -> (Secretaria 1 -> (Secretaria 2)), Academico -> (Contas a pagar -> (Contas a receber -> (Tesouraria, Conta receber 2), Conta 1 -> (Conta 2, Arquivo -> (Arquivo 1 -> (Arquivo 2))))))";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Contas a pagar");
        tree.insert("Contas a receber");
        tree.insert("Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        tree.insert("Contas a pagar", "Conta 1");
        tree.insert("Contas a pagar", "Conta 2");
        tree.insert("Contas a receber", "Conta receber 2");
        tree.insert("Arquivo");
        tree.insert("Arquivo", "Arquivo 1");
        tree.insert("Arquivo", "Arquivo 2");
        tree.insert("Secretaria", "Secretaria 1");
        tree.insert("Secretaria", "Secretaria 2");
        tree.remove("Empresa A");
        assertTrue(tree.search("Financeiro"));
        assertTrue(tree.search("Academico"));
        assertTrue(tree.search("Contas a pagar"));
        assertTrue(tree.search("Contas a receber"));
        assertTrue(tree.search("Secretaria"));
        assertTrue(tree.search("Financeiro"));
        assertFalse(tree.search("Empresa A"));
        assertTrue(tree.search("Tesouraria"));
        assertTrue(tree.search("Conta 1"));
        assertTrue(tree.search("Conta 2"));
        assertTrue(tree.search("Conta receber 2"));
        assertTrue(tree.search("Arquivo"));
        assertTrue(tree.search("Arquivo 1"));
        assertTrue(tree.search("Arquivo 2"));
        assertTrue(tree.search("Secretaria 1"));
        assertTrue(tree.search("Secretaria 2"));
        assertEquals(14, tree.length());
        assertFalse(tree.nodes().isEmpty());
        assertEquals(14, tree.nodes().length());
        assertEquals(listStringExpected, tree.nodes().toString());
        assertEquals(listStringExpected, tree.toList().toString());
        assertEquals(treeStringExpected, tree.toString());
    }

    @Test
    public void shouldGetDepthRootElement() {
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(0, tree.depth(tree.root()));
    }

    @Test
    public void shouldGetDepthElementInTree() {
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(2, tree.depth("Contas a pagar"));
    }

    @Test
    public void shouldGetDepthTree() {
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(4, tree.depth());
    }

    @Test
    public void shouldGetHeightRootElement() {
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(4, tree.height(tree.root()));
    }

    @Test
    public void shouldGetHeightElementInTree() {
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(3, tree.height("Financeiro"));
    }

    @Test
    public void shouldGetHeightTree(){
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertEquals(4, tree.height());
    }

    @Test
    public void shouldGetRootElement() {
        Tree<String> tree = new BinarySearchTree<>();
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertTrue(tree.isRoot("Empresa A"));
        assertFalse(tree.isRoot("Academico"));
    }

    @Test
    public void shouldGetParentsElement() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected = "[Contas a receber, Contas a pagar, Financeiro, Empresa A]";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertFalse(tree.parent("Tesouraria").isEmpty());
        assertEquals(listStringExpected, tree.parent("Tesouraria").toString());
    }

    @Test
    public void notShouldGetParentsRootElement() {
        Tree<String> tree = new BinarySearchTree<>();
        String listStringExpected = "[]";
        tree.insert("Empresa A");
        tree.insert("Financeiro");
        tree.insert("Academico");
        tree.insert("Financeiro", "Contas a pagar");
        tree.insert("Financeiro", "Contas a receber");
        tree.insert("Academico", "Secretaria");
        tree.insert("Contas a receber", "Tesouraria");
        assertTrue(tree.parent("Empresa A").isEmpty());
        assertEquals(listStringExpected, tree.parent("Empresa A").toString());
    }
}
