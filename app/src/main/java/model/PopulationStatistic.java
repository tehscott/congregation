package model;

public class PopulationStatistic {
    public String mName;
    public int mCount;
    public float mLevel;
    public float mAverage;

    public PopulationStatistic(String name, int count, float level, float average) {
        this.mName = name;
        this.mCount = count;
        this.mLevel = level;
        this.mAverage = average;
    }

    public void add(float level) {
        mCount++;
        mLevel += level;

        mAverage = mLevel / mCount;
    }
}
