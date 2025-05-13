package controller;

import model.*;

public class PlayerController {
    private Map map;

    public PlayerController(Map map) {
        this.map = map;
    }

    public void moveHero(String direction) {
        map.moveHero(direction);
    }
}