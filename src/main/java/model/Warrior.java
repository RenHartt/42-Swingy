package model;

public class Warrior extends Hero {
    public Warrior() {
        super("Warrior");
        this.stats = new Stats(10, 5, 50);
        this.stuff = new Stuff(new Weapon(10), new Armor(5), new Helm(20));
    }
}