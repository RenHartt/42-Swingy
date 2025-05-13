package model;

public abstract class Hero extends Entity {
    protected Stats stats;
    protected Stuff stuff;

    protected int level = 1;
    protected int experience;

    public Hero(String name) {
        super(name);
    }

    public Stats getStats() { return this.stats; }
    public int getTotalAttack() { return this.stats.getAttack() + (this.stuff.getWeapon() != null ? this.stuff.getWeapon().getBonus() : 0); }
    public int getTotalDefense() { return this.stats.getDefense() + (this.stuff.getArmor() != null ? this.stuff.getArmor().getBonus() : 0); }
    public int getTotalHitPoints() { return this.stats.getHitPoints() + (this.stuff.getHelm() != null ? this.stuff.getHelm().getBonus() : 0); }
    public int getLevel() { return this.level; }
    public int getExperience() { return this.experience; }

    public void setLevel(int level) { this.level = level; }
    public void setExperience(int experience) { this.experience = experience; }
}