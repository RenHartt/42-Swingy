package model;

public abstract class Hero extends Entity {
    protected Stats stats;
    protected Stuff stuff;

    protected int level = 1;
    protected int experience = 0;
    protected int currentHitPoints;
    protected int maxHitPoints;

    public Hero(String name) {
        super(name);
    }

    public Stats getStats() { return this.stats; }
    public int getAttack() { return this.stats.getAttack(); }
    public int getDefense() { return this.stats.getDefense(); }
    public int getHitPoints() { return this.stats.getHitPoints(); }
    public int getBonusAttack() { return (this.stuff.getWeapon() != null ? this.stuff.getWeapon().getBonus() : 0); }
    public int getBonusDefense() { return (this.stuff.getArmor() != null ? this.stuff.getArmor().getBonus() : 0); }
    public int getBonusHitPoints() { return (this.stuff.getHelm() != null ? this.stuff.getHelm().getBonus() : 0); }
    public int getTotalAttack() { return this.stats.getAttack() + (this.stuff.getWeapon() != null ? this.stuff.getWeapon().getBonus() : 0); }
    public int getTotalDefense() { return this.stats.getDefense() + (this.stuff.getArmor() != null ? this.stuff.getArmor().getBonus() : 0); }
    public int getTotalHitPoints() { return this.stats.getHitPoints() + (this.stuff.getHelm() != null ? this.stuff.getHelm().getBonus() : 0); }
    public int getCurrentHitPoints() { return this.currentHitPoints; }
    public int getMaxHitPoints() { return this.maxHitPoints; }
    public int getLevel() { return this.level; }
    public int getExperience() { return this.experience; }
    public int getXpToLevelUp() { return (int) ((this.level * 1000) + Math.pow(this.level - 1, 2) * 450); }
    public String getWeaponName() { return (this.stuff.getWeapon() != null ? this.stuff.getWeapon().getName() : ""); }
    public String getArmorName() { return (this.stuff.getArmor() != null ? this.stuff.getArmor().getName() : ""); }
    public String getHelmName() { return (this.stuff.getHelm() != null ? this.stuff.getHelm().getName() : ""); }
    public int getPotionCount() { return this.stuff.getPotions(); }

    public void takeArtifact(Artifact artifact) {
        stuff.addArtifact(artifact);
        this.maxHitPoints = getHitPoints() + getBonusHitPoints();
    }

    public void increaseExperience(int experience) {
        this.experience += experience;
        while (this.experience > getXpToLevelUp()) {
            this.experience -= getXpToLevelUp();
            this.level++;
            this.currentHitPoints = getTotalHitPoints();
        }
    }

    public void heal() {
        this.currentHitPoints = this.maxHitPoints;
        this.stuff.usePotion();
    }

    public void takeDamage(int damage) { this.currentHitPoints = Math.max(this.currentHitPoints - damage, 0); }
    public boolean isDead() { return this.currentHitPoints == 0; }
}