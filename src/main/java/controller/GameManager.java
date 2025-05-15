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

    public GameManager(InputHandler inputHandler, Renderer renderer) {
        this.inputHandler = inputHandler;
        this.renderer = renderer;
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