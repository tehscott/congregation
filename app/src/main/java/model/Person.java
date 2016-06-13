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

    public long mNetWorth;
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

        mEducationLevel = EducationLevel.generateEducationLevel(this);
        mPoliticalView = PoliticalView.generatePoliticalView(this);

        String[] profession = Profession.generateProfession(this);
        mProfession = profession[Profession.INDEX_PROFESSION_TITLE];
        mIncome = Integer.parseInt(profession[Profession.INDEX_PROFESSION_SALARY]);
        mDebt = generateStartingDebt();
    }

    // http://www.census.gov/prod/cen2010/briefs/c2010br-03.pdf
    private int generateStartingAge() {
        int age;
        double random = Math.random();

        float twentyFour = .355f;
        float fourtyFour = twentyFour + .266f;
        float sixtyFour = fourtyFour + .264f;

        if(random <= twentyFour) {
            age = 18 + (int)(Math.random() * ((24 - 18) + 1));
        } else if(random > twentyFour && random <= fourtyFour) {
            age = 25 + (int)(Math.random() * ((44 - 25) + 1));
        } else if(random > fourtyFour && random <= sixtyFour) {
            age = 45 + (int)(Math.random() * ((64 - 45) + 1));
        } else {
            age = 65 + (int)(Math.random() * ((90 - 65) + 1));
        }

        return age;
    }

    //http://www.fool.com/investing/general/2015/05/17/americans-average-net-worth-by-age-how-do-you-comp.aspx
    private long generateStartingNetWorth() {
        if(mSocialClass != null) {
            long baseNetWorth = 0;
            float variation = 1;

            if (mSocialClass == SocialClass.LOWER) {
                baseNetWorth = 15000;
            } else if (mSocialClass == SocialClass.WORKING) {
                baseNetWorth = 30000;
            } else if (mSocialClass == SocialClass.MIDDLE) {
                baseNetWorth = 170000;
            } else if (mSocialClass == SocialClass.UPPER) {
                baseNetWorth = 350000;
            } else if (mSocialClass == SocialClass.ELITE) {
                baseNetWorth = 3500000;
            } else {
                baseNetWorth = 6000000000L;
            }

            if(mAge <= 25) {
                variation = 0.5f;
            } else if(mAge >= 26 && mAge <= 35) {
                variation = 1f;
            } else if(mAge >= 36 && mAge <= 45) {
                variation = 1.25f;
            } else if(mAge >= 46 && mAge <= 65) {
                variation = 1.5f;
            } else {
                variation = 1.25f;
            }

            float netWorth = baseNetWorth * variation;

            if(mEducationLevel == EducationLevel.HIGH_SCHOOL) {
                variation = 0.5f;
            } else if(mEducationLevel == EducationLevel.SOME_COLLEGE) {
                variation = 1f;
            } else if(mEducationLevel == EducationLevel.COLLEGE_GRADUATE) {
                variation = 1.5f;
            } else if(mEducationLevel == EducationLevel.POST_GRADUATE) {
                variation = 1.25f;
            }

            netWorth = netWorth * variation;

            variation = getRandomFloatInRange(.9f, 1.1f);

            netWorth = netWorth * variation;

            return (long) netWorth;
        } else {
            throw new IllegalStateException("Social Class must be set before calling this.");
        }
    }

    //https://www.nerdwallet.com/blog/credit-card-data/average-credit-card-debt-household/
    private int generateStartingDebt() {
        float maxDebt = 0;
        float debtMultiplier = 0;

        if(mEducationLevel == EducationLevel.HIGH_SCHOOL) {
            maxDebt = 5000;
        } else if(mEducationLevel == EducationLevel.SOME_COLLEGE) {
            maxDebt = 10000;
        } else if(mEducationLevel == EducationLevel.COLLEGE_GRADUATE) {
            maxDebt = 40000;
        } else if(mEducationLevel == EducationLevel.POST_GRADUATE) {
            maxDebt = 200000;
        }

        if (mSocialClass == SocialClass.LOWER) {
            debtMultiplier = 1f;
        } else if (mSocialClass == SocialClass.WORKING) {
            debtMultiplier = .9f;
        } else if (mSocialClass == SocialClass.MIDDLE) {
            debtMultiplier = .75f;
        } else if (mSocialClass == SocialClass.UPPER) {
            debtMultiplier = .5f;
        } else if (mSocialClass == SocialClass.ELITE) {
            debtMultiplier = 0f;
        } else {
            debtMultiplier = 0f;
        }

        return (int)(Math.random() * maxDebt * debtMultiplier);
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

    public static float getRandomFloatInRange(float min, float max) {
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
