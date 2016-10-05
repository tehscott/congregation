package com.stromberg.scott.congregation.personattribute;

/**
 * Created by SStrombe on 6/9/16.
 */
public class Gender extends PersonAttribute {
    public static int MALE = 0;
    public static int FEMALE = 1;

    public Gender(int type) {
        mType = type;
    }

    @Override
    public int getType() {
        return mType;
    }

    @Override
    public int getTypeCount() {
        return 2;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Male";
            case 1:
                return "Female";
        }
        return null;
    }

    public static Gender generateGender() {
        float male = getProbability(MALE);
        float female = male + getProbability(FEMALE);

        double random = Math.random();

        if(random <= male) {
            return new Gender(MALE);
        }

        return new Gender(FEMALE);
    }

    private static float getProbability(int type) {
        switch (type) {
            case 0:
                return .491f;
            case 1:
                return .509f;
        }

        return -1;
    }
}