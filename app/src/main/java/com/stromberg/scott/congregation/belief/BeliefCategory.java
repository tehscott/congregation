package com.stromberg.scott.congregation.belief;

/**
 * Created by SStrombe on 6/7/16.
 */
public enum BeliefCategory {
    LIFE_AFTER_DEATH(0),
    THEISM(1),
    WORSHIP(2),
    MIRACLES(3),
    ORIGIN_OF_HUMANITY(4),
    SUPERNATURAL_BEINGS(5),
    RELIGIOUS_EVENTS(6),
    SEXUALITY(7),
    RELATIONSHIPS(8),
    MYSTICS(9),
    JUSTICE(10);

    private int mBeliefType;

    BeliefCategory(int beliefType) {
        mBeliefType = beliefType;
    }

    public int getAsInt() {
        return mBeliefType;
    }

    public static BeliefCategory getFromInt(int beliefType) {

        switch (beliefType) {
            case 0:
                return LIFE_AFTER_DEATH;
            case 1:
                return THEISM;
            case 2:
                return WORSHIP;
            case 3:
                return MIRACLES;
            case 4:
                return ORIGIN_OF_HUMANITY;
            case 5:
                return SUPERNATURAL_BEINGS;
            case 6:
                return RELIGIOUS_EVENTS;
            case 7:
                return SEXUALITY;
            case 8:
                return RELATIONSHIPS;
            case 9:
                return MYSTICS;
            case 10:
                return JUSTICE;
        }
        return null;
    }

    public String getAsString() {
        switch (mBeliefType) {
            case 0:
                return "Life After Death";
            case 1:
                return "Theism";
            case 2:
                return "Worship";
            case 3:
                return "Miracles";
            case 4:
                return "Origin of Humanity";
            case 5:
                return "Supernatural Beings";
            case 6:
                return "Religious Events";
            case 7:
                return "Sexuality";
            case 8:
                return "Relationships";
            case 9:
                return "Mystics";
            case 10:
                return "Justice";
        }
        return null;
    }
}

