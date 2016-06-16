package belief;

public abstract class Belief {
    public abstract String getName();
    public abstract float getLevel();
    public abstract void init(boolean isMajorBelief);
}
