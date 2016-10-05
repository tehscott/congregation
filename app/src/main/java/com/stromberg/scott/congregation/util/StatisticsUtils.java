package com.stromberg.scott.congregation.util;

import android.util.Log;

import com.stromberg.scott.congregation.belief.Belief;
import com.stromberg.scott.congregation.model.Game;
import com.stromberg.scott.congregation.model.Person;
import com.stromberg.scott.congregation.model.PopulationStatistic;
import com.stromberg.scott.congregation.personattribute.EducationLevel;
import com.stromberg.scott.congregation.personattribute.Gender;
import com.stromberg.scott.congregation.personattribute.MaritalStatus;
import com.stromberg.scott.congregation.personattribute.PersonAttribute;
import com.stromberg.scott.congregation.personattribute.PoliticalView;
import com.stromberg.scott.congregation.personattribute.Race;
import com.stromberg.scott.congregation.personattribute.Sexuality;
import com.stromberg.scott.congregation.personattribute.SocialClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StatisticsUtils {
    public static HashMap<String, PopulationStatistic> initBeliefStatistics() {
        HashMap<String, PopulationStatistic> statistics = new HashMap<>();

        try {
            ArrayList<Class<? extends Belief>> classes = BeliefUtils.getBeliefSubClasses();

            for (Class<? extends Belief> beliefClass : classes) {
                Belief belief = beliefClass.newInstance();

                for(int i = 0; i < belief.getMaxNumberOfBeliefs(); i++) {
                    belief.mType = i;
                    statistics.put(belief.getBeliefCategory().getAsString() + "_" + belief.getName(), new PopulationStatistic(belief.getName(), 0, 0, 0));
                }

            }
        } catch (Exception e) {
            Log.e("Congregation", "Failed to init belief statistics. " + e.toString());
        }

        return statistics;
    }

    public static HashMap<String, PopulationStatistic> initPersonAttributeStastics() {
        HashMap<String, PopulationStatistic> statistics = new HashMap<>();

        try {
            ArrayList<Class<? extends PersonAttribute>> classes = getPersonAttributeSubClasses();

            for (Class<? extends PersonAttribute> personAttributeClass : classes) {
                PersonAttribute personAttribute = personAttributeClass.newInstance();
                statistics.put(personAttributeClass.getName() + "_" + personAttribute.getName(), new PopulationStatistic(personAttribute.getName(), 0, 0, 0));
            }
        } catch (Exception e) {
            Log.e("Congregation", "Failed to init person attribute statistics. " + e.toString());
        }

        return statistics;
    }

    public static void updateStatistics(Game game, Person person, boolean isAdd) {
        if(isAdd) {
            game.getPopulationStatistics().add(person);
        }
    }

    public static ArrayList<Class<? extends PersonAttribute>> getPersonAttributeSubClasses() {
        ArrayList<Class<? extends PersonAttribute>> personAttributes = new ArrayList<>();

        personAttributes.add(EducationLevel.class);
        personAttributes.add(Gender.class);
        personAttributes.add(MaritalStatus.class);
        personAttributes.add(PoliticalView.class);
        personAttributes.add(Race.class);
        personAttributes.add(Sexuality.class);
        personAttributes.add(SocialClass.class);

        return personAttributes;
    }
}
