
package org.example;

public class Player {
    private String name;
    private int homeBestCount;
    private int awayBestCount;

    public Player(String name) {
        this.name = name;
        this.homeBestCount = 0;
        this.awayBestCount = 0;
    }

    public String getName() {
        return name;
    }

    public void incrementHomeBestCount() {
        homeBestCount++;
    }

    public void incrementAwayBestCount() {
        awayBestCount++;
    }

    public int getHomeBestCount() {
        return homeBestCount;
    }

    public int getAwayBestCount() {
        return awayBestCount;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", homeBestCount=" + homeBestCount +
                ", awayBestCount=" + awayBestCount +
                '}';
    }
}
