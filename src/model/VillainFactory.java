package model;

import java.util.Random;

public class VillainFactory {
    private Random random;

    public VillainFactory() {
        this.random = new Random();
    }

    private int applyVariation(int baseStat) {
        double variation = 1 + (random.nextDouble() * 0.2 - 0.1);
        return (int) (baseStat * variation);
    }

    private Stats getRandomStats(Stats stats) {
        int health = applyVariation(stats.getHitPoints());
        int attack = applyVariation(stats.getAttack());
        int defense = applyVariation(stats.getDefense());

        health = Math.max(1, health);
        attack = Math.max(1, attack);
        defense = Math.max(1, defense);
        
        return new Stats(attack, defense, health);
    }

    public Villain createVillain(Hero hero) {
        return new Villain(getRandomStats(hero.getStats()));
    }
}
