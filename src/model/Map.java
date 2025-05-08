public class Cell {
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

    public Map(Hero hero) {
        this.hero = hero;
        this.size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        this.cells = new Cell[size][size];
    }

    public Cell getCell(int x, int y) { return cells[x][y]; }
    public getSize() { return size; }

    public void setCell(int x, int y, Type type) { cells[x][y].setType(type); }

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
        
    }
}