package model;

import java.util.Random;

class Cell {
    private Entity entity;

    public Cell(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() { return entity; }
    public void setEntity(Entity entity) { this.entity = entity; }
}

public class Map {
    private int size;
    private Cell[][] cells;
    private Hero hero;
    private Random random;
    private VillainFactory villainFactory;

    public Map(Hero hero) {
        this.hero = hero;
        this.size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        this.cells = new Cell[size][size];
        this.random = new Random();
        this.villainFactory = new VillainFactory();
        initMap();
        initHero();
        initVillain();
    }

    public Cell getCell(int x, int y) { return cells[x][y]; }
    public int getSize() { return size; }

    public void setCell(int x, int y, Entity entity) { cells[x][y].setEntity(entity); }

    public void initMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(null);
            }
        }
    }

    public void initHero() {
        cells[size / 2][size / 2] = new Cell(hero);
    }

    public void initVillain() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getEntity() == null && random.nextInt(10) == 0) {
                    cells[i][j] = new Cell(villainFactory.createVillain(hero));
                }
            }
        }        
    }

    public void moveHero(String direction) {
        int x = size / 2;
        int y = size / 2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getEntity() == hero) {
                    x = i;
                    y = j;
                }
            }
        }

        switch (direction) {
            case "w":
                if (x > 0) {
                    cells[x - 1][y].setEntity(hero);
                    cells[x][y].setEntity(null);
                }
                break;
            case "s":
                if (x < size - 1) {
                    cells[x + 1][y].setEntity(hero);
                    cells[x][y].setEntity(null);
                }
                break;
            case "a":
                if (y > 0) {
                    cells[x][y - 1].setEntity(hero);
                    cells[x][y].setEntity(null);
                }
                break;
            case "d":
                if (y < size - 1) {
                    cells[x][y + 1].setEntity(hero);
                    cells[x][y].setEntity(null);
                }
                break;
        }

    }

    public void printMap() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getEntity() != null) {
                    System.out.print(cells[i][j].getEntity().getName().charAt(0) + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}