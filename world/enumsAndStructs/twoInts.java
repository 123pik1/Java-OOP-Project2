package world.enumsAndStructs;

public class twoInts
{
    directions direction;
    public int x;
    public int y;

    public twoInts(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
    public twoInts(directions dir)
    {
        switch (dir) {
            case UP:
                this.x=0;
                this.y=-1;                
                break;
            case DOWN:
                this.x=0;
                this.y=1;
                break;
            case LEFT:
                this.x=-1;
                this.y=0;
                break;
            case RIGHT:
                this.x=1;
                this.y=0;
                break;
            case UP_LEFT:
                this.x=-1;
                this.y=-1;
                break;
            case UP_RIGHT:
                this.x=1;
                this.y=-1;
                break;
            case DOWN_LEFT:
                this.x=-1;
                this.y=1;
                break;
            case DOWN_RIGHT:
                this.x=1;
                this.y=1;
                break;
        
            default:
                break;
        }
    }
}
