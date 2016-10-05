package com.stromberg.scott.congregation.util;

import android.util.Log;

import com.stromberg.scott.congregation.belief.Belief;
import com.stromberg.scott.congregation.belief.Justice;
import com.stromberg.scott.congregation.belief.LifeAfterDeath;
import com.stromberg.scott.congregation.belief.Miracle;
import com.stromberg.scott.congregation.belief.Mystics;
import com.stromberg.scott.congregation.belief.OriginOfHumanity;
import com.stromberg.scott.congregation.belief.Relationship;
import com.stromberg.scott.congregation.belief.ReligiousEvent;
import com.stromberg.scott.congregation.belief.Sexuality;
import com.stromberg.scott.congregation.belief.SupernaturalBeing;
import com.stromberg.scott.congregation.belief.Theism;
import com.stromberg.scott.congregation.belief.Worship;

import java.util.ArrayList;

public class BeliefUtils {
    public static ArrayList<Belief> generateBeliefs() {
        ArrayList<Belief> beliefs = new ArrayList<>();

        try {
            ArrayList<Class<? extends Belief>> classes = getBeliefSubClasses();

            for (Class<? extends Belief> beliefClass : classes) {
                Belief belief = beliefClass.newInstance();
                beliefs.addAll(belief.generateBeliefs());
            }
        } catch (Exception e) {
            Log.e("Congregation", "Failed to init belief statistics. " + e.toString());
        }

        return beliefs;
    }

    public static ArrayList<Class<? extends Belief>> getBeliefSubClasses() {
        ArrayList<Class<? extends Belief>> beliefs = new ArrayList<>();

        beliefs.add(Justice.class);
        beliefs.add(LifeAfterDeath.class);
        beliefs.add(Miracle.class);
        beliefs.add(Mystics.class);
        beliefs.add(OriginOfHumanity.class);
        beliefs.add(Relationship.class);
        beliefs.add(ReligiousEvent.class);
        beliefs.add(Sexuality.class);
        beliefs.add(SupernaturalBeing.class);
        beliefs.add(Theism.class);
        beliefs.add(Worship.class);

        return beliefs;
    }
}
