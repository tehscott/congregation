package belief;

public enum RelationshipType {
    MONOGOMY(0),
    POLYGOMY(1),
    POLYANDRY(2),
    BIGAMY(3),
    POLYAMORY(4);

    private int mRelationshipType;

    RelationshipType(int relationshipType) {
        this.mRelationshipType = relationshipType;
    }

    public int getAsInt() {
        return mRelationshipType;
    }

    public static RelationshipType getFromInt(int relationshipType) {

        switch (relationshipType) {
            case 0:
                return MONOGOMY;
            case 1:
                return POLYGOMY;
            case 2:
                return POLYANDRY;
            case 3:
                return BIGAMY;
            case 4:
                return POLYAMORY;
        }
        return null;
    }

    public String getAsString() {
        switch (mRelationshipType) {
            case 0:
                return "Monogomy";
            case 1:
                return "Polygomy";
            case 2:
                return "Polyandry";
            case 3:
                return "Bigamy";
            case 4:
                return "Polyamory";
        }
        return null;
    }
}