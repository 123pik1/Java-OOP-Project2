package world;

import java.util.Scanner;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import world.organisms.Organism;
import world.organisms.animals.species.*;
import world.organisms.plants.species.*;
import javax.swing.*;
import world.enumsAndStructs.*;

public class World
{

    private int width;
    private int height;
    private int turn;
    private ArrayList<Organism> organisms = new ArrayList<>();
    private boolean hexagonal;
    private JFrame window = new JFrame();
    private ArrayList<String> logs = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        try
        {
            World world = new World();
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
        this.window.setSize(1500, 800);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        openWorld();
        drawWorld();
    }

    private void mainloop()
    {
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
        while (scanner.hasNextLine() && scanner.hasNextInt())
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int strength = scanner.nextInt();

            int age = scanner.nextInt();
            String species = scanner.next();
            Organism org = null;
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
                org = new Sonchus(x, y, this);
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
        File file = new File("saves/world.txt");
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
            turn = scanner.nextInt();
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
            Files.write(Paths.get("saves/save.txt"), (turn + "\n").getBytes(), java.nio.file.StandardOpenOption.APPEND);
            Files.write(Paths.get("saves/save.txt"), (width + " " + height + "\n").getBytes(),
                    java.nio.file.StandardOpenOption.APPEND);
            for (Organism organism : organisms)
            {
                String data = organism.getSaveString() + "\n";
                Files.write(Paths.get("saves/save.txt"), data.getBytes(), java.nio.file.StandardOpenOption.APPEND);
            }
        } catch (IOException e)
        {
            System.out.println("Error while saving file");
        }
    }

    private void drawWorld()
    {
        window.getContentPane().removeAll();
        window.setLayout(null);
        drawMenu();
        drawMap();

        window.repaint();
    }

    private void drawMap()
    {
        JPanel map = new JPanel();
        map.setPreferredSize(new Dimension(500,500));
        map.setBounds(10, 10, 500, 500);
        map.setLayout(null);
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                final int x1 = x;
                final int y1 = y;
                if (isOccupied(x, y))
                {
                    Organism organism = getOrganism(x, y);
                    organism.draw(map);
                } else
                {
                    JButton button = new JButton();
                    button.setBounds(x * 15 + 10, y * 15 + 10, 15, 15);
                    button.setVisible(true);
                    button.addActionListener(e ->
                    {
                        addNewOrganism(y1, x1);
                    });
                    map.add(button);
                }
            }
        }
        map.setVisible(true);
        window.add(map);
    }

    private void addNewOrganism(int y, int x)
    {
        JFrame chooseOrganism = new JFrame();
        chooseOrganism.setSize(340, 300);
        chooseOrganism.setLayout(null);

        JButton sheepButton = new JButton();
        JButton sonchusButton = new JButton();
        JButton wolfButton = new JButton();
        JButton foxButton = new JButton();
        JButton sosnowskyHogweedButton = new JButton();
        JButton turtleButton = new JButton();
        JButton antelopeButton = new JButton();
        JButton grassButton = new JButton();
        JButton guaranaButton = new JButton();
        JButton belladonnaButton = new JButton();

        sheepButton.setBounds(20, 20, 300, 20);
        sonchusButton.setBounds(20, 200, 300, 20);
        wolfButton.setBounds(20, 40, 300, 20);
        foxButton.setBounds(20, 60, 300, 20);
        sosnowskyHogweedButton.setBounds(20, 180, 300, 20);
        turtleButton.setBounds(20, 80, 300, 20);
        antelopeButton.setBounds(20, 100, 300, 20);
        grassButton.setBounds(20, 120, 300, 20);
        guaranaButton.setBounds(20, 140, 300, 20);
        belladonnaButton.setBounds(20, 160, 300, 20);

        sheepButton.setText("Sheep");
        sonchusButton.setText("Sonchus");
        wolfButton.setText("Wolf");
        foxButton.setText("Fox");
        sosnowskyHogweedButton.setText("Sosnowsky Hogweed");
        turtleButton.setText("Turtle");
        antelopeButton.setText("Antelope");
        grassButton.setText("Grass");
        guaranaButton.setText("Guarana");
        belladonnaButton.setText("Belladonna");

        sheepButton.addActionListener(e ->
        {
            addOrganism(new Sheep(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        wolfButton.addActionListener(e ->
        {
            addOrganism(new Wolf(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        foxButton.addActionListener(e ->
        {
            addOrganism(new Fox(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        turtleButton.addActionListener(e ->
        {
            addOrganism(new Turtle(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        antelopeButton.addActionListener(e ->
        {
            addOrganism(new Antelope(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        grassButton.addActionListener(e ->
        {
            addOrganism(new Grass(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        guaranaButton.addActionListener(e ->
        {
            addOrganism(new Guarana(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        belladonnaButton.addActionListener(e ->
        {
            addOrganism(new Belladonna(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });
        sosnowskyHogweedButton.addActionListener(e ->
        {
            addOrganism(new SosnowskyHogweed(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });

        sonchusButton.addActionListener(e ->
        {
            addOrganism(new Sonchus(x, y, this));
            chooseOrganism.dispose();
            drawWorld();
        });

        chooseOrganism.add(sosnowskyHogweedButton);
        chooseOrganism.add(turtleButton);
        chooseOrganism.add(belladonnaButton);
        chooseOrganism.add(foxButton);
        chooseOrganism.add(wolfButton);
        chooseOrganism.add(sheepButton);
        chooseOrganism.add(sonchusButton);
        chooseOrganism.add(guaranaButton);
        chooseOrganism.add(grassButton);
        chooseOrganism.add(antelopeButton);

        chooseOrganism.setTitle("Choose organism");
        chooseOrganism.setVisible(true);

    }

    private Organism findHuman()
    {
        for (Organism org : organisms)
        {
            if (org.getSpecies() == Species.HUMAN)
                return org;
        }
        return null;
    }

    private void drawMenu()
    {
        JInternalFrame menuBar = new JInternalFrame();
        menuBar.setLayout(null);
        menuBar.setResizable(true);
        menuBar.setClosable(false);
        menuBar.setBounds(0, 520, 250, 200);

        JButton nextTurnButton = new JButton("Next turn");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        nextTurnButton.setBounds(10, 40, 210, 20);
        saveButton.setBounds(10, 70, 100, 20);
        loadButton.setBounds(120, 70, 100, 20);

        nextTurnButton.addActionListener(e ->
        {
            actTurn();
        });

        saveButton.addActionListener(e ->
        {
            try
            {
                saveWorld();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        });

        loadButton.addActionListener(e ->
        {
            try
            {
                loadWorld();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
            drawWorld();
        });

        menuBar.add(loadButton);
        menuBar.add(saveButton);
        menuBar.add(nextTurnButton);
        menuBar.setVisible(true);

        JLabel turnLabel = new JLabel();
        JLabel logLabel = new JLabel();

        turnLabel.setText("Turn: " + turn);
        turnLabel.setBounds(10, 100, 100, 20);

        logLabel.setBounds(10, 130, 200, 20);
        if (!logs.isEmpty())
        {
            int nmbOfLog = (int) Math.random() * logs.size();
            logLabel.setText(logs.get(nmbOfLog));
        }

        menuBar.add(turnLabel);
        menuBar.add(logLabel);
        window.add(menuBar);
    }

    public void addLog(String log)
    {
        logs.add(log);
    }
}