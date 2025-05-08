public abstract class Artifact {
    protected String name;
    protected int bonus;

    public Artifact(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return this.name;
    }

    public int getBonus() {
        return this.bonus;
    }
}

public class Weapon extends Artifact {
    public Weapon(String name, int bonus) {
        super(name, bonus);
    }
}

public class Armor extends Artifact {
    public Armor(String name, int bonus) {
        super(name, bonus);
    }
}

public class Helm extends Artifact {
    public Helm(String name, int bonus) {
        super(name, bonus);
    }
}