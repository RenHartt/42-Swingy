package model;

public class Villain extends Entity {
    private Stats stats;

    public Villain(Stats stats) {
        super("Villain");
        this.stats = stats;
    }

    public Stats getStats() { return stats; }
    public int getAttack() { return stats.getAttack(); }
    public int getDefense() { return stats.getDefense(); }
    public int getHitPoints() { return stats.getHitPoints(); }
}