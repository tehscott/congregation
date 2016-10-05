package com.stromberg.scott.congregation.belief;

import java.util.ArrayList;

import com.stromberg.scott.congregation.util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Mystics extends Belief {
    public static int MAGIC = 0;
    public static int WITCHCRAFT = 1;
    public static int VOODOO = 2;
    public static int SORCERY = 3;
    public static int TIME_TRAVEL = 4;

    public Mystics() {
    }

    public Mystics(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.MYSTICS;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Magic";
            case 1:
                return "Witchcraft";
            case 2:
                return "Voodoo";
            case 3:
                return "Sorcery";
            case 4:
                return "Time Travel";
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
            beliefs.add(new Mystics(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 5;
    }
}