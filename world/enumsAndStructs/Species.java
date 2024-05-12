package world.enumsAndStructs;

public enum Species
{
    WOLF, SHEEP, FOX, TURTLE, ANTELOPE, GRASS, DANDELION, GUARANA, BELLADONNA, SOSNOWSKY_HOGWEED;

    @Override
    public String toString()
    {
        switch (this) {
        case WOLF:
            return "W";
        case SHEEP:
            return "S";
        case FOX:
            return "F";
        case TURTLE:
            return "T";
        case ANTELOPE:
            return "A";
        case GRASS:
            return "G";
        case DANDELION:
            return "D";
        case GUARANA:
            return "U";
        case BELLADONNA:
            return "B";
        case SOSNOWSKY_HOGWEED:
            return "H";
        default:
            return "";
        }
    }

    public String getName()
    {
        switch (this) {
        case WOLF:
            return "WOLF";
        case SHEEP:
            return "SHEEP";
        case FOX:
            return "FOX";
        case TURTLE:
            return "TURTLE";
        case ANTELOPE:
            return "ANTELOPE";
        case GRASS:
            return "GRASS";
        case DANDELION:
            return "DANDELION";
        case GUARANA:
            return "GUARANA";
        case BELLADONNA:
            return "BELLADONNA";
        case SOSNOWSKY_HOGWEED:
            return "SOSNOWSKY_HOGWEED";
        default:
            return "";
        }
    }
}
