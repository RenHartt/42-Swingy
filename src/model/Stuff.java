package model;

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