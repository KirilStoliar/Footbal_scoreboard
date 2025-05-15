package com.stoliar;

import java.util.*;

public class Scoreboard {
    private final Map<String, Match> matches = new LinkedHashMap<>();

    public void startGame(String homeTeam, String awayTeam) {
        validateTeamNames(homeTeam, awayTeam);
        String key = getMatchKey(homeTeam, awayTeam);
        if (matches.containsKey(key)) {
            throw new IllegalArgumentException("Match already started.");
        }
        matches.put(key, new Match(homeTeam, awayTeam));
    }

    public void finishGame(String homeTeam, String awayTeam) {
        String key = getMatchKey(homeTeam, awayTeam);
        if (!matches.containsKey(key)) {
            throw new IllegalArgumentException("Match not found.");
        }
        matches.remove(key);
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        String key = getMatchKey(homeTeam, awayTeam);
        Match match = matches.get(key);
        if (match == null) {
            throw new IllegalArgumentException("Match not found.");
        }
        match.setScore(homeScore, awayScore);
    }

    public List<Match> getSummary() {
        List<Match> summary = new ArrayList<>(matches.values());
        summary.sort((m1, m2) -> {
            int total1 = m1.getTotalScore();
            int total2 = m2.getTotalScore();
            if (total1 != total2) return Integer.compare(total2, total1);
            return Long.compare(m2.getStartTime(), m1.getStartTime());
        });
        return summary;
    }

    private void validateTeamNames(String home, String away) {
        if (home == null || away == null || home.isBlank() || away.isBlank()) {
            throw new IllegalArgumentException("Team names cannot be null or empty.");
        }
        if (home.equalsIgnoreCase(away)) {
            throw new IllegalArgumentException("Teams must be different.");
        }
    }

    private String getMatchKey(String home, String away) {
        return home.trim().toLowerCase() + ":" + away.trim().toLowerCase();
    }
} 