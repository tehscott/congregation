package belief;

public enum MiracleType {
    HEALING(0),
    RESURRECTION(1),
    REANIMATION(2);

    private int mMiracleType;

    MiracleType(int miracleType) {
        this.mMiracleType = miracleType;
    }

    public int getAsInt() {
        return mMiracleType;
    }

    public static MiracleType getFromInt(int miracleType) {

        switch (miracleType) {
            case 0:
                return HEALING;
            case 1:
                return RESURRECTION;
            case 2:
                return REANIMATION;
        }
        return null;
    }

    public String getAsString() {
        switch (mMiracleType) {
            case 0:
                return "Healing";
            case 1:
                return "Resurrection";
            case 2:
                return "Reanimation";
        }
        return null;
    }
}
