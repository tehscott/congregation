package belief;

public enum OriginOfHumanityType {
    CREATION_FROM_ELEMENTS(0),
    CREATION_BY_SUPREME_BEING(1),
    CREATION_FROM_SPIRITS(2),
    CREATION_BY_SUPERNATURAL(3),
    CREATION_FROM_ANIMALS(4),
    EVOLVE_FROM_MONKEYS(5),
    EVOLVE_FROM_SNAKES(6),
    EVOLVE_FROM_ALIENS(7),
    ETHEREAL(8),
    OTHER_WORLDS(9),
    DESCENDED_FROM_GODS(10),
    ALIENS(11);

    private int mMiracleType;

    OriginOfHumanityType(int miracleType) {
        this.mMiracleType = miracleType;
    }

    public int getAsInt() {
        return mMiracleType;
    }

    public static OriginOfHumanityType getFromInt(int miracleType) {

        switch (miracleType) {
            case 0:
                return CREATION_FROM_ELEMENTS;
            case 1:
                return CREATION_BY_SUPREME_BEING;
            case 2:
                return CREATION_FROM_SPIRITS;
            case 3:
                return CREATION_BY_SUPERNATURAL;
            case 4:
                return CREATION_FROM_ANIMALS;
            case 5:
                return EVOLVE_FROM_MONKEYS;
            case 6:
                return EVOLVE_FROM_SNAKES;
            case 7:
                return EVOLVE_FROM_ALIENS;
            case 8:
                return ETHEREAL;
            case 9:
                return OTHER_WORLDS;
            case 10:
                return DESCENDED_FROM_GODS;
            case 11:
                return ALIENS;
        }
        return null;
    }

    public String getAsString() {
        switch (mMiracleType) {
            case 0:
                return "Creation From Elements";
            case 1:
                return "Creation By Supreme Being";
            case 2:
                return "Creation From Spirits";
            case 3:
                return "Creation By Supernatural";
            case 4:
                return "Creation From Animals";
            case 5:
                return "Evolve From Monkeys";
            case 6:
                return "Evolve From Snakes";
            case 7:
                return "Evolve From Aliens";
            case 8:
                return "Ethereal";
            case 9:
                return "Other Worlds";
            case 10:
                return "Descended From Gods";
            case 11:
                return "Aliens";
        }
        return null;
    }
}
