package model;

public class Wizard extends Hero {
    public Wizard() {
        super("Wizard");
        this.stats = new Stats(20, 5, 100);
        this.stuff = new Stuff(new Weapon(15), new Armor(5), new Helm(5));
    }
}