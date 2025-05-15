package controller;

import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.IOException;

import model.Hero;
import model.Save;

public class SaveManager {
    private static final String saveDirectory = "saves";

    private static String generateSaveFileName(Hero hero) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String dateStr = sdf.format(new Date());
        return hero.getName() + dateStr + ".save";
    }

    public static void save(Hero hero) {
        Save save = new Save(hero);
        Path savePath = Paths.get(saveDirectory);
        try {
            Files.createDirectories(savePath);
            String fileName = generateSaveFileName(hero);
            Path saveFile = savePath.resolve(fileName);

            save.saveToFile(saveFile.toString());
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    public static Hero load(String fileName) {
        Path saveFile = Paths.get(saveDirectory, fileName);
        return Save.loadFromFile(saveFile.toString());
    }

    public static List<String> listSaveFiles() {
        Path savePath = Paths.get(saveDirectory);
        try {
            return Files.walk(savePath, 1)
                        .filter(Files::isRegularFile)
                        .filter(path -> path.toString().endsWith(".save"))
                        .map(path -> path.getFileName().toString())
                        .toList();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture des fichiers de sauvegarde : " + e.getMessage());
        }
        return List.of();
    }
}