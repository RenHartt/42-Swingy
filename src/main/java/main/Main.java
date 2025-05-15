package main;

import model.*;
import controller.*;
import view.*;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws java.io.IOException {
        InputHandler inputHandler = new CliInputHandler();
        Renderer renderer = new CliRenderer();
        GameManager gameManager = new GameManager(inputHandler, renderer);
        gameManager.start();
    }
}