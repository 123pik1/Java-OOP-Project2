package world.organisms.animals.species;

import java.awt.Color;

import world.organisms.animals.Animal;
import world.*;
import world.enumsAndStructs.Species;
import world.organisms.*;

public class Sheep extends Animal
{
    public Sheep(int x, int y, World world)
    {
        super(4, 4, x, y, new Color(255, 255, 255), Species.SHEEP, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new Sheep(x, y, world);
    }
}
