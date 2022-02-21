package com.fredson.algorithms;

import java.util.Arrays;

import com.fredson.datastructures.Stack;

public class TowerOfHanoi {

    public static void execute(int numberOfDiscs, Stack<Integer> pillarSource, Stack<Integer> pillarDest, Stack<Integer> pillarAux){
        if(numberOfDiscs == 1){
            pillarDest.push(pillarSource.pop());
        } else {
            execute(numberOfDiscs - 1, pillarSource, pillarAux, pillarDest);
            pillarDest.push(pillarSource.pop());
            execute(numberOfDiscs - 1, pillarAux, pillarDest, pillarSource);
        }
    }
    
    public static String towerOfHanoi(int[] discsVector){
        int[] discs = discsVector;
        int numberOfDiscs;
        Stack<Integer> pillar1 = new Stack<>();
        Stack<Integer> pillar2 = new Stack<>();
        Stack<Integer> pillar3 = new Stack<>();

        Arrays.sort(discs);

        numberOfDiscs = discs.length;

        for(int disc: discs){
            pillar1.push(disc);
        }

        execute(numberOfDiscs, pillar1, pillar3, pillar2);

        return "pillar1: " + pillar1 + "\npillar2: " + pillar2 + "\npillar3: " + pillar3;
    }

    public static void main(String[] args) {
        int[] discs = {10, 3, 8, 1, 20, 15, 100, 20, 10, 50, 60, 80};
        System.out.println(towerOfHanoi(discs));
    }
}
