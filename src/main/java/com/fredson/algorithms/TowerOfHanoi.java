package com.fredson.algorithms;

import java.util.Arrays;

import com.fredson.datastructures.Stack;

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
        Stack<Integer> pillar1 = new Stack<>();
        Stack<Integer> pillar2 = new Stack<>();
        Stack<Integer> pillar3 = new Stack<>();
        Arrays.sort(discsVector);
        for (int disc: discsVector){
            pillar1.push(disc);
        }
        execute(numberOfDiscs, pillar1, pillar3, pillar2);
        return "pillar1: " + pillar1 + "\npillar2: " + pillar2 + "\npillar3: " + pillar3;
    }
}
