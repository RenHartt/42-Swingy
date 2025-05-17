package controller;

import model.*;

public class PlayerController {
    private Map map;

    public PlayerController(Map map) {
        this.map = map;
    }

    public boolean moveHero(String direction) {
        return map.moveHero(direction);
    }
}