package belief;

public enum SexualityType {
    ASEXUAL(0),
    BISEXUAL(1),
    HETEROSEXUAL(2),
    HOMOSEXUAL(3),
    PANSEXUAL(4);

    private int mSexualityType;

    SexualityType(int sexualityType) {
        this.mSexualityType = sexualityType;
    }

    public int getAsInt() {
        return mSexualityType;
    }

    public static SexualityType getFromInt(int sexualityType) {

        switch (sexualityType) {
            case 0:
                return ASEXUAL;
            case 1:
                return BISEXUAL;
            case 2:
                return HETEROSEXUAL;
            case 3:
                return HOMOSEXUAL;
            case 4:
                return PANSEXUAL;
            case 5:
        }
        return null;
    }

    public String getAsString() {
        switch (mSexualityType) {
            case 0:
                return "Asexual";
            case 1:
                return "Bisexual";
            case 2:
                return "Heterosexual";
            case 3:
                return "Homosexual";
            case 4:
                return "Pansexual";
        }
        return null;
    }
}
