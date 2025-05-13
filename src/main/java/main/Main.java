package main;

import model.*;
import controller.*;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws java.io.IOException {
        Hero hero = new Warrior();
        Map map = new Map(hero);
        PlayerController playerController = new PlayerController(map);
        InputHandler inputHandler = new ConsoleInputHandler();

        while (true) {
            map.printMap();

            String direction = inputHandler.getInput();
            if (direction.equalsIgnoreCase("q")) {
                break;
            }
            playerController.moveHero(direction);
        }
    }
}