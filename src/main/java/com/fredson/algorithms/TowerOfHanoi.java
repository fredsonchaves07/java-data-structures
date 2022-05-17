package com.fredson.algorithms;

import com.fredson.datastructures.ArrayStack;
import com.fredson.datastructures.Stack;

import java.util.Arrays;

public class TowerOfHanoi {

    private static void execute(int numberOfDiscs, Stack<Integer> pillarSource, Stack<Integer> pillarDest, Stack<Integer> pillarAux){
        if (numberOfDiscs == 1){
            pillarDest.push(pillarSource.pop());
        } else {
            execute(numberOfDiscs - 1, pillarSource, pillarAux, pillarDest);
            pillarDest.push(pillarSource.pop());
            execute(numberOfDiscs - 1, pillarAux, pillarDest, pillarSource);
        }
    }
    
    public static String towerOfHanoi(int[] discsVector){
        int numberOfDiscs = discsVector.length;
        Stack<Integer> pillar1 = new ArrayStack<>();
        Stack<Integer> pillar2 = new ArrayStack<>();
        Stack<Integer> pillar3 = new ArrayStack<>();
        Arrays.sort(discsVector);
        for (int disc: discsVector){
            pillar1.push(disc);
        }
        execute(numberOfDiscs, pillar1, pillar3, pillar2);
        return "pillar1: " + pillar1 + "\npillar2: " + pillar2 + "\npillar3: " + pillar3;
    }
}
