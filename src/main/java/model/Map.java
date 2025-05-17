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
    
    public Vector getHeroPosition() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getHero() == hero) {
                    return new Vector(i, j);
                }
            }
        }
        return null;
    }

    public Cell getHeroCell() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getHero() == hero) {
                    return cells[i][j];
                }
            }
        }
        return null;
    }

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

    public boolean moveHero(String direction) {
        Vector HeroPos = getHeroPosition();

        switch (direction) {
            case "w":
                if (HeroPos.x > 0) {
                    cells[HeroPos.x - 1][HeroPos.y].setHero(hero);
                    cells[HeroPos.x][HeroPos.y].setHero(null);
                } else {
                    return false;
                }
                break;
            case "s":
                if (HeroPos.x < size - 1) {
                    cells[HeroPos.x + 1][HeroPos.y].setHero(hero);
                    cells[HeroPos.x][HeroPos.y].setHero(null);
                } else {
                    return false;
                }
                break;
            case "a":
                if (HeroPos.y > 0) {
                    cells[HeroPos.x][HeroPos.y - 1].setHero(hero);
                    cells[HeroPos.x][HeroPos.y].setHero(null);
                } else {
                    return false;
                }
                break;
            case "d":
                if (HeroPos.y < size - 1) {
                    cells[HeroPos.x][HeroPos.y + 1].setHero(hero);
                    cells[HeroPos.x][HeroPos.y].setHero(null);
                } else {
                    return false;
                }
                break;
        }
        return true;
    }
}