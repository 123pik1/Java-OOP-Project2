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
        if (attacker.getSpecies()==this.getSpecies())
        {
            reproduce();
        }
        else
        {
            fight(attacker);
        }

    }
    public void fight(Organism defender)
    {

    }
    private void reproduce()
    {
        int dirToReproduce = (int)(Math.random()*8);
        int counter = 0;
        while (world.isOccupied(x+directions[dirToReproduce].x, y+directions[dirToReproduce].y) && counter<8)
        {
            dirToReproduce = dirToReproduce+1%8;
            counter++;
        }
        world.addOrganism( newOrganism(x+directions[dirToReproduce].x, y+directions[dirToReproduce].y));
    }

    
}
