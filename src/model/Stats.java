package model;

public class Stats {
    private int attack;
    private int defense;
    private int hitPoints;

    public Stats(int attack, int defense, int hitPoints) {
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }
    
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }

    public int getAttack() { return this.attack; }
    public int getDefense() { return this.defense; }
    public int getHitPoints() { return this.hitPoints; }
}