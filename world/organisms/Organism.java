package world.organisms;

import java.awt.Color;
import world.World;
import world.enumsAndStructs.Species;
import world.enumsAndStructs.Type;
import world.enumsAndStructs.twoInts;

public abstract class Organism
{

    protected int strength;
    protected int initiative;
    protected int age;
    protected int x;
    protected int y;
    protected boolean alive;
    protected Color color;
    protected Type type;
    protected Species species;
    protected World world;
    // non-heexagonal
    protected twoInts[] directions = { new twoInts(0, 1), new twoInts(1, 0), new twoInts(0, -1), new twoInts(-1, 0),
            new twoInts(1, 1), new twoInts(1, -1), new twoInts(-1, 1), new twoInts(-1, -1) };

    public Organism(int strength, int initiative, int x, int y, Color color, Type type, Species species, World world) {
        this.strength = strength;
        this.initiative = initiative;
        this.age = 0;
        this.x = x;
        this.y = y;
        this.alive = true;
        this.color = color;
        this.type = type;
        this.species = species;
        this.world = world;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public int getStrength()
    {
        return strength;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getPosition()
    {
        return x * world.getWidth() + y;
    }
    public Type getType()
    {
        return type;
    }
    
    public boolean isMoveBlocked(Organism attacker)
    {
        return false;
    }
    public void die()
    {
        alive = false;
    }
    public boolean isAlive()
    {
        return alive;
    }
    public Species getSpecies()
    {
        return species;
    }
    public abstract Organism newOrganism(int x, int y);
    
    public abstract void action();
    public abstract void collision(Organism attacker);
}
