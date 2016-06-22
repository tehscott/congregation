package belief;

import java.util.ArrayList;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class SupernaturalBeing extends Belief {
    public static int GODS = 0;
    public static int ANGELS = 1;
    public static int ALIENS = 2;
    public static int MYTHICAL_CREATURES = 3;
    public static int COSMIC_BEINGS = 4;

    public SupernaturalBeing() {
    }

    public SupernaturalBeing(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.SUPERNATURAL_BEINGS;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Gods";
            case 1:
                return "Angels";
            case 2:
                return "Aliens";
            case 3:
                return "Mythical Creatures";
            case 4:
                return "Cosmic Beings";
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
            beliefs.add(new SupernaturalBeing(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 5;
    }
}