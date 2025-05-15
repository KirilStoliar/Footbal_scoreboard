package com.stoliar;

class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final long startTime;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = System.nanoTime();
    }

    public void setScore(int home, int away) {
        if (home < 0 || away < 0) {
            throw new IllegalArgumentException("Scores cannot be negative.");
        }
        this.homeScore = home;
        this.awayScore = away;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public String toString() {
        return homeTeam + " " + homeScore + " – " + awayTeam + " " + awayScore;
    }
} 
