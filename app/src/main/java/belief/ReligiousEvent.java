package belief;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class ReligiousEvent extends Belief {
    ReligiousEventType mReligiousEventType;
    float mLevel;

    public ReligiousEvent(ReligiousEventType religiousEventType, float level, boolean isMajorBelief) {
        this.mReligiousEventType = religiousEventType;
        this.mLevel = level;

        init(isMajorBelief);
    }

    public static BeliefCategory getBeliefCategory() {
        return BeliefCategory.RELIGIOUS_EVENTS;
    }

    @Override
    public String getName() {
        return mReligiousEventType.getAsString();
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