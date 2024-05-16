package world.organisms.animals.species;

import world.organisms.Organism;
import world.organisms.animals.Animal;
import world.enumsAndStructs.*;
import world.World;

public class Fox extends Animal
{
    public Fox(int x, int y, World world) {
        super(3, 7, x, y, java.awt.Color.ORANGE, Species.FOX, world);
    }

    public Organism newOrganism(int x, int y)
    {
        return new Fox(x, y, world);
    }

    public twoInts chooseDirection()
    {
        int dir = (int) (Math.random() * 8);
        int counter = 0;
        while (!world.isInBounds(x + directions[dir].x, y + directions[dir].y) && counter < 8
                && !isStronger(x + directions[dir].x, y + directions[dir].y))
        {
            dir = (dir + 1) % 8;
            counter++;
        }
        if (counter == 8)
        {
            return new twoInts(0, 0);
        }
        twoInts mv = directions[dir];
        return mv;
    }

    public boolean isStronger(int localX, int localY)
    {
        return (this.strength >= world.getOrganism(localX, localY).getStrength());
    }
}

