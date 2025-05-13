package main;

import model.*;
import controller.*;

public class Main {
    public static void main(String args[]) {
        Hero hero = new Warrior();
        Map map = new Map(hero);
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();

        while (true) {
            map.printMap();

            String direction = inputHandler.getInput();
            if (direction.equalsIgnoreCase("q")) {
                break;
            }
            map.moveHero(direction);
        }
    }
}