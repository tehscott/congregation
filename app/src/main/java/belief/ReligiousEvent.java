package belief;

import java.util.ArrayList;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class ReligiousEvent extends Belief {
    public static int RAPTURE = 0;
    public static int END_OF_TIMES = 1;
    public static int ENLIGHTENMENT = 2;

    public ReligiousEvent() {
    }

    public ReligiousEvent(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.RELIGIOUS_EVENTS;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Rapture";
            case 1:
                return "End Of Times";
            case 2:
                return "Enlightenment";
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
            beliefs.add(new ReligiousEvent(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 3;
    }
}