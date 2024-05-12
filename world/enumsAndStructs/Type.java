package world.enumsAndStructs;

public enum Type {
    ANIMAL, PLANT;

    @Override
    public String toString()
    {
        switch (this) {
        case ANIMAL:
            return "ANIMAL";
        case PLANT:
            return "PLANT";
        default:
            return "";
        }
    }
}
