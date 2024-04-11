package com.fredson.applications;

import com.fredson.applications.storyGameEntries.GameEntry;
import com.fredson.applications.storyGameEntries.ScoreBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameEntryTest {

    @Test
    public void shouldAddGameEntry() {
        GameEntry gameEntryJoao = new GameEntry("Joao", 100);
        GameEntry gameEntryMaria = new GameEntry("Maria", 500);
        GameEntry gameEntryCarlos = new GameEntry("Carlos", 0);
        GameEntry gameEntryAlice = new GameEntry("Alice", 30);
        ScoreBoard scoreboard = new ScoreBoard(4);
        scoreboard.add(gameEntryJoao);
        scoreboard.add(gameEntryMaria);
        scoreboard.add(gameEntryCarlos);
        scoreboard.add(gameEntryAlice);
        assertTrue(true);
    }

    @Test
    public void shouldGetGameEntry() {
        GameEntry gameEntryJoao = new GameEntry("Joao", 100);
        GameEntry gameEntryMaria = new GameEntry("Maria", 500);
        GameEntry gameEntryCarlos = new GameEntry("Carlos", 0);
        GameEntry gameEntryAlice = new GameEntry("Alice", 30);
        ScoreBoard scoreboard = new ScoreBoard(4);
        scoreboard.add(gameEntryJoao);
        scoreboard.add(gameEntryMaria);
        scoreboard.add(gameEntryCarlos);
        scoreboard.add(gameEntryAlice);
        assertEquals(gameEntryJoao, scoreboard.get(0));
        assertEquals(gameEntryMaria, scoreboard.get(1));
        assertEquals(gameEntryCarlos, scoreboard.get(2));
        assertEquals(gameEntryAlice, scoreboard.get(3));
    }

    @Test
    public void shouldRemoveGameEntry() {
        GameEntry gameEntryJoao = new GameEntry("Joao", 100);
        GameEntry gameEntryMaria = new GameEntry("Maria", 500);
        GameEntry gameEntryCarlos = new GameEntry("Carlos", 0);
        GameEntry gameEntryAlice = new GameEntry("Alice", 30);
        ScoreBoard scoreboard = new ScoreBoard(4);
        scoreboard.add(gameEntryJoao);
        scoreboard.add(gameEntryMaria);
        scoreboard.add(gameEntryCarlos);
        scoreboard.add(gameEntryAlice);
        scoreboard.remove(3);
        assertEquals(3, scoreboard.size());
    }

    @Test
    public void shouldGetScoreBoardSize() {
        GameEntry gameEntryJoao = new GameEntry("Joao", 100);
        GameEntry gameEntryMaria = new GameEntry("Maria", 500);
        GameEntry gameEntryCarlos = new GameEntry("Carlos", 0);
        GameEntry gameEntryAlice = new GameEntry("Alice", 30);
        ScoreBoard scoreboard = new ScoreBoard(4);
        scoreboard.add(gameEntryJoao);
        scoreboard.add(gameEntryMaria);
        scoreboard.add(gameEntryCarlos);
        scoreboard.add(gameEntryAlice);
        assertEquals(4, scoreboard.size());
    }

    @Test
    public void getScoreBoardSortedByScore() {
        String scoreExpected = "[(Carlos ,0), (Alice ,30), (Joao ,100), (Maria ,500)]";
        GameEntry gameEntryJoao = new GameEntry("Joao", 100);
        GameEntry gameEntryMaria = new GameEntry("Maria", 500);
        GameEntry gameEntryCarlos = new GameEntry("Carlos", 0);
        GameEntry gameEntryAlice = new GameEntry("Alice", 30);
        ScoreBoard scoreboard = new ScoreBoard(4);
        scoreboard.add(gameEntryJoao);
        scoreboard.add(gameEntryMaria);
        scoreboard.add(gameEntryCarlos);
        scoreboard.add(gameEntryAlice);
        scoreboard.sort();
        assertEquals(scoreExpected, scoreboard.toString());
    }
}
