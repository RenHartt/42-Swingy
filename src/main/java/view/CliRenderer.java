package view;

import model.Map;
import model.Hero;
import model.Villain;
import model.Artifact;

public class CliRenderer implements Renderer {
    @Override
    public void cleanRender() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void renderMenu() {
        cleanRender();
        System.out.println("1. Continue");
        System.out.println("2. Save Game");
        System.out.println("3. Exit");
    }

    @Override
    public void renderStartMenu() {
        cleanRender();
        System.out.println("Welcome to the game!");
        System.out.println("1. Start new Game");
        System.out.println("2. Load Game");
    }

    @Override
    public void renderHeroCreation() {
        cleanRender();
        System.out.println("Create your hero!");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
    }

    @Override
    public void renderLoadHero() {
        cleanRender();
        System.out.println("Load your hero!");
        System.out.println("1. Hero 1");
        System.out.println("2. Hero 2");
        // Need to implement loading logic
    }

    @Override
    public void renderMap(Map map) {
        cleanRender();
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if (map.getCell(i, j).getEntity() != null) {
                    System.out.print(map.getCell(i, j).getEntity().getName().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void renderFight(Hero hero, Villain villain) {
        cleanRender();
        System.out.println("Fight!");
        System.out.println("Your hero: | Enemy: ");
        System.out.println(hero.getName() + " | " + villain.getName());
        System.out.println("HitPoint: " + hero.getHitPoints() + " | HitPoint: " + villain.getHitPoints());
        System.out.println("Attack: " + hero.getAttack() + " | Attack: " + villain.getAttack());
        System.out.println("Defend: " + hero.getDefense() + " | Defend: " + villain.getDefense());
        System.out.println("1. Attack");
        System.out.println("2. Escape");
    }

    @Override
    public void renderDefeat() {
        cleanRender();
        System.out.println("You have been defeated!");
        System.out.println("Game Over");
    }

    @Override
    public void renderVictory() {
        cleanRender();
        System.out.println("You have won the battle!");
        System.out.println("Congratulations!");
    }

    @Override
    public void renderLoot(Artifact artifact) {
        cleanRender();
        System.out.println("You have found an artifact!");
        System.out.println("Type: " + artifact.getClass().getSimpleName());
        System.out.println("Bonus: " + artifact.getBonus());
        System.out.println("1. Take it");
        System.out.println("2. Leave it");
    }

    @Override
    public void renderLevelUp(Hero hero) {
        cleanRender();
        System.out.println("Congratulations! You leveled up!");
        System.out.println("New Level: " + hero.getLevel());
        System.out.println("HitPoints: " + hero.getHitPoints());
        System.out.println("Attack: " + hero.getAttack());
        System.out.println("Defense: " + hero.getDefense());
        System.out.println("Select a stat to increase:");
        System.out.println("1. Attack");
        System.out.println("2. Defense");
        System.out.println("3. HitPoints");
    }

    @Override
    public void close() {
        cleanRender();
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}