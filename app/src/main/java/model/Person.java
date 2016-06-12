package model;

import android.util.Log;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Person {
    public float mFaithLevel;
    public float mGullibilityLevel;
    public float mDesireLevel;
    public float mMoralityLevel;
    public float mDevotionLevel;

    public int mNetWorth;
    public int mCash;
    public int mIncome;
    public int mDebt;

    public float mWeight;
    public float mHeight;

    public String mName;
    public String mProfession;

    ArrayList<Belief> mBeliefs;

    public SocialClass mSocialClass;
    public PoliticalView mPoliticalView;
    public MaritalStatus mMaritalStatus;

    public int mAge;
    public Gender mGender;
    public Sexuality mSexuality;
    public Race mRace;
    public EducationLevel mEducationLevel;

    // Ideas:
    // children
    // mental and physical health

    public Person() {
        mFaithLevel = (float) (Math.random() * 100);
        mGullibilityLevel = (float) (Math.random() * 100);
        mDesireLevel = (float) (Math.random() * 100);
        mMoralityLevel = (float) (Math.random() * 100);
        mDevotionLevel = 0;

        String[] profession = generateStartingProfession();
        mProfession = profession[Profession.INDEX_PROFESSION_TITLE];
        mIncome = Integer.parseInt(profession[Profession.INDEX_PROFESSION_SALARY]);
        mDebt = generateStartingDebt();

        mGender = Gender.generateGender();
        mRace = Race.generateRace();
        mAge = generateStartingAge();
        mWeight = generateStartingWeight();
        mHeight = generateStartingHeight();
        mName = Name.generateName(this);

        mSocialClass = SocialClass.generateSocialClass();
        mNetWorth = generateStartingNetWorth();
        mCash = (int) (mNetWorth * .05f);

        mMaritalStatus = MaritalStatus.generateMaritalStatus();
        mSexuality = Sexuality.generateSexuality();

        mEducationLevel = EducationLevel.generatePoliticalView(this);
        mPoliticalView = PoliticalView.generatePoliticalView(this);
    }

    private int generateStartingAge() {
        return 18 + (int)(Math.random() * ((110 - 18) + 1));
    }

    //http://www.fool.com/investing/general/2015/05/17/americans-average-net-worth-by-age-how-do-you-comp.aspx
    private int generateStartingNetWorth() {
        if(mSocialClass != null) {
            int averageNetWorth = 0;

            if (mSocialClass == SocialClass.LOWER) {
                averageNetWorth = 87530;
            } else if (mSocialClass == SocialClass.WORKING) {
                averageNetWorth = 111350;
            } else if (mSocialClass == SocialClass.MIDDLE) {
                averageNetWorth = 170070;
            } else if (mSocialClass == SocialClass.UPPER) {
                averageNetWorth = 333840;
            } else if (mSocialClass == SocialClass.ELITE) {
                averageNetWorth = 6299200;
            } else {
                averageNetWorth = 62480100;
            }

            float variation = getRandomFloatInRange(.8f, 1.2f);
            return (int) (averageNetWorth * variation);
        } else {
            throw new IllegalStateException("Social Class must be set before calling this.");
        }
    }

    private String[] generateStartingProfession() {
        // TODO: Make a chance of being retired based on age, increasing with age

        int random = (int)(Math.random() * Profession.professions.length);

        return Profession.professions[random];
    }

    //https://www.nerdwallet.com/blog/credit-card-data/average-credit-card-debt-household/
    private int generateStartingDebt() {
        float maxDebt = 260000;

        return (int)(Math.random() * maxDebt);
    }

    private float generateStartingWeight() {
        if(mGender != null && mAge > 0) {
            float variation = getRandomFloatInRange(.8f, 1.2f);
            float weight = 0;

            if(mAge <= 29) {
                if(mGender == Gender.MALE) {
                    weight = 183.4f;
                } else {
                    weight = 156.5f;
                }
            } else if(mAge >= 30 && mAge <= 39) {
                if(mGender == Gender.MALE) {
                    weight = 189.1f;
                } else {
                    weight = 163f;
                }
            } else if(mAge >= 40 && mAge <= 49) {
                if(mGender == Gender.MALE) {
                    weight = 196f;
                } else {
                    weight = 168.2f;
                }
            } else if(mAge >= 50 && mAge <= 59) {
                if(mGender == Gender.MALE) {
                    weight = 195.4f;
                } else {
                    weight = 169.2f;
                }
            } else if(mAge >= 60 && mAge <= 74) {
                if(mGender == Gender.MALE) {
                    weight = 191.5f;
                } else {
                    weight = 164.7f;
                }
            } else {
                if(mGender == Gender.MALE) {
                    weight = 172.7f;
                } else {
                    weight = 146.6f;
                }
            }

            return weight * variation;
        } else {
            throw new InvalidParameterException("Gender and Age must be set before calling this.");
        }
    }

    private float generateStartingHeight() {
        if(mGender != null && mAge > 0) {
            float variation = getRandomFloatInRange(.9f, 1.1f);
            float height = 0; // inches

            if(mAge <= 29) {
                if(mGender == Gender.MALE) {
                    height = 69.6f;
                } else {
                    height = 64.1f;
                }
            } else if(mAge >= 30 && mAge <= 39) {
                if(mGender == Gender.MALE) {
                    height = 69.5f;
                } else {
                    height = 64.2f;
                }
            } else if(mAge >= 40 && mAge <= 49) {
                if(mGender == Gender.MALE) {
                    height = 69.7f;
                } else {
                    height = 64.3f;
                }
            } else if(mAge >= 50 && mAge <= 59) {
                if(mGender == Gender.MALE) {
                    height = 69.2f;
                } else {
                    height = 63.9f;
                }
            } else if(mAge >= 60 && mAge <= 74) {
                if(mGender == Gender.MALE) {
                    height = 68.6f;
                } else {
                    height = 63f;
                }
            } else {
                if(mGender == Gender.MALE) {
                    height = 67.4f;
                } else {
                    height = 62f;
                }
            }

            Log.i("height", "height " + height + ", variation " + variation);

            return height * variation;
        } else {
            throw new InvalidParameterException("Gender and Age must be set before calling this.");
        }
    }

    public String getHeightString() {
        int feet = (int)(mHeight / 12);
        int inches = (int)(mHeight % 12);

        return feet + "'" + " " + inches + "\"";
    }

    private float getRandomFloatInRange(float min, float max) {
        double random = Math.random() * max;

        if(random < min) {
            random = min;
        }

        return (float) random;
    }

    @Override
    public String toString() {
        return "Name: " + mName + "\n" +
                "Weight: " + mWeight + " lbs" + "\n" +
                "Height: " + getHeightString() + "\n" +
                "Age: " + mAge + "\n" +
                "Gender: " + mGender + "\n" +
                "Race: " + mRace + "\n" +
                "Sexuality: " + mSexuality.getAsString() + "\n" +
                "Marital Status: " + mMaritalStatus.getAsString() + "\n" +
                "Social Class: " + mSocialClass.getAsString() + "\n" +
                "Education Level: " + mEducationLevel.getAsString() + "\n" +
                "Profession: " + mProfession + "\n" +
                "Income: " + mIncome + "\n" +
                "Cash: " + mCash + "\n" +
                "Net Worth: " + mNetWorth + "\n" +
                "Debt: " + mDebt + "\n" +
                "Political View: " + mPoliticalView.getAsString() + "\n" +
                "Faith: " + mFaithLevel + "\n" +
                "Gullibility: " + mGullibilityLevel + "\n" +
                "Desire: " + mDesireLevel + "\n" +
                "Morality: " + mMoralityLevel + "\n" +
                "Devotion: " + mDevotionLevel + "\n\n";

    }
}
