package controller;

import model.Hero;
import model.Villain;
import model.Artifact;
import view.Renderer;

public class InteractionController {
    private InputHandler inputHandler;
    private Renderer renderer;

    public InteractionController(InputHandler inputHandler, Renderer renderer) {
        this.inputHandler = inputHandler;
        this.renderer = renderer;
    }

    public BattleOutcome startBattle(Hero hero, Villain villain) {
        while (true) {
            renderer.renderBattle(hero, villain);
            String choice = inputHandler.getInput();
            
            if (choice.equals("1")) {
                villain.takeDamage(Math.max(hero.getTotalAttack() - villain.getDefense(), 0));
            } else if (choice.equals("2")) {
                double rand = Math.random();
                if (rand < 0.5) {
                    return BattleOutcome.ESCAPE;
                }
            } else {
                continue;
            }

            if (villain.isDead()) {
                return BattleOutcome.WIN;
            }

            hero.takeDamage(Math.max(villain.getAttack() - hero.getTotalDefense(), 0));

            if (hero.isDead()) {
                return BattleOutcome.LOSE;
            }
        }
    }

    public boolean lootPurpose(Hero hero, Artifact artifact) {
        renderer.renderLoot(hero, artifact);
        String choice = inputHandler.getInput();

        if (choice.equals("1")) {
            hero.takeArtifact(artifact);
            return true;
        } else if (choice.equals("2")) {
            return false;
        }
        return false;
    }
}