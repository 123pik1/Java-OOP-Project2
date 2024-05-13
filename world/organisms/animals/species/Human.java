package world.organisms.animals.species;

import java.awt.Color;

import world.organisms.animals.Animal;
import world.*;
import world.enumsAndStructs.*;
import world.organisms.*;
import java.awt.event.*;

public class Human extends Animal
{
    private int cooldown;
    private twoInts dir = new twoInts(0, 0);

    public Human(int x, int y, World world) {
        super(5, 4, x, y, new Color(0, 0, 0), Species.HUMAN, world);
    }

    public Organism newOrganism(int x, int y)
    {
        return new Human(x, y, world);
    }

    public void action()
    {
        move();
        ability();
    }

    public void regenerate()
    {
        if (cooldown > 0)
        {
            cooldown--;
        }
    }

    public void ability()
    {
        regenerate();
    }

    public twoInts chooseDirection()
    {
        world.getWindowFrame().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    dir = new twoInts(0, -1);
                    break;
                case KeyEvent.VK_DOWN:
                    dir = new twoInts(0, 1);
                    break;
                case KeyEvent.VK_LEFT:
                    dir = new twoInts(-1, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    dir = new twoInts(1, 0);
                    break;
                }
            }
        });
        return dir;
    }
}
