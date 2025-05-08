public class Stuff {
    private Weapon weapon;
    private Armor armor;
    private Helm helm;

    public Stuff(Weapon weapon, Armor armor, Helm helm) {
        this.weapon = weapon;
        this.armor = armor;
        this.helm = helm;
    }

    public void addArtifact(Artifact artifact) {
        if (artifact instanceof Weapon) {
            this.weapon = (Weapon)artifact;
        } else if (artifact instanceof Armor) {
            this.armor = (Armor)artifact;
        } else if (artifact instanceof Helm) {
            this.helm = (Helm)artifact;
        } else {
            throw new IllegalArgumentException("Unknown artifact type: " + artifact.getClass().getName());
        }
    }

    public Weapon getWeapon() { return this.weapon; }
    public Armor getArmor() { return this.armor; }
    public Helm getHelm() { return this.helm; }
}

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

public abstract class Hero extends Entity {
    protected Stats stats;
    protected Stuff stuff;

    protected int level = 1;
    protected int experience;

    public Hero(String name) {
        super(name);
    }

    public int getTotalAttack() { return this.stats.getAttack() + (this.stuff.getWeapon() != null ? this.stuff.getWeapon().getBonus() : 0); }
    public int getTotalDefense() { return this.stats.getDefense() + (this.stuff.getArmor() != null ? this.stuff.getArmor().getBonus() : 0); }
    public int getTotalHitPoints() { return this.stats.getHitPoints() + (this.stuff.getHelm() != null ? this.stuff.getHelm().getBonus() : 0); }
    public int getLevel() { return this.level; }
    public int getExperience() { return this.experience; }

    public void setLevel(int level) { this.level = level; }
    public void setExperience(int experience) { this.experience = experience; }
}

public class Warrior extends Hero {
    public Warrior() {
        super("Warrior");
        this.stats = new Stats(15, 10, 150);
        this.stuff = new Stuff(new Weapon(10), new Armor(5), new Helm(20));
    }
}

public class Wizard extends Hero {
    public Wizard() {
        super("Wizard");
        this.stats = new Stats(20, 5, 100);
        this.stuff = new Stuff(new Weapon(15), new Armor(5), new Helm(5));
    }
}