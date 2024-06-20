package world.organisms.plants.species;

import world.World;
import world.organisms.Organism;
import world.organisms.plants.Plant;
import world.enumsAndStructs.*;

public class SosnowskyHogweed extends Plant
{
    public SosnowskyHogweed(int x, int y, World world) {
        super(10, x, y, java.awt.Color.RED, Species.SOSNOWSKY_HOGWEED, world);
    }

    public Organism newOrganism(int x, int y)
    {
        return new SosnowskyHogweed(x, y, world);
    }

    public void action()
    {

        for (int dir = 0; dir < 8; dir++)
        {
            int newX = x + directions[dir].x;
            int newY = y + directions[dir].y;
            if (world.isInBounds(newX, newY) && world.getOrganism(newX, newY) != null)
            {
                if (world.getOrganism(newX, newY).getType() == Type.ANIMAL)

                    world.getOrganism(newX, newY).die();
            }
        }
        super.action();
    }
}
