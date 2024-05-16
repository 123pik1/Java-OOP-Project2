package world.organisms.plants.species;

import world.World;
import world.enumsAndStructs.Species;
import world.organisms.Organism;
import world.organisms.plants.Plant;

public class Belladonna extends Plant{
    public Belladonna(int x, int y, World world)
    {
        super(99, x, y, java.awt.Color.MAGENTA, Species.BELLADONNA, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new Belladonna(x, y, world);
    }
}
