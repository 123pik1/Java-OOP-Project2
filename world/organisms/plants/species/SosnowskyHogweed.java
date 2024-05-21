package world.organisms.plants.species;

import world.World;
import world.enumsAndStructs.Species;
import world.organisms.Organism;
import world.organisms.plants.Plant;
import world.enumsAndStructs.*;

public class SosnowskyHogweed extends Plant
{
    public SosnowskyHogweed(int x, int y, World world)
    {
        super(10, x, y, java.awt.Color.YELLOW, Species.SOSNOWSKY_HOGWEED, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new SosnowskyHogweed(x, y, world);
    }
    public void action()
    {
        for (int i = 0; i < 3; i++)
        {
            int dir = (int) (Math.random() * 8);
            int newX = x + directions[dir].x;
            int newY = y + directions[dir].y;
            if (world.isInBounds(newX, newY) && world.getOrganism(newX, newY)!=null)
            {
                if ( world.getOrganism(newX, newY).getType() == Type.ANIMAL)
                
                world.getOrganism(newX, newY).die();
            }
        }
    }
}
