package world.enumsAndStructs;

public enum directions 
{
    UP, RIGHT, DOWN, LEFT, UP_RIGHT, DOWN_RIGHT, DOWN_LEFT, UP_LEFT;
    
    @Override
    public String toString()
    {
        switch (this) {
        case UP:
            return "UP";
        case RIGHT:
            return "RIGHT";
        case DOWN:
            return "DOWN";
        case LEFT:
            return "LEFT";
        case UP_RIGHT:
            return "UP_RIGHT";
        case DOWN_RIGHT:
            return "DOWN_RIGHT";
        case DOWN_LEFT:
            return "DOWN_LEFT";
        case UP_LEFT:
            return "UP_LEFT";
        default:
            return "";
        }
    }
    
}
