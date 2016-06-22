package personattribute;

import util.Util;

public class SocialClass extends PersonAttribute {
    public static int LOWER = 0;
    public static int WORKING = 1;
    public static int MIDDLE = 2;
    public static int UPPER = 3;
    public static int ELITE = 4;
    public static int SUPER_ELITE = 5;

    private int mType;

    public SocialClass(int type) {
        mType = type;
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public int getTypeCount() {
        return 6;
    }

    @Override
    public String getName() {
        switch (mType) {
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
        float lower = getProbability(LOWER);
        float working = lower + getProbability(WORKING);
        float middle = working + getProbability(MIDDLE);
        float upper = middle + getProbability(UPPER);
        float elite = upper + getProbability(ELITE);
        float superElite = elite + getProbability(SUPER_ELITE);

        double random = Util.generateRandomFloatInRange(0, superElite);

        if(random <= lower) {
            return new SocialClass(LOWER);
        } else if(random > lower && random <= working) {
            return new SocialClass(WORKING);
        } else if(random > working && random <= middle) {
            return new SocialClass(MIDDLE);
        } else if(random > middle && random <= upper) {
            return new SocialClass(UPPER);
        } else if(random > upper && random <= elite) {
            return new SocialClass(ELITE);
        }

        return new SocialClass(SUPER_ELITE);
    }

    private static float getProbability(int type) {
        switch (type) {
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
