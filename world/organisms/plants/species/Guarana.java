package world.organisms.plants.species;

import world.World;
import world.enumsAndStructs.Species;
import world.organisms.Organism;
import world.organisms.plants.Plant;
import java.awt.Color;

public class Guarana extends Plant
{
    public Guarana (int x, int y, World world)
    {
        super(0,x,y, Color.RED, Species.GUARANA, world);
    }
    public Organism newOrganism(int x, int y)
    {
        return new Guarana(x, y, world);
    }
    public void collision(Organism attacker)
    {
        attacker.setStrength(attacker.getStrength() + 3);
        this.die();
    }
}
