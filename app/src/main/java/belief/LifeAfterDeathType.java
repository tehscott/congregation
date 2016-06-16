package belief;

public enum LifeAfterDeathType {
    HEAVEN(0),
    HELL(1),
    RESURRECTION(2),
    REINCARNATION(3),
    RAPTURE(4);

    private int mLifeAfterDeathType;

    LifeAfterDeathType(int lifeAfterDeathType) {
        this.mLifeAfterDeathType = lifeAfterDeathType;
    }

    public int getAsInt() {
        return mLifeAfterDeathType;
    }

    public static LifeAfterDeathType getFromInt(int lifeAfterDeathType) {

        switch (lifeAfterDeathType) {
            case 0:
                return HEAVEN;
            case 1:
                return HELL;
            case 2:
                return RESURRECTION;
            case 3:
                return REINCARNATION;
            case 4:
                return RAPTURE;
        }
        return null;
    }

    public String getAsString() {
        switch (mLifeAfterDeathType) {
            case 0:
                return "Heaven";
            case 1:
                return "Hell";
            case 2:
                return "Resurrection";
            case 3:
                return "Reincarnation";
            case 4:
                return "Rapture";
        }
        return null;
    }
}
