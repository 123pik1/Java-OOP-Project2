package world.organisms.animals.species;

import world.organisms.animals.Animal;
import java.awt.Color;

import world.*;
import world.enumsAndStructs.Species;
import world.organisms.*;

public class Turtle extends Animal
{
    public Turtle(int x, int y, World world)
    {
        super(2, 1, x, y, new Color(0, 0, 0), Species.TURTLE, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new Turtle(x, y, world);
    }
    public void move()
    {
        if (Math.random() < 0.25)
        {
            super.move();
            
        }
    }
    public boolean isMoveBlocked(Organism attacker)
    {
        if(attacker.getStrength() < 5)
        world.addLog("Turtle blocked");
        return attacker.getStrength() < 5;

    }
    
}
