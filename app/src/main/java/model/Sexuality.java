package model;

/**
 * Created by SStrombe on 6/10/16.
 */
public enum Sexuality {
    ASEXUAL(0),
    BISEXUAL(1),
    HETEROSEXUAL(2),
    HOMOSEXUAL(3);

    private int mSexuality;

    Sexuality(int sexuality) {
        mSexuality = sexuality;
    }

    public int getAsInt() {
        return mSexuality;
    }

    public static Sexuality getFromInt(int sexuality) {

        switch (sexuality) {
            case 0:
                return ASEXUAL;
            case 1:
                return BISEXUAL;
            case 2:
                return HETEROSEXUAL;
            case 3:
                return HOMOSEXUAL;
        }
        return null;
    }

    public String getAsString() {
        switch (mSexuality) {
            case 0:
                return "Asexual";
            case 1:
                return "Bisexual";
            case 2:
                return "Heterosexual";
            case 3:
                return "Homosexual";
        }
        return null;
    }

    public static Sexuality generateSexuality() {
        float asexual = ASEXUAL.getProbability();
        float bisexual = asexual + BISEXUAL.getProbability();
        float heterosexuality = bisexual + HETEROSEXUAL.getProbability();
        float homosexuality = heterosexuality + HOMOSEXUAL.getProbability();

        double random = Math.random();

        if(random <= asexual) {
            return ASEXUAL;
        } else if(random > asexual && random <= bisexual) {
            return BISEXUAL;
        } else if(random > bisexual && random <= heterosexuality) {
            return HETEROSEXUAL;
        }

        return HOMOSEXUAL;
    }

    public float getProbability() {
        switch (mSexuality) {
            case 0:
                return .01f;
            case 1:
                return .018f;
            case 2:
                return .955f;
            case 3:
                return .017f;
        }

        return -1;
    }
}
