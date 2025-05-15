package model;

public class Cell {
    private Entity entity;

    public Cell(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() { return entity; }
    public void setEntity(Entity entity) { this.entity = entity; }
}