package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Miracle extends Belief {
    MiracleType mMiracleType;
    float mLevel;

    public Miracle(MiracleType miracleType, float level, boolean isMajorBelief) {
        this.mMiracleType = miracleType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.MIRACLES;
    }

    @Override
    public String getName() {
        return mMiracleType.getAsString();
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