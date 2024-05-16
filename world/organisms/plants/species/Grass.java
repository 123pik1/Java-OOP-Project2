package world.organisms.plants.species;
import world.organisms.Organism;
import world.organisms.plants.Plant;
import world.enumsAndStructs.*;
import world.World;

public class Grass extends Plant
{
    public Grass (int x, int y, World world)
    {
        super(0,  x, y, java.awt.Color.GREEN, Species.GRASS, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new Grass(x, y, world);
    }
}
