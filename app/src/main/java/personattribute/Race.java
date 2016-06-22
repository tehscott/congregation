package personattribute;

/**
 * Created by SStrombe on 6/9/16.
 */
public class Race extends PersonAttribute {
    public static int WHITE = 0;
    public static int BLACK = 1;
    public static int HISPANIC = 2;
    public static int ASIAN = 3;

    public Race(int type) {
        mType = type;
    }

    @Override
    public int getTypeCount() {
        return 4;
    }

    @Override
    public String getName() {
        switch (mType) {
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
        float white = getProbability(WHITE);
        float black = white + getProbability(BLACK);
        float hispanic = black + getProbability(HISPANIC);
        float asian = hispanic + getProbability(ASIAN);

        double random = Math.random();

        if(random <= white) {
            return new Race(WHITE);
        } else if(random > white && random <= black) {
            return new Race(BLACK);
        } else if(random > hispanic && random <= asian) {
            return new Race(HISPANIC);
        }

        return new Race(ASIAN);
    }

    private static float getProbability(int type) {
        switch (type) {
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
