package com.fredson.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoublyNodeTest {

    @Test
    public void createDoublyNodeWith2Nodes() {
        Node nodeFist = new Node("Content node 1");
        Node nodeSecond = new Node("Content node 2");
        DoublyNode nodeIntermediary = new DoublyNode("Content node 3", nodeFist, nodeSecond);
        assertEquals(nodeIntermediary.getPrevNode(), nodeFist);
        assertEquals(nodeIntermediary.getNextNode(), nodeSecond);
    }

    @Test
    public void createDoublyNodeWith1Node() {
        DoublyNode node = new DoublyNode("Content node");
        assertNull(node.getPrevNode());
        assertNull(node.getPrevNode());
    }
}
