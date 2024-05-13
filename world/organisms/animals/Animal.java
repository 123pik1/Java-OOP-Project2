package world.organisms.animals;

import world.organisms.Organism;
import world.World;
import world.enumsAndStructs.Species;
import world.enumsAndStructs.Type;
import world.enumsAndStructs.twoInts;

import java.awt.Color;

public abstract class Animal extends Organism
{

    public Animal(int strength, int initiative, int x, int y, Color color, Species species, World world) {
        super(strength, initiative, x, y, color, Type.ANIMAL, species, world);
    }

    public void action()
    {
        move();
    }
    public twoInts chooseDirection()
    {
        int dir = (int) (Math.random() * 8);
        int counter = 0;
        while (!world.isInBounds(x + directions[dir].x, y + directions[dir].y) && counter < 8)
        {
            dir = (dir + 1) % 8;
            counter++;
        }
        if (counter == 8)
        {
            return new twoInts(0,0);
        }
        twoInts mv = directions[dir];
        return mv;
    }
    public void move()
    {
        twoInts dir=chooseDirection();
        if (dir.x == 0 && dir.y == 0)
        {
            return;
        }
        if (world.isMovePossible(x +dir.x, y + dir.y, this))
        {
            if (world.isOccupied(x + dir.x, y + dir.y))
            {
                Organism collidedOrganism = world.getOrganism(x + dir.x, y + dir.y);
                if (collidedOrganism.getType() == Type.ANIMAL)
                {
                    Animal collidedAnimal = (Animal) collidedOrganism;
                    if (collidedAnimal.runAway())
                    {
                        return;
                    }
                }
                if (collidedOrganism.isAlive())
                    collision(collidedOrganism);
            }
            x += dir.x;
            y += dir.y;
        }

    }

    public void collision(Organism attacker)
    {
        if (attacker.getSpecies() == this.getSpecies())
        {
            reproduce();
        } else
        {
            fight(attacker);
        }

    }

    public void fight(Organism attacker)
    {
        if (attacker.getStrength() > this.strength)
        {
            this.die();
        } else
        {
            attacker.die();
        }
    }

    private void reproduce()
    {
        int dirToReproduce = (int) (Math.random() * 8);
        int counter = 0;
        while (world.isOccupied(x + directions[dirToReproduce].x, y + directions[dirToReproduce].y) && counter < 8)
        {
            dirToReproduce = dirToReproduce + 1 % 8;
            counter++;
        }
        world.addOrganism(newOrganism(x + directions[dirToReproduce].x, y + directions[dirToReproduce].y));
    }

    public boolean runAway()
    {
        return false;
    }

}
