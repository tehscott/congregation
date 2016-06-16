package belief;

public enum MysticsType {
    MAGIC(0),
    WITCHCRAFT(1),
    VOODOO(2),
    SORCERY(3),
    TIME_TRAVEL(4);

    private int mTheismType;

    MysticsType(int theismType) {
        this.mTheismType = theismType;
    }

    public int getAsInt() {
        return mTheismType;
    }

    public static MysticsType getFromInt(int theismType) {

        switch (theismType) {
            case 0:
                return MAGIC;
            case 1:
                return WITCHCRAFT;
            case 2:
                return VOODOO;
            case 3:
                return SORCERY;
            case 4:
                return TIME_TRAVEL;
        }
        return null;
    }

    public String getAsString() {
        switch (mTheismType) {
            case 0:
                return "Magic";
            case 1:
                return "Witchcraft";
            case 2:
                return "Voodoo";
            case 3:
                return "Sorcery";
            case 4:
                return "Time Travel";
        }
        return null;
    }
}
