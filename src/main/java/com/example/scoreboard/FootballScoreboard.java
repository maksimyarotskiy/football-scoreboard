package com.example.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class FootballScoreboard {
    private final List<Game> games = new ArrayList<>();

    public void startGame(String homeTeam, String awayTeam) {
        games.add(new Game(homeTeam, awayTeam));
    }

    public void finishGame(String homeTeam, String awayTeam) {
        games.removeIf(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Game game : games) {
            if (game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam)) {
                game.setScore(homeScore, awayScore);
                return;
            }
        }
        throw new IllegalArgumentException("Game not found.");
    }

    public List<Game> getSummary() {
        List<Game> sortedGames = new ArrayList<>(games);
        sortedGames.sort((g1, g2) -> {
            int totalScore1 = g1.getHomeScore() + g1.getAwayScore();
            int totalScore2 = g2.getHomeScore() + g2.getAwayScore();
            if (totalScore1 != totalScore2) {
                return Integer.compare(totalScore2, totalScore1); // по убыванию
            }
            return Integer.compare(games.indexOf(g2), games.indexOf(g1)); // более новые выше
        });
        return sortedGames;
    }


    public List<Game> getGames() {
        return new ArrayList<>(games); // сделал копию, так как так безопаснее
    }
}