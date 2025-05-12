package com.example.scoreboard;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballScoreboardTest {

    @Test
    void testStartGameAddsMatchToScoreboard() {
        FootballScoreboard scoreboard = new FootballScoreboard();
        scoreboard.startGame("Mexico", "Canada");

        assertEquals(1, scoreboard.getGames().size());
        Game match = scoreboard.getGames().get(0);
        assertEquals("Mexico", match.getHomeTeam());
        assertEquals("Canada", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void testFinishGameRemovesMatchFromScoreboard() {
        FootballScoreboard scoreboard = new FootballScoreboard();
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.startGame("Spain", "Brazil");

        assertEquals(2, scoreboard.getGames().size());

        scoreboard.finishGame("Mexico", "Canada");

        assertEquals(1, scoreboard.getGames().size());
        Game remaining = scoreboard.getGames().get(0);
        assertEquals("Spain", remaining.getHomeTeam());
        assertEquals("Brazil", remaining.getAwayTeam());
    }

    @Test
    void testUpdateScoreChangesTheGameScore() {
        FootballScoreboard scoreboard = new FootballScoreboard();
        scoreboard.startGame("Mexico", "Canada");

        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        Game match = scoreboard.getGames().get(0);
        assertEquals(0, match.getHomeScore());
        assertEquals(5, match.getAwayScore());
    }

    @Test
    void testGetSummaryOrdersGamesCorrectly() {
        FootballScoreboard scoreboard = new FootballScoreboard();
        scoreboard.startGame("Mexico", "Canada");     // 0-5
        scoreboard.startGame("Spain", "Brazil");      // 10-2
        scoreboard.startGame("Germany", "France");    // 2-2
        scoreboard.startGame("Uruguay", "Italy");     // 6-6
        scoreboard.startGame("Argentina", "Australia"); // 3-1

        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.updateScore("Germany", "France", 2, 2);
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        List<Game> summary = scoreboard.getSummary();

        assertEquals("Uruguay 6 – Italy 6", summary.get(0).toString());
        assertEquals("Spain 10 – Brazil 2", summary.get(1).toString());
        assertEquals("Mexico 0 – Canada 5", summary.get(2).toString());
        assertEquals("Argentina 3 – Australia 1", summary.get(3).toString());
        assertEquals("Germany 2 – France 2", summary.get(4).toString());
    }
}