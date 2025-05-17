package model;

import java.util.Random;

public class VillainFactory {
    private Random random;

    public VillainFactory() {
        this.random = new Random();
    }

    private int applyVariation(int baseStat) {
        double factor = 0.9 + random.nextDouble() * 0.2;
        return Math.max(1, (int)Math.round(baseStat * factor));
    }    

    private Stats getRandomStats(Hero hero) {
        int health = applyVariation(hero.getTotalHitPoints());
        int attack = applyVariation(hero.getTotalAttack());
        int defense = applyVariation(hero.getTotalDefense());

        health = Math.max(1, health);
        attack = Math.max(1, attack);
        defense = Math.max(1, defense);
        
        return new Stats(attack, defense, health);
    }

    public Villain createVillain(Hero hero) {
        return new Villain(getRandomStats(hero));
    }

    public Artifact randomArtifact(Hero hero) {
        int choice = (int) (Math.random() * 6);
        int bonus;
        switch (choice) {
            case 0:
                bonus = applyVariation(hero.getBonusAttack());
                return new Weapon(bonus);
            case 1:
                bonus = applyVariation(hero.getBonusDefense());
                return new Armor(bonus);
            case 2:
                bonus = applyVariation(hero.getBonusHitPoints());
                return new Helm(bonus);
            default:
                return new Potion();
        }
    }
}
