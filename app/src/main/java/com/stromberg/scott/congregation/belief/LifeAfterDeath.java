package com.stromberg.scott.congregation.belief;

import java.util.ArrayList;

import com.stromberg.scott.congregation.util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class LifeAfterDeath extends Belief {
    public static int HEAVEN = 0;
    public static int HELL = 1;
    public static int RESURRECTION = 2;
    public static int REINCARNATION = 3;
    public static int RAPTURE = 4;

    public LifeAfterDeath() {
    }

    public LifeAfterDeath(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.LIFE_AFTER_DEATH;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Heaven";
            case 1:
                return "Hell";
            case 2:
                return "Resurrection";
            case 3:
                return "Reincarnation";
            case 4:
                return "Rapture";
        }
        return null;
    }

    @Override
    public float getLevel() {
        return mLevel;
    }

    @Override
    public void init() {
        mLevel = Util.generateRandomFloatInRange(0f, 100f);
    }

    @Override
    public ArrayList<Belief> generateBeliefs()  {
        ArrayList<Belief> beliefs = new ArrayList<>();

        for(int i = 0; i < getMaxNumberOfBeliefs(); i++) {
            beliefs.add(new LifeAfterDeath(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 5;
    }
}