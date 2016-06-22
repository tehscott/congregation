package belief;

import java.util.ArrayList;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Theism extends Belief {
    // http://en.wikipedia.org/wiki/Theism
    public static int MONOTHEISM = 0;
    public static int POLYTHEISM = 1;
    public static int HENOTHEISM = 2;
    public static int KATHENOTHEISM = 3;
    public static int MONOLATRISM = 4;
    public static int PANTHEISM = 5;
    public static int PANENTHEISM = 6;
    public static int PANDEISM = 7;
    public static int PANENDEISM = 8;
    public static int POLYDEISM = 9;
    public static int AUTOTHEISM = 10;
    public static int EUTHEISM = 11;
    public static int DYSTHEISM = 12;
    public static int MISOTHEISM = 13;
    public static int ATHEISM = 14;

    public Theism() {
    }

    public Theism(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.THEISM;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Monotheism";
            case 1:
                return "Polytheism";
            case 2:
                return "Henotheism";
            case 3:
                return "Kathenotheism";
            case 4:
                return "Monolatrism";
            case 5:
                return "Pantheism";
            case 6:
                return "Panentheism";
            case 7:
                return "Pandeism";
            case 8:
                return "Panendeism";
            case 9:
                return "Polydeism";
            case 10:
                return "Autotheism";
            case 11:
                return "Eutheism";
            case 12:
                return "Dystheism";
            case 13:
                return "Misotheism";
            case 14:
                return "Atheism";
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
            beliefs.add(new Theism(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 15;
    }
}