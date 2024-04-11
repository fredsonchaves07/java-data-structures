package com.fredson.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeTest {

    @Test
    public void createNode() {
        Node nodeFist = new Node("Content node 1");
        Node nodeSecond = new Node("Content node 2");
        nodeFist.setNextNode(nodeSecond);
        Node nodeThird = new Node("Content node 3");
        nodeSecond.setNextNode(nodeThird);
        assertEquals(nodeFist.getNextNode(), nodeSecond);
        assertEquals(nodeSecond.getNextNode(), nodeThird);
        assertNull(nodeThird.getNextNode());
    }
}
