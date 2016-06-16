package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class LifeAfterDeath extends Belief {
    LifeAfterDeathType mLifeAfterDeath;
    float mLevel;

    public LifeAfterDeath(LifeAfterDeathType lifeAfterDeathType, float level, boolean isMajorBelief) {
        this.mLifeAfterDeath = lifeAfterDeathType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.LIFE_AFTER_DEATH;
    }

    @Override
    public String getName() {
        return mLifeAfterDeath.getAsString();
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