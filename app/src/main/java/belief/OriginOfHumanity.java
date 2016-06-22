package belief;

import java.util.ArrayList;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class OriginOfHumanity extends Belief {
    public static int CREATION_FROM_ELEMENTS = 0;
    public static int CREATION_BY_SUPREME_BEING = 1;
    public static int CREATION_FROM_SPIRITS = 2;
    public static int CREATION_BY_SUPERNATURAL = 3;
    public static int CREATION_FROM_ANIMALS = 4;
    public static int EVOLVE_FROM_MONKEYS = 5;
    public static int EVOLVE_FROM_SNAKES = 6;
    public static int EVOLVE_FROM_ALIENS = 7;
    public static int ETHEREAL = 8;
    public static int OTHER_WORLDS = 9;
    public static int DESCENDED_FROM_GODS = 10;
    public static int ALIENS = 11;

    public OriginOfHumanity() {
    }

    public OriginOfHumanity(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.ORIGIN_OF_HUMANITY;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Creation From Elements";
            case 1:
                return "Creation By Supreme Being";
            case 2:
                return "Creation From Spirits";
            case 3:
                return "Creation By Supernatural";
            case 4:
                return "Creation From Animals";
            case 5:
                return "Evolve From Monkeys";
            case 6:
                return "Evolve From Snakes";
            case 7:
                return "Evolve From Aliens";
            case 8:
                return "Ethereal";
            case 9:
                return "Other Worlds";
            case 10:
                return "Descended From Gods";
            case 11:
                return "Aliens";
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
            beliefs.add(new OriginOfHumanity(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 1;
    }
}