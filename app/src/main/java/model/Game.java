package model;

import com.stromberg.scott.congregation.activity.MainActivity;

import personattribute.Name;

/**
 * Created by SStrombe on 6/17/16.
 */
public class Game {
    private MainActivity mMainActivity;
    private PopulationStatistics mPopulationStatistics;
    private Population mPopulation;

    public Game(MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mPopulationStatistics = new PopulationStatistics();
        mPopulation = new Population(this);

        Name.init(mMainActivity.getBaseContext());
    }

    public PopulationStatistics getPopulationStatistics() {
        return mPopulationStatistics;
    }

    public Population getPopulation() {
        return mPopulation;
    }
}
