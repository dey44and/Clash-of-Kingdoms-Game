package Game.Database;

public class SessionInfo {
    private final String name;
    private int currLevel;
    private int timePlayed;
    private int bestScore;
    private int totalScore;
    public SessionInfo(String name, int currLevel, int timePlayed, int bestScore, int totalScore) {
        this.name = name;
        this.currLevel = currLevel;
        this.timePlayed = timePlayed;
        this.bestScore = bestScore;
        this.totalScore = totalScore;
    }
    public String getName() {
        return this.name;
    }
    public int getLevel() {
        return this.currLevel;
    }
    public int getTimePlayed() {
        return this.timePlayed;
    }
    public int getBestScore() {
        return this.bestScore;
    }
    public int getTotalScore() {
        return this.totalScore;
    }
    public void updateLevel(int level) {
        this.currLevel = level;
    }
    public void updateTime(int time) {
        this.timePlayed = time;
    }
    public void updateBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
    public void updateTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
