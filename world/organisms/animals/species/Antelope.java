package world.organisms.animals.species;

import java.awt.Color;

import world.organisms.animals.Animal;
import world.*;
import world.enumsAndStructs.*;
import world.organisms.*;

public class Antelope extends Animal
{
   private twoInts[] dirs = directions.clone();
    public Antelope(int x, int y, World world)
    {
        super(4, 4, x, y, new Color(255, 255, 255), Species.ANTELOPE, world);
        for (twoInts dir : directions)
        {
            dir.x *= 2;
            dir.y *= 2;
        }
    }
    public Organism newOrganism(int x, int y)
    {
        return new Antelope(x, y, world);
    }
    public boolean runAway()
    {
        if (Math.random()<0.50)
        {
            int dir = (int) (Math.random() * 8);
            int counter=0;
            while (world.isOccupied(x+dirs[dir].x, y+dirs[dir].y) && counter<8) 
            {
                dir = (dir++) %8;
                counter++;
            }
            if (counter==8)
            {
                return false;
            }
            x+=dirs[dir].x;
            y+=dirs[dir].y;
            return true;
        }

        return false;
    }
}
