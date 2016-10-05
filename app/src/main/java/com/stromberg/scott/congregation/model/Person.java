package com.stromberg.scott.congregation.model;

import android.util.Log;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import com.stromberg.scott.congregation.belief.Belief;
import com.stromberg.scott.congregation.personattribute.EducationLevel;
import com.stromberg.scott.congregation.personattribute.Gender;
import com.stromberg.scott.congregation.personattribute.MaritalStatus;
import com.stromberg.scott.congregation.personattribute.Name;
import com.stromberg.scott.congregation.personattribute.PoliticalView;
import com.stromberg.scott.congregation.personattribute.Profession;
import com.stromberg.scott.congregation.personattribute.Race;
import com.stromberg.scott.congregation.personattribute.Sexuality;
import com.stromberg.scott.congregation.personattribute.SocialClass;
import com.stromberg.scott.congregation.util.BeliefUtils;
import com.stromberg.scott.congregation.util.Util;

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
        mFaithLevel = Util.generateRandomFloatInRange(0, 100);
        mGullibilityLevel = Util.generateRandomFloatInRange(0, 100);
        mDesireLevel = Util.generateRandomFloatInRange(0, 100);
        mMoralityLevel = Util.generateRandomFloatInRange(0, 100);
        mDevotionLevel = 0;

        mGender = Gender.generateGender();
        mRace = Race.generateRace();
        mAge = generateStartingAge();
        mWeight = generateStartingWeight();
        mHeight = generateStartingHeight();
        mName = Name.generateName(this);

        mSocialClass = SocialClass.generateSocialClass();
        mEducationLevel = EducationLevel.generateEducationLevel(this);

        mNetWorth = generateStartingNetWorth();
        mCash = (int) (mNetWorth * .05f);

        mMaritalStatus = MaritalStatus.generateMaritalStatus();
        mSexuality = Sexuality.generateSexuality();

        mPoliticalView = PoliticalView.generatePoliticalView(this);

        String[] profession = Profession.generateProfession(this);
        mProfession = profession[Profession.INDEX_PROFESSION_TITLE];
        mIncome = Integer.parseInt(profession[Profession.INDEX_PROFESSION_SALARY]);
        mDebt = generateStartingDebt();

        mBeliefs = BeliefUtils.generateBeliefs();
    }

    // http://www.census.gov/prod/cen2010/briefs/c2010br-03.pdf
    private int generateStartingAge() {
        int age;
        double random = Math.random();

        float twentyFour = .355f;
        float fourtyFour = twentyFour + .266f;
        float sixtyFour = fourtyFour + .264f;

        if(random <= twentyFour) {
            age = Util.generateRandomIntInRange(18, 24);
        } else if(random > twentyFour && random <= fourtyFour) {
            age = Util.generateRandomIntInRange(25, 44);
        } else if(random > fourtyFour && random <= sixtyFour) {
            age = Util.generateRandomIntInRange(45, 64);
        } else {
            age = Util.generateRandomIntInRange(65, 90);
        }

        return age;
    }

    //http://www.fool.com/investing/general/2015/05/17/americans-average-net-worth-by-age-how-do-you-comp.aspx
    private long generateStartingNetWorth() {
        if(mSocialClass != null && mEducationLevel != null) {
            long baseNetWorth = 0;
            float variation = 1;

            if (mSocialClass.getType() == SocialClass.LOWER) {
                baseNetWorth = 15000;
            } else if (mSocialClass.getType() == SocialClass.WORKING) {
                baseNetWorth = 30000;
            } else if (mSocialClass.getType() == SocialClass.MIDDLE) {
                baseNetWorth = 170000;
            } else if (mSocialClass.getType() == SocialClass.UPPER) {
                baseNetWorth = 350000;
            } else if (mSocialClass.getType() == SocialClass.ELITE) {
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

            if(mEducationLevel.getType() == EducationLevel.HIGH_SCHOOL) {
                variation = 0.5f;
            } else if(mEducationLevel.getType() == EducationLevel.SOME_COLLEGE) {
                variation = 1f;
            } else if(mEducationLevel.getType() == EducationLevel.COLLEGE_GRADUATE) {
                variation = 1.5f;
            } else if(mEducationLevel.getType() == EducationLevel.POST_GRADUATE) {
                variation = 1.25f;
            }

            netWorth = netWorth * variation;

            variation = Util.generateRandomFloatInRange(.9f, 1.1f);

            netWorth = netWorth * variation;

            return (long) netWorth;
        } else {
            throw new IllegalStateException("Social Class and Education Level must be set before calling this.");
        }
    }

    //https://www.nerdwallet.com/blog/credit-card-data/average-credit-card-debt-household/
    private int generateStartingDebt() {
        float maxDebt = 0;
        float debtMultiplier = 0;

        if(mEducationLevel.getType() == EducationLevel.HIGH_SCHOOL) {
            maxDebt = 5000;
        } else if(mEducationLevel.getType() == EducationLevel.SOME_COLLEGE) {
            maxDebt = 10000;
        } else if(mEducationLevel.getType() == EducationLevel.COLLEGE_GRADUATE) {
            maxDebt = 40000;
        } else if(mEducationLevel.getType() == EducationLevel.POST_GRADUATE) {
            maxDebt = 200000;
        }

        if (mSocialClass.getType() == SocialClass.LOWER) {
            debtMultiplier = 1f;
        } else if (mSocialClass.getType() == SocialClass.WORKING) {
            debtMultiplier = .9f;
        } else if (mSocialClass.getType() == SocialClass.MIDDLE) {
            debtMultiplier = .75f;
        } else if (mSocialClass.getType() == SocialClass.UPPER) {
            debtMultiplier = .5f;
        } else if (mSocialClass.getType() == SocialClass.ELITE) {
            debtMultiplier = 0f;
        } else {
            debtMultiplier = 0f;
        }

        return (int) Util.generateRandomFloatInRange(0, maxDebt * debtMultiplier);
    }

    private float generateStartingWeight() {
        if(mGender != null && mAge > 0) {
            float variation = Util.generateRandomFloatInRange(.8f, 1.2f);
            float weight = 0;

            if(mAge <= 29) {
                if(mGender.getType() == Gender.MALE) {
                    weight = 183.4f;
                } else {
                    weight = 156.5f;
                }
            } else if(mAge >= 30 && mAge <= 39) {
                if(mGender.getType() == Gender.MALE) {
                    weight = 189.1f;
                } else {
                    weight = 163f;
                }
            } else if(mAge >= 40 && mAge <= 49) {
                if(mGender.getType() == Gender.MALE) {
                    weight = 196f;
                } else {
                    weight = 168.2f;
                }
            } else if(mAge >= 50 && mAge <= 59) {
                if(mGender.getType() == Gender.MALE) {
                    weight = 195.4f;
                } else {
                    weight = 169.2f;
                }
            } else if(mAge >= 60 && mAge <= 74) {
                if(mGender.getType() == Gender.MALE) {
                    weight = 191.5f;
                } else {
                    weight = 164.7f;
                }
            } else {
                if(mGender.getType() == Gender.MALE) {
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
            float variation = Util.generateRandomFloatInRange(.9f, 1.1f);
            float height = 0; // inches

            if(mAge <= 29) {
                if(mGender.getType() == Gender.MALE) {
                    height = 69.6f;
                } else {
                    height = 64.1f;
                }
            } else if(mAge >= 30 && mAge <= 39) {
                if(mGender.getType() == Gender.MALE) {
                    height = 69.5f;
                } else {
                    height = 64.2f;
                }
            } else if(mAge >= 40 && mAge <= 49) {
                if(mGender.getType() == Gender.MALE) {
                    height = 69.7f;
                } else {
                    height = 64.3f;
                }
            } else if(mAge >= 50 && mAge <= 59) {
                if(mGender.getType() == Gender.MALE) {
                    height = 69.2f;
                } else {
                    height = 63.9f;
                }
            } else if(mAge >= 60 && mAge <= 74) {
                if(mGender.getType() == Gender.MALE) {
                    height = 68.6f;
                } else {
                    height = 63f;
                }
            } else {
                if(mGender.getType() == Gender.MALE) {
                    height = 67.4f;
                } else {
                    height = 62f;
                }
            }

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

    @Override
    public String toString() {
        String data ="Name: " + mName + "\n" +
                "Weight: " + mWeight + " lbs" + "\n" +
                "Height: " + getHeightString() + "\n" +
                "Age: " + mAge + "\n" +
                "Gender: " + mGender.getName() + "\n" +
                "Race: " + mRace.getName() + "\n" +
                "Sexuality: " + mSexuality.getName() + "\n" +
                "Marital Status: " + mMaritalStatus.getName() + "\n" +
                "Social Class: " + mSocialClass.getName() + "\n" +
                "Education Level: " + mEducationLevel.getName() + "\n" +
                "Profession: " + mProfession + "\n" +
                "Income: " + mIncome + "\n" +
                "Cash: " + mCash + "\n" +
                "Net Worth: " + mNetWorth + "\n" +
                "Debt: " + mDebt + "\n" +
                "Political View: " + mPoliticalView.getName() + "\n" +
                "Faith: " + mFaithLevel + "\n" +
                "Gullibility: " + mGullibilityLevel + "\n" +
                "Desire: " + mDesireLevel + "\n" +
                "Morality: " + mMoralityLevel + "\n" +
                "Devotion: " + mDevotionLevel + "\n";

        if(mBeliefs != null) {
            for (Belief mBelief : mBeliefs) {
                data += mBelief.getName() + ": " + mBelief.getLevel() + "\n";
            }

            data += "\n";
        }

        return data;
    }
}
