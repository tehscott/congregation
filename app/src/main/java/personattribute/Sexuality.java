package personattribute;

/**
 * Created by SStrombe on 6/10/16.
 */
public class Sexuality extends PersonAttribute {
    public static int ASEXUAL = 0;
    public static int BISEXUAL = 1;
    public static int HETEROSEXUAL = 2;
    public static int HOMOSEXUAL = 3;

    public Sexuality(int type) {
        mType = type;
    }

    @Override
    public int getTypeCount() {
        return 4;
    }

    @Override
    public String getName() {
        switch (mType) {
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
        float asexual = getProbability(ASEXUAL);
        float bisexual = asexual + getProbability(BISEXUAL);
        float heterosexuality = bisexual + getProbability(HETEROSEXUAL);
        float homosexuality = heterosexuality + getProbability(HOMOSEXUAL);

        double random = Math.random();

        if(random <= asexual) {
            return new Sexuality(ASEXUAL);
        } else if(random > asexual && random <= bisexual) {
            return new Sexuality(BISEXUAL);
        } else if(random > bisexual && random <= heterosexuality) {
            return new Sexuality(HETEROSEXUAL);
        }

        return new Sexuality(HOMOSEXUAL);
    }

    private static float getProbability(int type) {
        switch (type) {
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
