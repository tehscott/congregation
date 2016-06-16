package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Sexuality extends Belief {
    SexualityType mSexualityType;
    float mLevel;

    public Sexuality(SexualityType sexualityType, float level, boolean isMajorBelief) {
        this.mSexualityType = sexualityType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.SEXUALITY;
    }

    @Override
    public String getName() {
        return mSexualityType.getAsString();
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