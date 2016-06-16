package belief;

import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 * Created by SStrombe on 6/7/16.
 */
public enum BeliefCategory {
    LIFE_AFTER_DEATH(0),
    THEISM(1),
    WORSHIP(2),
    MIRACLES(3),
    ORIGIN_OF_HUMANITY(4),
    SUPERNATURAL_BEINGS(5),
    RELIGIOUS_EVENTS(6),
    SEXUALITY(7),
    RELATIONSHIPS(8),
    MYSTICS(9),
    JUSTICE(10);

    private int mBeliefType;

    BeliefCategory(int beliefType) {
        mBeliefType = beliefType;
    }

    public int getAsInt() {
        return mBeliefType;
    }

    public static BeliefCategory getFromInt(int beliefType) {

        switch (beliefType) {
            case 0:
                return LIFE_AFTER_DEATH;
            case 1:
                return THEISM;
            case 2:
                return WORSHIP;
            case 3:
                return MIRACLES;
            case 4:
                return ORIGIN_OF_HUMANITY;
            case 5:
                return SUPERNATURAL_BEINGS;
            case 6:
                return RELIGIOUS_EVENTS;
            case 7:
                return SEXUALITY;
            case 8:
                return RELATIONSHIPS;
            case 9:
                return MYSTICS;
            case 10:
                return JUSTICE;
        }
        return null;
    }

    public String getAsString() {
        switch (mBeliefType) {
            case 0:
                return "Life After Death";
            case 1:
                return "Theism";
            case 2:
                return "Worship";
            case 3:
                return "Miracles";
            case 4:
                return "Origin of Humanity";
            case 5:
                return "Supernatural Beings";
            case 6:
                return "Religious Events";
            case 7:
                return "Sexuality";
            case 8:
                return "Relationships";
            case 9:
                return "Mystics";
            case 10:
                return "Justice";
        }
        return null;
    }

    public static List<Belief> generateBeliefs(BeliefCategory category) {
        List<Belief> beliefs = new ArrayList<>();

        if(category == Justice.getBeliefCategory()) {
            // No limit
            int maxBeliefs = JusticeType.values().length;
        } else if(category == LifeAfterDeath.getBeliefCategory()) {
            // Heaven, hell, resurrection, rapture are all compatible (does rapture fit with resurrection?)
            // Reincarnation doesn't fit with any

            int maxBeliefs = LifeAfterDeathType.values().length;
        } else if(category == Miracle.getBeliefCategory()) {
            // No limit

            int maxBeliefs = MiracleType.values().length;
        } else if(category == Mystics.getBeliefCategory()) {
            // No limit

            int maxBeliefs = MysticsType.values().length;
        } else if(category == OriginOfHumanity.getBeliefCategory()) {
            // Limit 1

            int maxBeliefs = OriginOfHumanityType.values().length;
        } else if(category == Relationship.getBeliefCategory()) {
            // Limit 1

            int maxBeliefs = RelationshipType.values().length;
        } else if(category == ReligiousEvent.getBeliefCategory()) {
            // Rapture and end of times fit
            // Enlightenment is on its own

            int maxBeliefs = ReligiousEventType.values().length;
        } else if(category == Sexuality.getBeliefCategory()) {

        } else if(category == SupernaturalBeing.getBeliefCategory()) {

        } else if(category == Theism.getBeliefCategory()) {

        } else if(category == Worship.getBeliefCategory()) {

        }

        return beliefs;
    }
}

