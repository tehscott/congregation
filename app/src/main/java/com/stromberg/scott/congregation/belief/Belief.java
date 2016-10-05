package com.stromberg.scott.congregation.belief;

import java.util.ArrayList;

public abstract class Belief {
    public int mType;
    public float mLevel;

    public abstract String getName();
    public abstract float getLevel();
    public abstract void init();
    public abstract ArrayList<Belief> generateBeliefs();
    public abstract int getMaxNumberOfBeliefs();
    public abstract BeliefCategory getBeliefCategory();
}
