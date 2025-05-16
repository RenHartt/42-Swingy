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
    
    public void takeDamage(int damage) { stats.setHitPoints(Math.max(stats.getHitPoints() - damage, 0)); }
    public boolean isDead() { return stats.getHitPoints() == 0; }
}