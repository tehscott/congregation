package com.stromberg.scott.congregation.model;

import android.util.Log;

import com.stromberg.scott.congregation.belief.Belief;
import com.stromberg.scott.congregation.personattribute.PersonAttribute;
import com.stromberg.scott.congregation.util.StatisticsUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class PopulationStatistics {
    private PopulationStatistic mAverageFaithLevel;
    private PopulationStatistic mAverageGullibilityLevel;
    private PopulationStatistic mAverageDesireLevel;
    private PopulationStatistic mAverageMoralityLevel;
    private PopulationStatistic mAverageDevotionLevel;
    private PopulationStatistic mAverageWeight;
    private PopulationStatistic mAverageHeight;
    private PopulationStatistic mAverageNetWorth;
    private PopulationStatistic mAverageCash;
    private PopulationStatistic mAverageIncome;
    private PopulationStatistic mAverageDebt;
    private PopulationStatistic mAverageAge;

    private HashMap<String, PopulationStatistic> mAverageBeliefs;
    private HashMap<String, PopulationStatistic> mPersonAttributes;

    public PopulationStatistics() {
        init();
    }

    private void init() {
        mAverageBeliefs = new HashMap<>();
        mPersonAttributes = new HashMap<>();

        mAverageBeliefs.putAll(StatisticsUtils.initBeliefStatistics());
        mPersonAttributes.putAll(StatisticsUtils.initPersonAttributeStastics());

        mAverageFaithLevel = new PopulationStatistic("Average Faith Level", 0, 0, 0);
        mAverageGullibilityLevel = new PopulationStatistic("Average Gullibility Level", 0, 0, 0);
        mAverageDesireLevel = new PopulationStatistic("Average Desire Level", 0, 0, 0);
        mAverageMoralityLevel = new PopulationStatistic("Average Morality Level", 0, 0, 0);
        mAverageDevotionLevel = new PopulationStatistic("Average Devotion Level", 0, 0, 0);
        mAverageWeight = new PopulationStatistic("Average Weight Level", 0, 0, 0);
        mAverageHeight = new PopulationStatistic("Average Height Level", 0, 0, 0);
        mAverageNetWorth = new PopulationStatistic("Average Net Worth Level", 0, 0, 0);
        mAverageCash = new PopulationStatistic("Average Cash Level", 0, 0, 0);
        mAverageIncome = new PopulationStatistic("Average Income Level", 0, 0, 0);
        mAverageDebt = new PopulationStatistic("Average Debt Level", 0, 0, 0);
        mAverageAge = new PopulationStatistic("Average Age Level", 0, 0, 0);
    }

    public void add(Person person) {
        // Update beliefs
        for (Belief belief : person.mBeliefs) {
            String key = belief.getBeliefCategory().getAsString() + "_" + belief.getName();

            PopulationStatistic averageBelief = mAverageBeliefs.get(key);
            averageBelief.add(belief.getLevel());
        }

        // Update attributes
        try {
            ArrayList<Class<? extends PersonAttribute>> attributes = StatisticsUtils.getPersonAttributeSubClasses();

            Class parentObjectType = person.getClass();
            for (Class<? extends PersonAttribute> attribute : attributes) {
                for (Field field : parentObjectType.getDeclaredFields()) {
                    if (field.getName().equals(attribute.getName())) {
                        PersonAttribute personAttribute = (PersonAttribute) field.get(person);

                        String key = field.getName() + "_" + personAttribute.getName();
                        PopulationStatistic averageAttribute = mPersonAttributes.get(key);

                        averageAttribute.add(1);
                    }

                }
            }
        } catch (Exception e) {
            Log.e("Congregation", "Error updating statistics for adding an attribute.");
        }

        // Update levels
        mAverageFaithLevel.add(person.mFaithLevel);
        mAverageFaithLevel.add(person.mGullibilityLevel);
        mAverageFaithLevel.add(person.mDesireLevel );
        mAverageFaithLevel.add(person.mMoralityLevel);
        mAverageFaithLevel.add(person.mDevotionLevel);
        mAverageFaithLevel.add(person.mWeight);
        mAverageFaithLevel.add(person.mHeight);
        mAverageFaithLevel.add(person.mNetWorth);
        mAverageFaithLevel.add(person.mCash);
        mAverageFaithLevel.add(person.mIncome);
        mAverageFaithLevel.add(person.mDebt);
        mAverageFaithLevel.add(person.mAge);
    }
}
