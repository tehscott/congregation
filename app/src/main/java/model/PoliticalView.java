package model;

import java.security.InvalidParameterException;

import util.Util;

/**
 * Created by SStrombe on 6/7/16.
 */
public enum PoliticalView {
    //http://sarathc.com/different-kinds-of-political-views.html
    DEMOCRATIC(0),
    REPUBLICAN(1),
    INDEPENDENT(2);

    private int mPoliticalView;

    PoliticalView(int politcalView) {
        mPoliticalView = politcalView;
    }

    public int getAsInt() {
        return mPoliticalView;
    }

    public static PoliticalView getFromInt(int politicalView) {

        switch (politicalView) {
            case 0:
                return DEMOCRATIC;
            case 1:
                return REPUBLICAN;
            case 2:
                return INDEPENDENT;
        }
        return null;
    }

    public String getAsString() {
        switch (mPoliticalView) {
            case 0:
                return "Democratic";
            case 1:
                return "Republican";
            case 2:
                return "Independent";
        }
        return null;
    }

    public float getProbability(Person person) {
        float republicanProbability = 0;
        float democraticProbability = 0;
        float independentProbability = 0;
        int factorCount = 4;

        if(person.mGender == Gender.MALE) {
            republicanProbability = .43f;
            democraticProbability = .44f;
            independentProbability = .13f;
        } else if(person.mGender == Gender.FEMALE) {
            republicanProbability = .36f;
            democraticProbability = .52f;
            independentProbability = .12f;
        }

        if(person.mRace == Race.WHITE) {
            republicanProbability += .49f;
            democraticProbability += .40f;
            independentProbability += .11f;
        } else if(person.mRace == Race.BLACK) {
            republicanProbability += .11f;
            democraticProbability += .80f;
            independentProbability += .9f;
        } else if(person.mRace == Race.HISPANIC) {
            republicanProbability += .26f;
            democraticProbability += .56f;
            independentProbability += .18f;
        } else if(person.mRace == Race.ASIAN) {
            republicanProbability += .23f;
            democraticProbability += .65f;
            independentProbability += .12f;
        }

        if(person.mEducationLevel == EducationLevel.HIGH_SCHOOL) {
            republicanProbability += .37f;
            democraticProbability += .47f;
            independentProbability += .16f;
        } else if(person.mEducationLevel == EducationLevel.SOME_COLLEGE) {
            republicanProbability += .42f;
            democraticProbability += .47f;
            independentProbability += .11f;
        } else if(person.mEducationLevel == EducationLevel.COLLEGE_GRADUATE) {
            republicanProbability += .40f;
            democraticProbability += .52f;
            independentProbability += .8f;
        } else if(person.mEducationLevel == EducationLevel.POST_GRADUATE) {
            republicanProbability += 36.f;
            democraticProbability += 56.f;
            independentProbability += 8.f;
        }

        if(person.mAge >= 18 && person.mAge <= 34) {
            republicanProbability += .35f;
            democraticProbability += .51f;
            independentProbability += .14f;
        } else if(person.mAge >= 35 && person.mAge <= 54) {
            republicanProbability += 38.f;
            democraticProbability += 49.f;
            independentProbability += 13.f;
        } else if(person.mAge >= 55 && person.mAge <= 72) {
            republicanProbability += 41.f;
            democraticProbability += 47.f;
            independentProbability += 12.f;
        } else if(person.mAge >= 73) {
            republicanProbability += 47.f;
            democraticProbability += 43.f;
            independentProbability += 10.f;
        }

        switch (mPoliticalView) {
            case 0:
                return democraticProbability / factorCount;
            case 1:
                return republicanProbability / factorCount;
            case 2:
                return independentProbability / factorCount;
        }

        return -1;
    }

    public static PoliticalView generatePoliticalView(Person person) {
        if(person != null && person.mGender != null && person.mRace != null && person.mEducationLevel != null && person.mAge > 0) {
            float republican = REPUBLICAN.getProbability(person);
            float democratic = republican + DEMOCRATIC.getProbability(person);
            float independent = democratic + INDEPENDENT.getProbability(person);

            double random = Util.generateRandomFloatInRange(0, independent);

            if(random <= republican) {
                return REPUBLICAN;
            } else if(random > republican && random <= democratic) {
                return DEMOCRATIC;
            }

            return INDEPENDENT;
        } else {
            throw new InvalidParameterException("Gender, Race, and Education Level must be set before calling this.");
        }
    }
}
