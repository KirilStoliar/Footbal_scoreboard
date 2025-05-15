package com.stoliar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Для примера работы программы выведем следующие матчи в сортированном виде:\n" +
                "Mexico - Canada: 0 – 5\n" +
                "Spain - Brazil: 10 – 2\n" +
                "Germany - France: 2 – 2\n" +
                "Uruguay - Italy: 6 – 6\n" +
                "Argentina - Australia: 3 – 1");
        System.out.println("------------------------");
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        scoreboard.startGame("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.startGame("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);
        scoreboard.startGame("Uruguay", "Italy");
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);
        scoreboard.startGame("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", 3, 1);
        List<Match> match = scoreboard.getSummary();
        for (Match m : match) {
            System.out.println(m);
        }
    }
}