package model;

public class Wizard extends Hero {
    public Wizard() {
        super("Wizard");
        this.stats = new Stats(15, 5, 30);
        this.stuff = new Stuff(new Weapon(15), new Armor(5), new Helm(5));
    }
}