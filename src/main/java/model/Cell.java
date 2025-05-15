package model;

public class Cell {
    private Hero hero;
    private Villain villain;
    private Artifact artifact;

    public Cell() {}

    public Hero getHero() { return hero; }
    public Villain getVillain() { return villain; }
    public Artifact getArtifact() { return artifact; }
    public void setHero(Hero hero) { this.hero = hero; }
    public void setVillain(Villain villain) { this.villain = villain; }
    public void setArtifact(Artifact artifact) { this.artifact = artifact; }
}