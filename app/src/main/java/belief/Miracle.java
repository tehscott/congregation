package belief;

import java.util.ArrayList;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Miracle extends Belief {
    public static int HEALING = 0;
    public static int RESURRECTION = 1;
    public static int REANIMATION = 2;

    public Miracle() {
    }

    public Miracle(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.MIRACLES;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Healing";
            case 1:
                return "Resurrection";
            case 2:
                return "Reanimation";
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
            beliefs.add(new Miracle(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 3;
    }
}