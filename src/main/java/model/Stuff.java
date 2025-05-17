package model;

import java.io.Serializable;

public class Stuff implements Serializable {
    private Weapon weapon;
    private Armor armor;
    private Helm helm;
    private int potions;

    public Stuff(Weapon weapon, Armor armor, Helm helm) {
        this.weapon = weapon;
        this.armor = armor;
        this.helm = helm;
        this.potions = 3;
    }

    public void addArtifact(Artifact artifact) {
        if (artifact instanceof Weapon) {
            this.weapon = (Weapon)artifact;
        } else if (artifact instanceof Armor) {
            this.armor = (Armor)artifact;
        } else if (artifact instanceof Helm) {
            this.helm = (Helm)artifact;
        } else if (artifact instanceof Potion) {
            this.potions++;
        }
    }

    public void usePotion() {
        if (this.potions > 0) {
            this.potions--;
        }
    }

    public Weapon getWeapon() { return this.weapon; }
    public Armor getArmor() { return this.armor; }
    public Helm getHelm() { return this.helm; }
    public int getPotions() { return this.potions; }
}