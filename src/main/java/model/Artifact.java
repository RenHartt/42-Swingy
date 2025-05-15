package model;

public abstract class Artifact extends Entity {
    protected int bonus;

    public Artifact(String name, int bonus) {
        super(name);
        this.bonus = bonus;
    }

    public int getBonus() {
        return this.bonus;
    }
}