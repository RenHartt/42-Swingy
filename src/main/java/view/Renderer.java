package view;

import java.util.List;

import model.Artifact;
import model.Villain;
import model.Hero;
import model.Map;

public interface Renderer {
    void cleanRender();
    void renderMenu();
    void renderStartMenu();
    void renderCharactereMenu(Hero hero);
    void renderHeroCreation();
    void renderLoadHero(List<String> saves);
    void renderMap(Map map);
    void renderFight(Hero hero, Villain villain);
    void renderDefeat();
    void renderVictory();
    void renderLoot(Artifact artifact);
    void renderLevelUp(Hero hero);
    void close();
}