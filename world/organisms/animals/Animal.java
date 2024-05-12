package world.organisms.animals;

import world.organisms.Organism;
import world.World;
import world.enumsAndStructs.Species;
import world.enumsAndStructs.Type;

import java.awt.Color;

public abstract class Animal extends Organism
{
   
    public Animal(int strength, int initiative, int x, int y, Color color, Species species, World world)
    {
       super(strength, initiative, x, y, color, Type.ANIMAL, species, world);
    }
    public void action()
    {
        move();
    }
    public void move()
    {

    }
    public void collision(Organism attacker)
    {

    }
    public void fight(Organism defender)
    {

    }
    
}
