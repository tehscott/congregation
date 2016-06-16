package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class SupernaturalBeing extends Belief {
    SupernaturalBeingType mSupernaturalBeingType;
    float mLevel;

    public SupernaturalBeing(SupernaturalBeingType supernaturalBeingType, float level, boolean isMajorBelief) {
        this.mSupernaturalBeingType = supernaturalBeingType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.SUPERNATURAL_BEINGS;
    }

    @Override
    public String getName() {
        return mSupernaturalBeingType.getAsString();
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