package belief;

public enum TheismType {
    // http://en.wikipedia.org/wiki/Theism
    MONOTHEISM(0),
    POLYTHEISM(1),
    HENOTHEISM(2),
    KATHENOTHEISM(3),
    MONOLATRISM(4),
    PANTHEISM(5),
    PANENTHEISM(6),
    PANDEISM(7),
    PANENDEISM(8),
    POLYDEISM(9),
    AUTOTHEISM(10),
    EUTHEISM(11),
    DYSTHEISM(12),
    MISOTHEISM(13),
    ATHEISM(14);

    private int mTheismType;

    TheismType(int theismType) {
        this.mTheismType = theismType;
    }

    public int getAsInt() {
        return mTheismType;
    }

    public static TheismType getFromInt(int theismType) {

        switch (theismType) {
            case 0:
                return MONOTHEISM;
            case 1:
                return POLYTHEISM;
            case 2:
                return HENOTHEISM;
            case 3:
                return KATHENOTHEISM;
            case 4:
                return MONOLATRISM;
            case 5:
                return PANTHEISM;
            case 6:
                return PANENTHEISM;
            case 7:
                return PANDEISM;
            case 8:
                return PANENDEISM;
            case 9:
                return POLYDEISM;
            case 10:
                return AUTOTHEISM;
            case 11:
                return EUTHEISM;
            case 12:
                return DYSTHEISM;
            case 13:
                return MISOTHEISM;
            case 14:
                return ATHEISM;
        }
        return null;
    }

    public String getAsString() {
        switch (mTheismType) {
            case 0:
                return "Monotheism";
            case 1:
                return "Polytheism";
            case 2:
                return "Henotheism";
            case 3:
                return "Kathenotheism";
            case 4:
                return "Monolatrism";
            case 5:
                return "Pantheism";
            case 6:
                return "Panentheism";
            case 7:
                return "Pandeism";
            case 8:
                return "Panendeism";
            case 9:
                return "Polydeism";
            case 10:
                return "Autotheism";
            case 11:
                return "Eutheism";
            case 12:
                return "Dystheism";
            case 13:
                return "Misotheism";
            case 14:
                return "Atheism";
        }
        return null;
    }
}
