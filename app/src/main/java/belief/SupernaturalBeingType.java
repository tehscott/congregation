package belief;

public enum SupernaturalBeingType {
    GODS(0),
    ANGELS(1),
    ALIENS(2),
    MYTHICAL_CREATURES(3),
    COSMIC_BEINGS(4);

    private int mSupernaturalBeingType;

    SupernaturalBeingType(int supernaturalBeingType) {
        this.mSupernaturalBeingType = supernaturalBeingType;
    }

    public int getAsInt() {
        return mSupernaturalBeingType;
    }

    public static SupernaturalBeingType getFromInt(int supernaturalBeingType) {

        switch (supernaturalBeingType) {
            case 0:
                return GODS;
            case 1:
                return ANGELS;
            case 2:
                return ALIENS;
            case 3:
                return MYTHICAL_CREATURES;
            case 4:
                return COSMIC_BEINGS;
        }
        return null;
    }

    public String getAsString() {
        switch (mSupernaturalBeingType) {
            case 0:
                return "Gods";
            case 1:
                return "Angels";
            case 2:
                return "Aliens";
            case 3:
                return "Mythical Creatures";
            case 4:
                return "Cosmic Beings";
        }
        return null;
    }
}
