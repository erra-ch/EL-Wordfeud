package se.elserver.ELWordfeud;

import org.junit.*;
import se.elserver.ELWordfeud.game.GameBuilder;
import se.elserver.ELWordfeud.game.WordfeudGame;
import se.elserver.ELWordfeud.game.board.Board;
import se.elserver.ELWordfeud.game.board.Position;
import se.elserver.ELWordfeud.game.board.StandardBoard;
import se.elserver.ELWordfeud.game.dictionary.SwedishWordDictionary;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;
import se.elserver.ELWordfeud.game.player.Player;
import se.elserver.ELWordfeud.game.tile.NormalTile;
import se.elserver.ELWordfeud.game.tile.SwedishTileBag;
import se.elserver.ELWordfeud.game.tile.Tile;
import se.elserver.ELWordfeud.game.tile.TileBag;

import java.util.List;

public class ELWordfeudUnitTests {

    WordfeudGame game;
    Player player;

    @Before
    public void setup() {
        GameBuilder gameBuilder = new GameBuilder();
        gameBuilder.setLanguage("Swedish");
        gameBuilder.setBoardType("Standard");
        game  = gameBuilder.getResult();
        player = game.addPlayer("Erik");
    }

    @Test
    public void testCreateGame() {
        GameBuilder gameBuilder = new GameBuilder();
        gameBuilder.setLanguage("Swedish");
        gameBuilder.setBoardType("Standard");
        WordfeudGame game  = gameBuilder.getResult();
        game.addPlayer("Erik");

        Assert.assertEquals(game.getPlayer(7).getName(), "Erik");
        //TODO: Assert Board and TileBag type
    }

    @Test
    public void testDictionary() {
        WordDictionary dict = new SwedishWordDictionary();
        Assert.assertFalse(dict.isValidWord("heehaaw"));
        Assert.assertTrue(dict.isValidWord("bra"));
        Assert.assertEquals(dict.getDefinition("attans"), "attans också, jag glömde nyckeln! ha en attans otur");
    }

    @Test
    public void testTileBag() {
        TileBag bag = new SwedishTileBag();
        for (int i = 104; i > 0 ; i--) {
            Assert.assertEquals(bag.getSize(), i);
            bag.getRandomTile();
        }
    }

    @Test
    public void testTile() {
        Tile tile = new NormalTile("A", 1);
        Assert.assertEquals("A", tile.getLetter());
        Assert.assertEquals(1, tile.getValue());
    }

    @Test
    public void testPlayWord() {

        List<Tile> tiles = player.getTiles();
        Tile[] tileArray = {tiles.remove(0), tiles.remove(0), tiles.remove(0), tiles.remove(0)};
        Position[] positions = {new Position(7,7), new Position(7,8), new Position(7, 9), new Position(7, 10)};
        boolean worked = true;
        try {

            game.playWord(player.getId(), tileArray, positions);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect word");
            worked = false;
        } finally {
            Assert.assertEquals(!worked, game.isValidPositions(positions));
        }
    }
}
