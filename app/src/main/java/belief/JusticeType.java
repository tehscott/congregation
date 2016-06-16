package belief;

public enum JusticeType {
    KARMA(0),
    REDEMPTION(2),
    FORGIVENESS(3),
    REVENGE(4);

    private int mJusticeType;

    JusticeType(int justiceType) {
        this.mJusticeType = justiceType;
    }

    public int getAsInt() {
        return mJusticeType;
    }

    public static JusticeType getFromInt(int justiceType) {

        switch (justiceType) {
            case 0:
                return KARMA;
            case 1:
                return REDEMPTION;
            case 2:
                return FORGIVENESS;
            case 3:
                return REVENGE;
        }
        return null;
    }

    public String getAsString() {
        switch (mJusticeType) {
            case 0:
                return "Heaven";
            case 1:
                return "Hell";
            case 2:
                return "Forgiveness";
            case 3:
                return "Revenge";
        }
        return null;
    }
}
