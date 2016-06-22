package personattribute;

public abstract class PersonAttribute {
    public abstract int getTypeCount();
    public abstract String getName();

    protected int mType;

    public int getType() {
        return mType;
    }
}
