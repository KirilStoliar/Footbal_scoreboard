package com.stoliar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    void testStartGameAndSummary() {
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.startGame("Spain", "Brazil");
        List<Match> summary = scoreboard.getSummary();
        assertEquals(2, summary.size());
    }

    @Test
    void testStartDuplicateGameThrows() {
        scoreboard.startGame("Mexico", "Canada");
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame("Mexico", "Canada"));
    }

    @Test
    void testFinishGameRemovesMatch() {
        scoreboard.startGame("Germany", "France");
        scoreboard.finishGame("Germany", "France");
        List<Match> summary = scoreboard.getSummary();
        assertTrue(summary.isEmpty());
    }

    @Test
    void testUpdateScoreUpdatesCorrectly() {
        scoreboard.startGame("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", 3, 1);
        Match match = scoreboard.getSummary().get(0);
        assertEquals("Argentina 3 – Australia 1", match.toString());
    }

    @Test
    void testSummaryOrdering() throws InterruptedException {
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);

        Thread.sleep(10); // ensure different timestamps
        scoreboard.startGame("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 10, 2);

        Thread.sleep(10);
        scoreboard.startGame("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);

        Thread.sleep(10);
        scoreboard.startGame("Uruguay", "Italy");
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);

        Thread.sleep(10);
        scoreboard.startGame("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        List<Match> summary = scoreboard.getSummary();
        assertEquals("Uruguay 6 – Italy 6", summary.get(0).toString());
        assertEquals("Spain 10 – Brazil 2", summary.get(1).toString());
        assertEquals("Mexico 0 – Canada 5", summary.get(2).toString());
        assertEquals("Argentina 3 – Australia 1", summary.get(3).toString());
        assertEquals("Germany 2 – France 2", summary.get(4).toString());
    }

    @Test
    void testInvalidTeamNames() {
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame("", "Canada"));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame("Spain", "Spain"));
    }

    @Test
    void testNegativeScoresThrow() {
        scoreboard.startGame("Spain", "Brazil");
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Spain", "Brazil", -1, 0));
    }
}