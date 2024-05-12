package world.organisms.animals.species;

import world.organisms.Organism;
import world.organisms.animals.Animal;
import world.World;
import world.enumsAndStructs.Species;

import java.awt.Color;


public class Wolf extends Animal
{
    public Wolf(int x, int y,World world)
    {
        super(9, 5, x, y,new Color (250,230,222), Species.WOLF, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new Wolf(x, y, world);
    }
}
