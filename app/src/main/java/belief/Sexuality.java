package belief;

import java.util.ArrayList;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Sexuality extends Belief {
    public static int ASEXUAL = 0;
    public static int BISEXUAL = 1;
    public static int HETEROSEXUAL = 2;
    public static int HOMOSEXUAL = 3;
    public static int PANSEXUAL = 4;

    public Sexuality() {
    }

    public Sexuality(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.SEXUALITY;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Asexuality";
            case 1:
                return "Bisexuality";
            case 2:
                return "Heterosexuality";
            case 3:
                return "Homosexuality";
            case 4:
                return "Pansexuality";
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
            beliefs.add(new Sexuality(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 5;
    }
}