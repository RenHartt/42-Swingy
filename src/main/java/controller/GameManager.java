package controller;

import java.util.List;

import model.*;
import view.*;

public class GameManager {
    private Map map;
    private Hero hero;
    private PlayerController playerController;
    private InputHandler inputHandler;
    private Renderer renderer;
    private InteractionController interactionController;
    private VillainFactory factory;

    public GameManager(InputHandler inputHandler, Renderer renderer) {
        this.inputHandler = inputHandler;
        this.renderer = renderer;
        this.interactionController = new InteractionController(inputHandler, renderer);
        this.factory = new VillainFactory();
    }

    public void start() {
        StartMenu();
    }

    private void StartMenu() {
        renderer.renderStartMenu();

        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            HeroCreation();
        } else if (choice.equals("2")) {
            LoadHero();
        }
    }

    private void HeroCreation() {
        renderer.renderHeroCreation();

        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            hero = new Warrior();
        } else if (choice.equals("2")) {
            hero = new Wizard();
        }
        GameLoop();
    }

    private void LoadHero() {
        List<String> saveFiles = SaveManager.listSaveFiles();
        renderer.renderLoadHero(saveFiles);

        String choice = inputHandler.getInput();
        if (saveFiles.size() > 0) {
            int choiceInt = Integer.parseInt(choice);
            String selectedSaveFile = saveFiles.get(choiceInt - 1);
            hero = SaveManager.load(selectedSaveFile);
            GameLoop();
        } else {
            if (choice.equals("1")) {
                HeroCreation();
            }
        }
    }

    private void checkInteraction() {
        Cell heroCell = map.getHeroCell();

        Villain villain = heroCell.getVillain();
        if (villain != null) {
            handleBattle(villain, heroCell);
        }

        Artifact artifact = heroCell.getArtifact();
        if (artifact != null) {
            handleLoot(artifact, heroCell);
        }
    }

    private void handleWin() {
        Cell heroCell = map.getHeroCell();
        heroCell.setVillain(null);
        heroCell.setArtifact(factory.randomArtifact(hero));
        renderer.renderVictory();
        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            GameLoop();
        }
    }

    private void handleLose() {
        renderer.renderDefeat();
        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            StartMenu();
        }
    }

    private void handleBattle(Villain villain, Cell heroCell) {
        BattleOutcome out = interactionController.startBattle(hero, villain);

        switch (out) {
            case WIN:
                handleWin();
            case LOSE:
                handleLose();
            case ESCAPE:
                GameLoop();
        }
    }

    private void handleLoot(Artifact artifact, Cell heroCell) {
        interactionController.lootPurpose(hero, artifact);
        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            hero.takeArtifact(artifact);
            heroCell.setArtifact(null);
        }
        GameLoop();
    }

    private void GameLoop() {
        if (map == null) {
            map = new Map(hero);
        }
        playerController = new PlayerController(map);

        while (true) {
            renderer.renderMap(map);
            String direction = inputHandler.getInput();
            if (direction.equalsIgnoreCase("q")) {
                Menu();
            } else {
                playerController.moveHero(direction);
                checkInteraction();
            }
        }
    }

    private void Menu() {
        renderer.renderMenu();

        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            CharacterMenu(hero);
        } else if (choice.equals("2")) {
            GameLoop();
        } else if (choice.equals("3")) {
            SaveManager.save(hero);
        } else if (choice.equals("4")){
            StartMenu();
        } else if (choice.equals("5")) {
            renderer.close();
        }
    }

    private void CharacterMenu(Hero hero) {
        renderer.renderCharactereMenu(hero);

        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            Menu();
        }
    }
}