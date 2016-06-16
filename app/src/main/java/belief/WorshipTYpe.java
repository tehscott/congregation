package belief;

public enum WorshipType {
    GODS(0),
    REAL_ANIMALS(1),
    MYTHICAL_ANIMALS(2),
    OBJECTS(3),
    LIVING_PEOPLE(4),
    DEAD_PEOPLE(5),
    NATURE(6),
    SCRIPTURE(7),
    SCIENCE(8),
    COSMOS(9),
    COSMIC_BODIES(10),
    COSMIC_ENTITIES(11),
    PROPITIATION(12),
    TITHES(13),
    MATERIAL_SACRIFICE(14);

    private int mTheismType;

    WorshipType(int theismType) {
        this.mTheismType = theismType;
    }

    public int getAsInt() {
        return mTheismType;
    }

    public static WorshipType getFromInt(int theismType) {

        switch (theismType) {
            case 0:
                return GODS;
            case 1:
                return REAL_ANIMALS;
            case 2:
                return MYTHICAL_ANIMALS;
            case 3:
                return OBJECTS;
            case 4:
                return LIVING_PEOPLE;
            case 5:
                return DEAD_PEOPLE;
            case 6:
                return NATURE;
            case 7:
                return SCRIPTURE;
            case 8:
                return SCIENCE;
            case 9:
                return COSMOS;
            case 10:
                return COSMIC_BODIES;
            case 11:
                return COSMIC_ENTITIES;
            case 12:
                return PROPITIATION;
            case 13:
                return TITHES;
            case 14:
                return MATERIAL_SACRIFICE;
        }
        return null;
    }

    public String getAsString() {
        switch (mTheismType) {
            case 0:
                return "Gods";
            case 1:
                return "Real Animals";
            case 2:
                return "Mythical Animals";
            case 3:
                return "Objects";
            case 4:
                return "Living People";
            case 5:
                return "Dead People";
            case 6:
                return "Nature";
            case 7:
                return "Scripture";
            case 8:
                return "Science";
            case 9:
                return "Cosmos";
            case 10:
                return "Cosmic Bodies";
            case 11:
                return "Cosmic Entities";
            case 12:
                return "Propitiation";
            case 13:
                return "Tithes";
            case 14:
                return "Material Sacrifice";
        }
        return null;
    }
}
