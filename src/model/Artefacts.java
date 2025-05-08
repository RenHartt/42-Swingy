public abstract class Artifact extends Entity {
    protected String name;
    protected int bonus;

    public Artifact(String name, int bonus) {
        super(name);
        this.bonus = bonus;
    }

    public int getBonus() {
        return this.bonus;
    }
}

public class Weapon extends Artifact {
    public Weapon(int bonus) {
        super("Weapon", bonus);
    }
}

public class Armor extends Artifact {
    public Armor(int bonus) {
        super("Armor", bonus);
    }
}

public class Helm extends Artifact {
    public Helm(int bonus) {
        super("Helm", bonus);
    }
}