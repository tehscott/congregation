package belief;

import java.util.ArrayList;

import util.Util;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Worship extends Belief {
    public static int GODS = 0;
    public static int REAL_ANIMALS = 1;
    public static int MYTHICAL_ANIMALS = 2;
    public static int OBJECTS = 3;
    public static int LIVING_PEOPLE = 4;
    public static int DEAD_PEOPLE = 5;
    public static int NATURE = 6;
    public static int SCRIPTURE = 7;
    public static int SCIENCE = 8;
    public static int COSMOS = 9;
    public static int COSMIC_BODIES = 10;
    public static int COSMIC_ENTITIES = 11;
    public static int PROPITIATION = 12;
    public static int TITHES = 13;
    public static int MATERIAL_SACRIFICE = 14;

    public Worship() {
    }

    public Worship(int type) {
        mType = type;

        init();
    }

    @Override
    public BeliefCategory getBeliefCategory() {
        return BeliefCategory.WORSHIP;
    }

    @Override
    public String getName() {
        switch (mType) {
            case 0:
                return "Gods";
            case 1:
                return "Real Animals";
            case 2:
                return "Mythical Animals";
            case 3:
                return "Objects";
            case 4:
                return "Living People";
            case 5:
                return "Dead People";
            case 6:
                return "Nature";
            case 7:
                return "Scripture";
            case 8:
                return "Science";
            case 9:
                return "Cosmos";
            case 10:
                return "Cosmic Bodies";
            case 11:
                return "Cosmic Entities";
            case 12:
                return "Propitiation";
            case 13:
                return "Tithes";
            case 14:
                return "Material Sacrifice";
        }
        return null;
    }

    @Override
    public float getLevel() {
        return mLevel;
    }

    @Override
    public void init() {
        mLevel = Util.generateRandomFloatInRange(0f, 100f);
    }

    @Override
    public ArrayList<Belief> generateBeliefs() {
        ArrayList<Belief> beliefs = new ArrayList<>();

        for(int i = 0; i < getMaxNumberOfBeliefs(); i++) {
            beliefs.add(new Worship(i));
        }

        return beliefs;
    }

    @Override
    public int getMaxNumberOfBeliefs() {
        return 15;
    }
}