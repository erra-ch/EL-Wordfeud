package se.elserver.ELWordfeud;

import org.junit.*;
import se.elserver.ELWordfeud.game.GameBuilder;
import se.elserver.ELWordfeud.game.WordfeudGame;

public class ELWordfeudUnitTests {


    @Test
    public void testCreateGame() {
        GameBuilder gameBuilder = new GameBuilder();
        gameBuilder.setLanguage("Swedish");
        gameBuilder.setBoardType("Standard");
        WordfeudGame game  = gameBuilder.getResult();
        game.addPlayer("Erik");

        Assert.assertEquals(game.getPlayer(7).getName(), "Erik");
    }
}
