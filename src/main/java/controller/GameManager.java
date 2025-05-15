package controller;

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
        map = new Map(hero);
        playerController = new PlayerController(map);
        GameLoop();
    }

    private void LoadHero() {
        renderer.renderLoadHero();
        String choice = inputHandler.getInput();
        // Load hero logic
        GameLoop();
    }

    private void GameLoop() {
        while (true) {
            renderer.renderMap(map);
            String direction = inputHandler.getInput();
            if (direction.equalsIgnoreCase("q")) {
                Menu();
            } else {
                playerController.moveHero(direction);
                if (map.getCell(hero.getX(), hero.getY()).getEntity() instanceof Villain) {
                    
                }
            }
        }
    }

    private void Menu() {
        renderer.renderMenu();
        String choice = inputHandler.getInput();
        if (choice.equals("1")) {
            GameLoop();
        } else if (choice.equals("2")) {
            // Save game logic
        } else if (choice.equals("3")) {
            renderer.close();
        }
    }
}