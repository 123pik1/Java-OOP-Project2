package world.organisms.plants.species;

import world.World;
import world.enumsAndStructs.Species;
import world.organisms.Organism;
import world.organisms.plants.Plant;

public class Sonchus extends Plant
{
    public Sonchus (int x, int y, World world)
    {
        super(0,  x, y, java.awt.Color.YELLOW, Species.SONCHUS, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new Sonchus(x, y, this.world);
    }
    public void action()
    {
        for (int i = 0; i < 3; i++)
        {
            super.action();
        }
    }
}
