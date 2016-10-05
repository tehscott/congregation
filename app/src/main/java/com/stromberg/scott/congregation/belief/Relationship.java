package com.stromberg.scott.congregation.belief;

import java.util.ArrayList;

import com.stromberg.scott.congregation.util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Relationship extends Belief {
    public static int MONOGOMY = 0;
    public static int POLYGOMY = 1;
    public static int POLYANDRY = 2;
    public static int BIGAMY = 3;
    public static int POLYAMORY = 4;

    public Relationship() {
    }

    public Relationship(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.RELATIONSHIPS;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Monogomy";
            case 1:
                return "Polygomy";
            case 2:
                return "Polyandry";
            case 3:
                return "Bigamy";
            case 4:
                return "Polyamory";
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
    public ArrayList<Belief> generateBeliefs() {
        ArrayList<Belief> beliefs = new ArrayList<>();

        for(int i = 0; i < getMaxNumberOfBeliefs(); i++) {
            beliefs.add(new Relationship(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 5;
    }
}