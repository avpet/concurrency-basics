package com.oleksiipetinov.javatests.dining_philosophers.solution1;

public class Configuration {
    public int maxEatingTime = 1000;
    public int maxThinkingTime = 800;
    public int numberOfRounds = 10;

    public Configuration(int maxEatingTime, int maxThinkingTime, int numberOfRounds) {
        this.maxEatingTime = maxEatingTime;
        this.maxThinkingTime = maxThinkingTime;
        this.numberOfRounds = numberOfRounds;
    }
}
