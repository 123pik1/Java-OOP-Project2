package world;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import world.organisms.Organism;
import world.organisms.animals.species.*;
import world.organisms.plants.species.*;
import javax.swing.*;

public class World
{

    private int width;
    private int height;
    private int turn;
    private ArrayList<Organism> organisms = new ArrayList<>();
    private boolean hexagonal;
    private JFrame window = new JFrame();

    public static void main(String[] args) throws IOException
    {
        try
        {
            World world = new World();
            world.mainloop();
        } finally
        {
        }
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

    public World() throws IOException {
        openWorld();
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

    private void readWorld(Scanner scanner) throws IOException
    {
        width = scanner.nextInt();
        height = scanner.nextInt();
        while (scanner.hasNextLine())
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int strength = scanner.nextInt();
            
            int age = scanner.nextInt();
            String species = scanner.next();
            Organism org=null;
            switch (species) {
                case "H":
                    Human hm = new Human(x, y, this);
                    int cooldown = scanner.nextInt();
                    hm.setCooldown(cooldown);
                    org = hm;
                    break;
                case "W":
                    org = new Wolf(x, y, this);
                    break;
                case "S":
                    org = new Sheep(x, y, this);
                    break;
                case "F":
                    org = new Fox(x, y, this);
                    break;
                case "T":
                    org = new Turtle(x, y, this);
                    break;
                case "A":
                    org = new Antelope(x, y, this);
                    break;
                case "G":  
                    org = new Grass(x, y, this);
                    break;
                case "U":
                    org = new Guarana(x, y, this);
                    break;
                case "B":
                    org = new Belladonna(x, y, this);
                    break;
                case "O":
                    org = new SosnowskyHogweed(x, y, this);
                    break;
                case "M":
                    org = new Sonchus(x, y,this);
                    break;

                default:
                    break;
            }
            org.setAge(age);
            org.setStrength(strength);
            organisms.add(org);
        }
    }

    public void openWorld() throws IOException
    {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);
        File file = new File("world.txt");
        try
        {
            Scanner scanner = new Scanner(file);
            readWorld(scanner);
        } catch (FileNotFoundException e)
        {
            System.out.println("Error while opening file");
        }
    }

    public void loadWorld() throws IOException
    {
        File file = new File("saves/save.txt");
        try
        {
            Scanner scanner = new Scanner(file);
            organisms.clear();
            readWorld(scanner);
        } catch (FileNotFoundException e)
        {
            System.out.println("Error while opening file");
        }
    }

    public void saveWorld() throws IOException
    {
        File file = new File("saves/save.txt");
        try
        {
            file.createNewFile();
            Files.write(Paths.get("saves/save.txt"), "".getBytes());
            for (Organism organism : organisms)
            {
                String data = organism.getX() + " " + organism.getY() + " " + organism.getStrength() + " " + organism.getSpecies() + " " + organism.getAge() + "\n";
                Files.write(Paths.get("saves/save.txt"), data.getBytes(), java.nio.file.StandardOpenOption.APPEND);
            }
        } catch (IOException e)
        {
            System.out.println("Error while saving file");
        }
    }
}
