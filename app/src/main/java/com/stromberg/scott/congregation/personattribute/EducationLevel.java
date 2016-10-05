package com.stromberg.scott.congregation.personattribute;

import java.security.InvalidParameterException;

import com.stromberg.scott.congregation.model.Person;
import com.stromberg.scott.congregation.util.Util;

/**
 * Created by SStrombe on 6/9/16.
 */
public class EducationLevel extends PersonAttribute {
    public static int HIGH_SCHOOL = 0;
    public static int SOME_COLLEGE = 1;
    public static int COLLEGE_GRADUATE = 2;
    public static int POST_GRADUATE = 3;

    public EducationLevel(int type) {
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
                return "High School";
            case 1:
                return "Some College";
            case 2:
                return "College Graduate";
            case 3:
                return "Post Graduate";
        }
        return null;
    }

    public static EducationLevel generateEducationLevel(Person person) {
        if(person != null && person.mGender != null && person.mRace != null && person.mAge > 0 && person.mSocialClass != null) {
            float highSchool = getProbability(person, HIGH_SCHOOL);
            float someCollege = highSchool + getProbability(person, SOME_COLLEGE);
            float collegeGraduate = someCollege + getProbability(person, COLLEGE_GRADUATE);
            float postGraduate = collegeGraduate + getProbability(person, POST_GRADUATE);

            double random = Util.generateRandomFloatInRange(0, postGraduate);

            // TODO: this is not returning the right kind of education for super elites (and probably others)
            if(random >= postGraduate) {
                return new EducationLevel(POST_GRADUATE);
            } else if(random < postGraduate && random >= collegeGraduate) {
                return new EducationLevel(COLLEGE_GRADUATE);
            } else if(random < collegeGraduate && random >= someCollege) {
                return new EducationLevel(SOME_COLLEGE);
            }

            return new EducationLevel(HIGH_SCHOOL);
        } else {
            throw new InvalidParameterException("Gender, Race, Age, and Social Class must be set before calling this.");
        }
    }

    // https://www.census.gov/content/dam/Census/library/publications/2016/demo/p20-578.pdf
    private static float getProbability(Person person, int type) {
        float highSchoolProbability = 0;
        float someCollegeProbability = 0;
        float collegeGraduateProbability = 0;
        float postGraduateProbability = 0;
        int factorCount = 4;

        if(person.mGender.getType() == Gender.MALE) {
            highSchoolProbability += .88f;
            someCollegeProbability += .576f;
            collegeGraduateProbability += .323f;
            postGraduateProbability += .12f;
        } else if(person.mGender.getType() == Gender.FEMALE) {
            highSchoolProbability += .888f;
            someCollegeProbability += .601f;
            collegeGraduateProbability += .327f;
            postGraduateProbability += .12f;
        }

        if(person.mRace.getType() == Race.WHITE) {
            highSchoolProbability += .88f;
            someCollegeProbability += .592f;
            collegeGraduateProbability += .328f;
            postGraduateProbability += .121f;
        } else if(person.mRace.getType() == Race.BLACK) {
            highSchoolProbability += .87f;
            someCollegeProbability += .529f;
            collegeGraduateProbability += .225f;
            postGraduateProbability += .082f;
        } else if(person.mRace.getType() == Race.HISPANIC) {
            highSchoolProbability += .667f;
            someCollegeProbability += .368f;
            collegeGraduateProbability += .155f;
            postGraduateProbability += 047f;
        } else if(person.mRace.getType() == Race.ASIAN) {
            highSchoolProbability += .891f;
            someCollegeProbability += .70f;
            collegeGraduateProbability += .539f;
            postGraduateProbability += .214f;
        }

        if(person.mAge >= 18 && person.mAge <= 34) {
            highSchoolProbability += .905f;
            someCollegeProbability += .65f;
            collegeGraduateProbability += .361f;
            postGraduateProbability += .109f;
        } else if(person.mAge >= 35 && person.mAge <= 54) {
            highSchoolProbability += .887f;
            someCollegeProbability += .628f;
            collegeGraduateProbability += .363f;
            postGraduateProbability += .138f;
        } else if(person.mAge >= 55 && person.mAge <= 72) {
            highSchoolProbability += .894f;
            someCollegeProbability += .59f;
            collegeGraduateProbability += .32f;
            postGraduateProbability += .121f;
        } else if(person.mAge >= 73) {
            highSchoolProbability += .843f;
            someCollegeProbability += .497f;
            collegeGraduateProbability += .267f;
            postGraduateProbability += .113f;
        }

        if(person.mSocialClass.getType() == SocialClass.MIDDLE) {
            highSchoolProbability = 0;
            someCollegeProbability = .1f * factorCount;
            collegeGraduateProbability = .25f * factorCount;
            postGraduateProbability = .4f * factorCount;
        } else if(person.mSocialClass.getType() == SocialClass.UPPER) {
            highSchoolProbability = 0;
            someCollegeProbability = .05f * factorCount;
            collegeGraduateProbability = .2f * factorCount;
            postGraduateProbability = .35f * factorCount;
        } else if(person.mSocialClass.getType() == SocialClass.ELITE) {
            highSchoolProbability = 0;
            someCollegeProbability = 0;
            collegeGraduateProbability = 0;
            postGraduateProbability = .3f * factorCount;
        } else if(person.mSocialClass.getType() == SocialClass.SUPER_ELITE) {
            highSchoolProbability = 0;
            someCollegeProbability = 0;
            collegeGraduateProbability = 0;
            postGraduateProbability = .3f * factorCount;
        }

        switch (type) {
            case 0:
                return someCollegeProbability / factorCount;
            case 1:
                return highSchoolProbability / factorCount;
            case 2:
                return collegeGraduateProbability / factorCount;
            case 3:
                return postGraduateProbability / factorCount;
        }

        return -1;
    }
}