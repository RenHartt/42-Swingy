package model;

public class Warrior extends Hero {
    public Warrior() {
        super("Warrior");
        this.stats = new Stats(15, 10, 150);
        this.stuff = new Stuff(new Weapon(10), new Armor(5), new Helm(20));
    }
}