package com.fredson.algorithms;

import org.junit.Test;

import static com.fredson.algorithms.TowerOfHanoi.towerOfHanoi;
import static org.junit.Assert.assertNotNull;

public class TowerOfHanoiTest {

    @Test
    public void shouldExecuteTowerOfHanoiAlgorithm() {
        int[] discs = {10, 3, 8, 1, 20, 15, 100, 20, 10, 50, 60, 80};
        assertNotNull(towerOfHanoi(discs));
        System.out.println(towerOfHanoi(discs));
    }
}
