package model;

import java.util.Random;

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

    public void initMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void initHero() {
        cells[size / 2][size / 2].setHero(hero);
    }

    public void initVillain() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getHero() == null && random.nextInt(10) == 0) {
                    cells[i][j].setVillain(villainFactory.createVillain(hero));
                }
            }
        }        
    }

    public void moveHero(String direction) {
        int x = size / 2;
        int y = size / 2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getHero() == hero) {
                    x = i;
                    y = j;
                }
            }
        }

        switch (direction) {
            case "w":
                if (x > 0) {
                    cells[x - 1][y].setHero(hero);
                    cells[x][y].setHero(null);
                }
                break;
            case "s":
                if (x < size - 1) {
                    cells[x + 1][y].setHero(hero);
                    cells[x][y].setHero(null);
                }
                break;
            case "a":
                if (y > 0) {
                    cells[x][y - 1].setHero(hero);
                    cells[x][y].setHero(null);
                }
                break;
            case "d":
                if (y < size - 1) {
                    cells[x][y + 1].setHero(hero);
                    cells[x][y].setHero(null);
                }
                break;
        }

    }
}