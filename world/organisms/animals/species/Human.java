package world.organisms.animals.species;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import world.World;
import world.enumsAndStructs.Species;
import world.enumsAndStructs.twoInts;
import world.organisms.Organism;
import world.organisms.animals.Animal;

public class Human extends Animal
{
    private int cooldown;
    private twoInts dirHum = new twoInts(1, 0);

    public Human(int x, int y, World world) {
        super(5, 4, x, y, new Color(0, 0, 0), Species.HUMAN, world);
        cooldown = 0;

        
        

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
            strength--;
        }
    }

    public void ability()
    {
        regenerate();
    }

    public twoInts chooseDirection()
    {
        return this.dirHum;
    }

    public void useAbility()
    {
        if (cooldown == 0)
        {
            world.addLog("Human used ability");
            strength = 10;
        }
    }

    public void setCooldown(int cooldown)
    {
        this.cooldown = cooldown;
    }

    @Override
    public String getSaveString()
    {
        return super.getSaveString() + " " + cooldown;
    }

    public void goUP()
    {
        dirHum = new twoInts(0, -1);
    }

    public void goDOWN()
    {
        dirHum = new twoInts(0, 1);
    }

    public void goLEFT()
    {
        dirHum = new twoInts(-1, 0);
    }

    public void goRIGHT()
    {
        dirHum = new twoInts(1, 0);
    }

    private void goUpLeft()
    {
        dirHum = new twoInts(-1, -1);
    }

    private void goUpRight()
    {
        dirHum = new twoInts(1, -1);
    }

    private void goDowneft()
    {
        dirHum = new twoInts(-1, 1);
    }

    private void goDownRight()
    {
        dirHum = new twoInts(1, 1);
    }

    public void draw(JPanel map)
    {
        super.draw(map);
        JInternalFrame humanFrame = new JInternalFrame("Human", true, false, false, false);
        humanFrame.setBounds(420, 520, 410, 200);
        humanFrame.setVisible(true);
        humanFrame.setLayout(null);
        JButton leftUpButton = new JButton("LEFT UP");
        JButton upButton = new JButton("UP");
        JButton rightUpButton = new JButton("RIGHT UP");
        JButton downButton = new JButton("DOWN");
        JButton leftButton = new JButton("LEFT");
        JButton rightButton = new JButton("RIGHT");
        JButton downLeftButton = new JButton("DOWN LEFT");
        JButton downRightButton = new JButton("DOWN RIGHT");
        JButton abilityButton = new JButton("Use ability");

        leftUpButton.setBounds(10, 0, 150, 40);
        upButton.setBounds(160, 0, 80, 40);
        rightUpButton.setBounds(240, 0, 150, 40);
        downButton.setBounds(160, 80, 80, 40);
        leftButton.setBounds(10, 40, 80, 40);
        downLeftButton.setBounds(10, 80, 150, 40);
        downRightButton.setBounds(240, 80, 150, 40);
        rightButton.setBounds(310, 40, 80, 40);

        leftUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goUpLeft();
            }
        });
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goUP();
            }
        });
        rightUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goUpRight();
            }
        });
        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goDOWN();

            }
        });
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goLEFT();

            }
        });
        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goRIGHT();

            }
        });
        downLeftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goDowneft();
            }
        });
        downRightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goDownRight();
            }
        });

        abilityButton.addActionListener(e ->
        {
            useAbility();
        });
        abilityButton.setBounds(10, 130, 380, 20);

        humanFrame.add(upButton);
        humanFrame.add(leftUpButton);
        humanFrame.add(abilityButton);
        humanFrame.add(downRightButton);
        humanFrame.add(downLeftButton);
        humanFrame.add(rightButton);
        humanFrame.add(downButton);
        humanFrame.add(leftButton);
        humanFrame.add(rightUpButton);

        humanFrame.setVisible(true);

        world.getWindowFrame().add(humanFrame);
    }

    public void reproduce()
    {
    }
    public twoInts getDir()
    {
        return dirHum;
    }
}
