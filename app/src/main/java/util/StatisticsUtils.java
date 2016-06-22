package util;

import android.util.Log;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Set;

import belief.Belief;
import model.Game;
import model.Person;
import model.PopulationStatistic;
import personattribute.PersonAttribute;

public class StatisticsUtils {
    public static HashMap<String, PopulationStatistic> initBeliefStatistics() {
        HashMap<String, PopulationStatistic> statistics = new HashMap<>();

        try {
            Set<Class<? extends Belief>> classes = getBeliefSubClasses();

            for (Class<? extends Belief> beliefClass : classes) {
                Belief belief = beliefClass.newInstance();
                statistics.put(belief.getBeliefCategory().getAsString() + "_" + belief.getName(), new PopulationStatistic(belief.getName(), 0, 0, 0));
            }
        } catch (Exception e) {
            Log.e("Congregation", "Failed to init belief statistics. " + e.toString());
        }

        return statistics;
    }

    public static HashMap<String, PopulationStatistic> initPersonAttributeStastics() {
        HashMap<String, PopulationStatistic> statistics = new HashMap<>();

        try {
            Set<Class<? extends PersonAttribute>> classes = getPersonAttributeSubClasses();

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

    public static Set<Class<? extends Belief>> getBeliefSubClasses() {
        Reflections reflections = new Reflections("com.stromberg.scott.congregation.belief");
        return reflections.getSubTypesOf(Belief.class);
    }

    public static Set<Class<? extends PersonAttribute>> getPersonAttributeSubClasses() {
        Reflections reflections = new Reflections("com.stromberg.scott.congregation.personattributes");
        return reflections.getSubTypesOf(PersonAttribute.class);
    }
}
