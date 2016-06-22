package personattribute;

/**
 * Created by SStrombe on 6/7/16.
 */

public class MaritalStatus extends PersonAttribute {
    public static int SINGLE = 0;
    public static int MARRIED = 1;
    public static int IN_RELATIONSHIP = 2;

    public MaritalStatus(int type) {
        mType = type;
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public int getTypeCount() {
        return 3;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Single";
            case 1:
                return "Married";
            case 2:
                return "In a relationship";
        }
        return null;
    }

    public static MaritalStatus generateMaritalStatus() {
        float single = getProbability(SINGLE);
        float married = single + getProbability(MARRIED);
        float inRelationship = married + getProbability(IN_RELATIONSHIP);

        double random = Math.random();

        if(random <= single) {
            return new MaritalStatus(SINGLE);
        } else if(random > single && random <= married) {
            return new MaritalStatus(MARRIED);
        }

        return new MaritalStatus(IN_RELATIONSHIP);
    }

    // TODO : base more on stats
    private static float getProbability(int type) {
        switch (type) {
            case 0:
                return .21f;
            case 1:
                return .53f;
            case 2:
                return .26f;
        }

        return -1;
    }
}
