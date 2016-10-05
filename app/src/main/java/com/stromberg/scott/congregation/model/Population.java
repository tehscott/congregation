package com.stromberg.scott.congregation.model;

import java.util.ArrayList;

import com.stromberg.scott.congregation.util.StatisticsUtils;

/**
 * Created by SStrombe on 6/17/16.
 */
public class Population {
    private Game mGame;
    private ArrayList<Person> mPeople = new ArrayList<>();

    public Population(Game game) {
        this.mGame = game;
    }

    public PopulationStatistics addPerson(Person person) {
        mPeople.add(person);

        StatisticsUtils.updateStatistics(mGame, person, true);

        return mGame.getPopulationStatistics();
    }
}
