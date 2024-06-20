package world.organisms.plants;

import world.organisms.Organism;
import world.enumsAndStructs.*;
import java.awt.Color; 
import world.*;

public abstract class Plant extends Organism
{
    public Plant(int strength, int x, int y, Color color, Species species, World world) {
        super(strength, 0, x, y, color, Type.PLANT, species, world);
    }

    public void action()
    {
        int dir = (int) (Math.random() * (8+20));
        if (dir < 8)
        {
            int newX = x + directions[dir].x;
            int newY = y + directions[dir].y;
            if (world.isInBounds(newX, newY) && world.getOrganism(newX, newY) == null)
            {
                world.addOrganism(newOrganism(newX, newY));
                world.addLog(this.species.getName() + "has spreaded");
            }
        }
    }
    

    public void collision(Organism attacker)
    {
        this.die();
        world.addLog(attacker.getSpecies() + " ate " + this.getSpecies() );
    }
}
