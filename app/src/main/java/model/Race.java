package model;

/**
 * Created by SStrombe on 6/9/16.
 */
public enum Race {
    WHITE(0),
    BLACK(1),
    HISPANIC(2),
    ASIAN(3);

    private int mRace;

    Race(int mRace) {
        this.mRace = mRace;
    }

    public int getAsInt() {
        return mRace;
    }

    public static Race getFromInt(int race) {

        switch (race) {
            case 0:
                return WHITE;
            case 1:
                return BLACK;
            case 2:
                return HISPANIC;
            case 3:
                return ASIAN;
        }
        return null;
    }

    public String getAsString() {
        switch (mRace) {
            case 0:
                return "White";
            case 1:
                return "Black";
            case 2:
                return "Hispanic";
            case 3:
                return "Asian";
        }
        return null;
    }

    public static Race generateRace() {
        float white = WHITE.getProbability();
        float black = white + BLACK.getProbability();
        float hispanic = black + HISPANIC.getProbability();
        float asian = hispanic + ASIAN.getProbability();

        double random = Math.random();

        if(random <= white) {
            return WHITE;
        } else if(random > white && random <= black) {
            return BLACK;
        } else if(random > hispanic && random <= asian) {
            return HISPANIC;
        }

        return ASIAN;
    }

    public float getProbability() {
        switch (mRace) {
            case 0:
                return .646f;
            case 1:
                return .129f;
            case 2:
                return .125f;
            case 3:
                return .100f;
        }

        return -1;
    }
}
