package view;

import java.util.List;

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
        System.out.println("1. Character");
        System.out.println("2. Continue");
        System.out.println("3. Save Game");
        System.out.println("4. Menu");
        System.out.println("5. Exit");
    }

    @Override
    public void renderStartMenu() {
        cleanRender();
        System.out.println("Welcome to the game!");
        System.out.println("1. Start new Game");
        System.out.println("2. Load Game");
    }

    @Override
    public void renderCharactereMenu(Hero hero) {
        cleanRender();
        System.out.println("Name: " + hero.getName());
        System.out.println();
        System.out.println("Level: " + hero.getLevel());
        System.out.println("XP: " + hero.getExperience() + " / " + hero.getXpToLevelUp());
        System.out.println("Current Hit Points: " + hero.getCurrentHitPoints() + " / " + hero.getMaxHitPoints());
        System.out.println();
        System.out.println("Attack: " + hero.getAttack() + " + " + hero.getBonusAttack() + " -> " + hero.getWeaponName());
        System.out.println("Defense: " + hero.getDefense() + " + " + hero.getBonusDefense() + " -> " + hero.getArmorName());
        System.out.println("Hit points: " + hero.getHitPoints() + " + " + hero.getBonusHitPoints() + " -> " + hero.getHelmName());
        System.out.println();
        System.out.println("Potion: " + hero.getPotionCount());
        System.out.println();
        System.out.println("1. Use Potion");
        System.out.println("2. Back to Menu");
    }

    @Override
    public void renderHeroCreation() {
        cleanRender();
        System.out.println("Create your hero!");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
    }

    @Override
    public void renderLoadHero(List<String> saves) {
        cleanRender();
        if (saves.size() > 0) {
            System.out.println("Load your hero!");
            for (int i = 0; i < saves.size(); i++) {
                System.out.println((i + 1) + ". " + saves.get(i));
            }
        } else {
            System.out.println("No save to load.");
            System.out.println("1. Create new Hero");
        }
    }

    @Override
    public void renderMap(Map map) {
        cleanRender();
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if (map.getCell(i, j).getHero() != null) {
                    System.out.print(map.getCell(i, j).getHero().getName().charAt(0) + " ");
                } else if (map.getCell(i, j).getVillain() != null) {
                    System.out.print(map.getCell(i, j).getVillain().getName().charAt(0) + " ");
                } else if (map.getCell(i, j).getArtifact() != null) {
                    System.out.print(map.getCell(i, j).getArtifact().getName().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void renderBattle(Hero hero, Villain villain) {
        cleanRender();
        System.out.println("Fight!");
        System.out.println("Your hero: | Enemy: ");
        System.out.println(hero.getName() + " | " + villain.getName());
        System.out.println("HitPoint: " + hero.getCurrentHitPoints() + " | HitPoint: " + villain.getHitPoints());
        System.out.println("Attack: " + hero.getTotalAttack() + " | Attack: " + villain.getAttack());
        System.out.println("Defend: " + hero.getTotalDefense() + " | Defend: " + villain.getDefense());
        System.out.println("1. Attack");
        System.out.println("2. Escape");
    }

    @Override
    public void renderDefeat() {
        cleanRender();
        System.out.println("You have been defeated!");
        System.out.println("Game Over");
        System.out.println("1. Continue");
    }

    @Override
    public void renderVictory() {
        cleanRender();
        System.out.println("You have won the battle!");
        System.out.println("Congratulations!");
        System.out.println("1. Continue");
    }

    @Override
    public void renderLoot(Hero hero, Artifact artifact) {
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