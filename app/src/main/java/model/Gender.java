package model;

/**
 * Created by SStrombe on 6/9/16.
 */
public enum Gender {
    MALE(0),
    FEMALE(1);

    private int mGender;

    Gender(int gender) {
        mGender = gender;
    }

    public int getAsInt() {
        return mGender;
    }

    public static Gender getFromInt(int gender) {

        switch (gender) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
        }
        return null;
    }

    public String getAsString() {
        switch (mGender) {
            case 0:
                return "Male";
            case 1:
                return "Female";
        }
        return null;
    }

    public static Gender generateGender() {
        float male = MALE.getProbability();
        float female = male + FEMALE.getProbability();

        double random = Math.random();

        if(random <= male) {
            return MALE;
        }

        return FEMALE;
    }

    public float getProbability() {
        switch (mGender) {
            case 0:
                return .491f;
            case 1:
                return .509f;
        }

        return -1;
    }
}