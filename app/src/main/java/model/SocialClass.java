package model;

import util.Util;

public enum SocialClass {
    LOWER(0),
    WORKING(1),
    MIDDLE(2),
    UPPER(3),
    ELITE(4),
    SUPER_ELITE(5);

    private int mSocialClass;

    SocialClass(int socialClass) {
        mSocialClass = socialClass;
    }

    public int getAsInt() {
        return mSocialClass;
    }

    public static SocialClass getFromInt(int socialClass) {

        switch (socialClass) {
            case 0:
                return LOWER;
            case 1:
                return WORKING;
            case 2:
                return MIDDLE;
            case 3:
                return UPPER;
            case 4:
                return ELITE;
            case 5:
                return SUPER_ELITE;
        }
        return null;
    }

    public String getAsString() {
        switch (mSocialClass) {
            case 0:
                return "Lower Class";
            case 1:
                return "Working Class";
            case 2:
                return "Middle Class";
            case 3:
                return "Upper Class";
            case 4:
                return "Elite";
            case 5:
                return "Super Elite";
        }
        return null;
    }

    // TODO make this based on more stats?
    public static SocialClass generateSocialClass() {
        float lower = LOWER.getProbability();
        float working = lower + WORKING.getProbability();
        float middle = working + MIDDLE.getProbability();
        float upper = middle + UPPER.getProbability();
        float elite = upper + ELITE.getProbability();
        float superElite = elite + SUPER_ELITE.getProbability();

        double random = Util.generateRandomFloatInRange(0, superElite);

        if(random <= lower) {
            return LOWER;
        } else if(random > lower && random <= working) {
            return WORKING;
        } else if(random > working && random <= middle) {
            return MIDDLE;
        } else if(random > middle && random <= upper) {
            return UPPER;
        } else if(random > upper && random <= elite) {
            return ELITE;
        }

        return SUPER_ELITE;
    }

    public float getProbability() {
        switch (mSocialClass) {
            case 0:
                return .188f;
            case 1:
                return .254f;
            case 2:
                return .247f;
            case 3:
                return .284f;
            case 4:
                return .024f;
            case 5:
                return .0005f;
        }

        return -1;
    }
}
