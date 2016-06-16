package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Worship extends Belief {
    WorshipType mWorshipType;
    float mLevel;

    public Worship(WorshipType worshipType, float level, boolean isMajorBelief) {
        this.mWorshipType = worshipType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.WORSHIP;
    }

    @Override
    public String getName() {
        return mWorshipType.getAsString();
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