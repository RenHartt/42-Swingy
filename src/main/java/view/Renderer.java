package view;

import model.Artifact;
import model.Villain;
import model.Hero;
import model.Map;

public interface Renderer {
    void cleanRender();
    void renderMenu();
    void renderStartMenu();
    void renderHeroCreation();
    void renderLoadHero();
    void renderMap(Map map);
    void renderFight(Hero hero, Villain villain);
    void renderDefeat();
    void renderVictory();
    void renderLoot(Artifact artifact);
    void renderLevelUp(Hero hero);
    void close();
}