package se.elserver.ELWordfeud;

import org.junit.*;
import se.elserver.ELWordfeud.game.GameBuilder;
import se.elserver.ELWordfeud.game.WordfeudGame;
import se.elserver.ELWordfeud.game.dictionary.SwedishWordDictionary;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;

import java.util.logging.Level;

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

    @Test
    public void testDictionary() {
        WordDictionary dict = new SwedishWordDictionary();
        Assert.assertFalse(dict.isValidWord("heehaaw"));
        Assert.assertTrue(dict.isValidWord("bra"));
        Assert.assertEquals(dict.getDefinition("attans"), "attans också, jag glömde nyckeln! ha en attans otur");
    }
}
