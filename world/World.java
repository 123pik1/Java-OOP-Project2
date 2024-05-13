package world;

import java.util.ArrayList;

import world.organisms.Organism;
import world.organisms.animals.species.Wolf;
import javax.swing.*;

public class World
{

    private int width;
    private int height;
    private int turn;
    private ArrayList<Organism> organisms = new ArrayList<>();
    private boolean hexagonal;
    private JFrame window = new JFrame();

    public static void main(String[] args)
    {
        World world = new World(20, 20);
        world.mainloop();
    }

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.turn = 0;
        this.hexagonal = false;
        this.window.setSize(1500, 800);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
    }

    private void mainloop()
    {
        organisms.add(new Wolf(1, 1, this));
        actTurn();
    }

    private void actTurn()
    {
        int nmbOfOrganisms = organisms.size();
        for (int i = 0; i < nmbOfOrganisms; i++)
        {
            organisms.get(i).action();
        }
        turn++;
        for (int i = 0; i < nmbOfOrganisms; i++)
        {
            if (!organisms.get(i).isAlive())
            {
                organisms.remove(i);
                i--;
                nmbOfOrganisms--;
            }
        }
        drawWorld();
    }

    public void addOrganism(Organism organism)
    {
        organisms.add(organism);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean isMovePossible(int x, int y, Organism movingOrganism)
    {
        if (x < 0 || x >= width || y < 0 || y >= height)
        {
            return false;
        }
        for (Organism organism : organisms)
        {
            if (organism.getX() == x && organism.getY() == y)
            {
                return organism.isMoveBlocked(movingOrganism);
            }
        }
        return true;
    }

    public boolean isHexagonal()
    {
        return hexagonal;
    }

    public boolean isOccupied(int x, int y)
    {
        for (Organism organism : organisms)
        {
            if (organism.getX() == x && organism.getY() == y && organism.isAlive())
            {
                return true;
            }
        }
        return false;
    }

    private void drawWorld()
    {

    }
    public boolean isInBounds(int x, int y)
    {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public Organism getOrganism(int x, int y)
    {
        for (Organism organism : organisms)
        {
            if (organism.getX() == x && organism.getY() == y)
            {
                return organism;
            }
        }
        return null;
    }
    public JFrame getWindowFrame()
    {
        return window;
    }
}
