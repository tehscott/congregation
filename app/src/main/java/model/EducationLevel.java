package model;

import java.security.InvalidParameterException;

/**
 * Created by SStrombe on 6/9/16.
 */
public enum EducationLevel {
    HIGH_SCHOOL(0),
    SOME_COLLEGE(1),
    COLLEGE_GRADUATE(2),
    POST_GRADUATE(3);

    private int mEducationLevel;

    EducationLevel(int educationLevel) {
        mEducationLevel = educationLevel;
    }

    public int getAsInt() {
        return mEducationLevel;
    }

    public static EducationLevel getFromInt(int educationLevel) {

        switch (educationLevel) {
            case 0:
                return HIGH_SCHOOL;
            case 1:
                return SOME_COLLEGE;
            case 2:
                return COLLEGE_GRADUATE;
            case 3:
                return POST_GRADUATE;
        }
        return null;
    }

    public String getAsString() {
        switch (mEducationLevel) {
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

    // https://www.census.gov/content/dam/Census/library/publications/2016/demo/p20-578.pdf
    public float getProbability(Person person) {
        float highSchoolProbability = 0;
        float someCollegeProbability = 0;
        float collegeGraduateProbability = 0;
        float postGraduateProbability = 0;
        int factorCount = 3;

        if(person.mGender == Gender.MALE) {
            highSchoolProbability = .88f;
            someCollegeProbability = .576f;
            collegeGraduateProbability = .323f;
            postGraduateProbability = .12f;
        } else if(person.mGender == Gender.FEMALE) {
            highSchoolProbability = .888f;
            someCollegeProbability = .601f;
            collegeGraduateProbability = .327f;
            postGraduateProbability = .12f;
        }

        if(person.mRace == Race.WHITE) {
            highSchoolProbability = .88f;
            someCollegeProbability = .592f;
            collegeGraduateProbability = .328f;
            postGraduateProbability = .121f;
        } else if(person.mRace == Race.BLACK) {
            highSchoolProbability = .87f;
            someCollegeProbability = .529f;
            collegeGraduateProbability = .225f;
            postGraduateProbability = .082f;
        } else if(person.mRace == Race.HISPANIC) {
            highSchoolProbability = .667f;
            someCollegeProbability = .368f;
            collegeGraduateProbability = .155f;
            postGraduateProbability = 047f;
        } else if(person.mRace == Race.ASIAN) {
            highSchoolProbability = .891f;
            someCollegeProbability = .70f;
            collegeGraduateProbability = .539f;
            postGraduateProbability = .214f;
        }

        if(person.mAge >= 18 && person.mAge <= 34) {
            highSchoolProbability = .905f;
            someCollegeProbability = .65f;
            collegeGraduateProbability = .361f;
            postGraduateProbability = .109f;
        } else if(person.mAge >= 35 && person.mAge <= 54) {
            highSchoolProbability = .887f;
            someCollegeProbability = .628f;
            collegeGraduateProbability = .363f;
            postGraduateProbability = .138f;
        } else if(person.mAge >= 55 && person.mAge <= 72) {
            highSchoolProbability = .894f;
            someCollegeProbability = .59f;
            collegeGraduateProbability = .32f;
            postGraduateProbability = .121f;
        } else if(person.mAge >= 73) {
            highSchoolProbability = .843f;
            someCollegeProbability = .497f;
            collegeGraduateProbability = .267f;
            postGraduateProbability = .113f;
        }

        switch (mEducationLevel) {
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

    public static EducationLevel generatePoliticalView(Person person) {
        if(person != null && person.mGender != null && person.mRace != null && person.mAge > 0) {
            float highSchool = HIGH_SCHOOL.getProbability(person);
            float someCollege = highSchool + SOME_COLLEGE.getProbability(person);
            float collegeGraduate = someCollege + COLLEGE_GRADUATE.getProbability(person);
            float postGraduate = collegeGraduate + POST_GRADUATE.getProbability(person);

            double random = Math.random() * postGraduate;

            if(random <= highSchool) {
                return HIGH_SCHOOL;
            } else if(random > highSchool && random <= someCollege) {
                return SOME_COLLEGE;
            } else if(random > someCollege && random <= collegeGraduate) {
                return COLLEGE_GRADUATE;
            }

            return POST_GRADUATE;
        } else {
            throw new InvalidParameterException("Gender, Race, and Age must be set before calling this.");
        }
    }
}