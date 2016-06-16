package belief;

public enum ReligiousEventType {
    RAPTURE(0),
    END_OF_TIMES(1),
    ENLIGHTENMENT(2);

    private int mReligiousEventType;

    ReligiousEventType(int religiousEventType) {
        this.mReligiousEventType = religiousEventType;
    }

    public int getAsInt() {
        return mReligiousEventType;
    }

    public static ReligiousEventType getFromInt(int religiousEventType) {

        switch (religiousEventType) {
            case 0:
                return RAPTURE;
            case 1:
                return END_OF_TIMES;
            case 2:
                return ENLIGHTENMENT;
        }
        return null;
    }

    public String getAsString() {
        switch (mReligiousEventType) {
            case 0:
                return "Rapture";
            case 1:
                return "End Of Times";
            case 2:
                return "Enlightenment";
        }
        return null;
    }
}