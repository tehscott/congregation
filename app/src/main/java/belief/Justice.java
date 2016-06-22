package belief;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Justice extends Belief {
    public static int KARMA = 0;
    public static int REDEMPTION = 1;
    public static int FORGIVENESS = 2;
    public static int REVENGE = 3;

    public Justice() {}

    public Justice(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.JUSTICE;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Karma";
            case 1:
                return "Redemption";
            case 2:
                return "Forgiveness";
            case 3:
                return "Revenge";
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
            beliefs.add(new Justice(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 4;
    }
}