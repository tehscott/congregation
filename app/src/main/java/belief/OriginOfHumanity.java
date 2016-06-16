package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class OriginOfHumanity extends Belief {
    OriginOfHumanityType mOriginOfHumanityType;
    float mLevel;

    public OriginOfHumanity(OriginOfHumanityType originOfHumanityType, float level, boolean isMajorBelief) {
        this.mOriginOfHumanityType = originOfHumanityType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.ORIGIN_OF_HUMANITY;
    }

    @Override
    public String getName() {
        return mOriginOfHumanityType.getAsString();
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