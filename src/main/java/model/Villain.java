package model;

public class Villain extends Entity {
    private Stats stats;
    private int xpGain;

    public Villain(Stats stats) {
        super("Villain");
        this.stats = stats;
        this.xpGain = stats.getHitPoints() + stats.getAttack() + stats.getDefense();
    }

    public Stats getStats() { return stats; }
    public int getAttack() { return stats.getAttack(); }
    public int getDefense() { return stats.getDefense(); }
    public int getHitPoints() { return stats.getHitPoints(); }
    public int getXpGain() { return xpGain; }
    
    public void takeDamage(int damage) { stats.setHitPoints(Math.max(stats.getHitPoints() - damage, 0)); }
    public boolean isDead() { return stats.getHitPoints() == 0; }
}