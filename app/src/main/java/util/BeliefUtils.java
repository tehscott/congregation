package util;

import android.util.Log;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Set;

import belief.Belief;

public class BeliefUtils {
    public static ArrayList<Belief> generateBeliefs() {
        ArrayList<Belief> beliefs = new ArrayList<>();

        try {
            Set<Class<? extends Belief>> classes = getBeliefSubClasses();

            for (Class<? extends Belief> beliefClass : classes) {
                Belief belief = beliefClass.newInstance();
                beliefs.addAll(belief.generateBeliefs());
            }
        } catch (Exception e) {
            Log.e("Congregation", "Failed to init belief statistics. " + e.toString());
        }

        return beliefs;
    }

    private static Set<Class<? extends Belief>> getBeliefSubClasses() {
        Reflections reflections = new Reflections("com.stromberg.scott.congregation.belief");
        return reflections.getSubTypesOf(Belief.class);
    }
}
