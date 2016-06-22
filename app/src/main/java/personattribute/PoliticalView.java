package personattribute;

import java.security.InvalidParameterException;

import model.Person;
import util.Util;

/**
 * Created by SStrombe on 6/7/16.
 */
public class PoliticalView extends PersonAttribute {
    //http://sarathc.com/different-kinds-of-political-views.html
    public static int DEMOCRATIC = 0;
    public static int REPUBLICAN = 1;
    public static int INDEPENDENT = 2;

    public PoliticalView(int type) {
        mType = type;
    }

    @Override
    public int getTypeCount() {
        return 0;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Democratic";
            case 1:
                return "Republican";
            case 2:
                return "Independent";
        }
        return null;
    }

    private static float getProbability(Person person, int type) {
        float republicanProbability = 0;
        float democraticProbability = 0;
        float independentProbability = 0;
        int factorCount = 4;

        if(person.mGender.getType() == Gender.MALE) {
            republicanProbability = .43f;
            democraticProbability = .44f;
            independentProbability = .13f;
        } else if(person.mGender.getType() == Gender.FEMALE) {
            republicanProbability = .36f;
            democraticProbability = .52f;
            independentProbability = .12f;
        }

        if(person.mRace.getType() == Race.WHITE) {
            republicanProbability += .49f;
            democraticProbability += .40f;
            independentProbability += .11f;
        } else if(person.mRace.getType() == Race.BLACK) {
            republicanProbability += .11f;
            democraticProbability += .80f;
            independentProbability += .9f;
        } else if(person.mRace.getType() == Race.HISPANIC) {
            republicanProbability += .26f;
            democraticProbability += .56f;
            independentProbability += .18f;
        } else if(person.mRace.getType() == Race.ASIAN) {
            republicanProbability += .23f;
            democraticProbability += .65f;
            independentProbability += .12f;
        }

        if(person.mEducationLevel.getType() == EducationLevel.HIGH_SCHOOL) {
            republicanProbability += .37f;
            democraticProbability += .47f;
            independentProbability += .16f;
        } else if(person.mEducationLevel.getType() == EducationLevel.SOME_COLLEGE) {
            republicanProbability += .42f;
            democraticProbability += .47f;
            independentProbability += .11f;
        } else if(person.mEducationLevel.getType() == EducationLevel.COLLEGE_GRADUATE) {
            republicanProbability += .40f;
            democraticProbability += .52f;
            independentProbability += .8f;
        } else if(person.mEducationLevel.getType() == EducationLevel.POST_GRADUATE) {
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

        switch (type) {
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
            float republican = getProbability(person, REPUBLICAN);
            float democratic = republican + getProbability(person, DEMOCRATIC);
            float independent = democratic + getProbability(person, INDEPENDENT);

            double random = Util.generateRandomFloatInRange(0, independent);

            if(random <= republican) {
                return new PoliticalView(REPUBLICAN);
            } else if(random > republican && random <= democratic) {
                return new PoliticalView(DEMOCRATIC);
            }

            return new PoliticalView(INDEPENDENT);
        } else {
            throw new InvalidParameterException("Gender, Race, and Education Level must be set before calling this.");
        }
    }
}
