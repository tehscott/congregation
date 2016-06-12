package model;

/**
 * Created by SStrombe on 6/7/16.
 */

public enum MaritalStatus {
    SINGLE(0),
    MARRIED(1),
    IN_RELATIONSHIP(2);

    private int mMaritalStatus;

    MaritalStatus(int maritalStatus) {
        mMaritalStatus = maritalStatus;
    }

    public int getAsInt() {
        return mMaritalStatus;
    }

    public static MaritalStatus getFromInt(int maritalStatus) {

        switch (maritalStatus) {
            case 0:
                return SINGLE;
            case 1:
                return MARRIED;
            case 2:
                return IN_RELATIONSHIP;
        }
        return null;
    }

    public String getAsString() {
        switch (mMaritalStatus) {
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
        float single = SINGLE.getProbability();
        float married = single + MARRIED.getProbability();
        float inRelationship = married + IN_RELATIONSHIP.getProbability();

        double random = Math.random();

        if(random <= single) {
            return SINGLE;
        } else if(random > single && random <= married) {
            return MARRIED;
        }

        return IN_RELATIONSHIP;
    }

    // TODO : base more on stats
    public float getProbability() {
        switch (mMaritalStatus) {
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
