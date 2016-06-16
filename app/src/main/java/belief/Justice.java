package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Justice extends Belief {
    JusticeType mkarmaType;
    float mLevel;

    public Justice(JusticeType justiceType, float level, boolean isMajorBelief) {
        this.mkarmaType = justiceType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.JUSTICE;
    }

    @Override
    public String getName() {
        return mkarmaType.getAsString();
    }

    @Override
    public float getLevel() {
        return mLevel;
    }

    @Override
    public void init(boolean isMajorBelief) {
        if(isMajorBelief) {
            mLevel = Util.generateRandomFloatInRange(15, 100);
        } else {
            double random = Math.random();

            if(random > 0.5f) {
                mLevel = Util.generateRandomFloatInRange(0, 0.15f);
            }
        }
    }
}