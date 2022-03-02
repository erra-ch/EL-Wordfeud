package se.elserver.ELWordfeud.game;

import se.elserver.ELWordfeud.game.board.Board;
import se.elserver.ELWordfeud.game.board.Position;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;
import se.elserver.ELWordfeud.game.player.Player;
import se.elserver.ELWordfeud.game.tile.Tile;
import se.elserver.ELWordfeud.game.tile.TileBag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WordfeudGame {

    private WordDictionary dictionary;
    private Map<Integer, Player> players;
    private TileBag tileBag;
    private Board board;
    private Map<String, Integer> scoreboard;
    //TODO: Maybe admin player id

    public WordfeudGame(WordDictionary dictionary, TileBag tileBag, Board board){
        this.dictionary = dictionary;
        this.players = new HashMap<>();
        this.tileBag = tileBag;
        this.board = board;
        this.scoreboard = new HashMap<>();
    }

    public Player addPlayer(String name) {
        // TODO: Make names unique
        int id = new Random().nextInt(); // TODO: Maybe move to Player class and use Spring Data JPA
        players.put(id, new Player(id, name));
        getNewTiles(id);
        return players.get(id);
    }

    public Player getPlayer(int id) {
        return players.get(id);
    }

    public List<Player> getPlayers()  {
        return this.players.values().stream().toList();
    }

    public Map<String, Integer> getScoreboard() {
        getPlayers().forEach(player -> this.scoreboard.put(player.getName(), player.getPoints()));

        return this.scoreboard;
    }

    public boolean isValidPositions(Position[] positions) {
        return this.board.isValidPositions(positions);
    }

    public boolean isValidWord(String word) {
        return this.dictionary.isValidWord(word);
    }

    public void playWord(int playerID, Tile[] tiles, Position[] positions) { // if this works, then playerID is not needed? Just use Player object
        Player player = getPlayer(playerID); // TODO: catch null pointer?
        if (!isValidPositions(positions)) throw new IllegalStateException(); // This will be an HTTP error code
        StringBuilder builder = new StringBuilder();
        for (Tile tile : tiles) {
            builder.append(tile.getLetter());
        }
        System.out.println(builder);
        if (!isValidWord(builder.toString())) throw new IllegalArgumentException();  // Same^^. TODO: Fix custom exceptions?


        // Not sure if this will work. Must point to same tile objects
        for (Tile tile : tiles) {
            player.getTiles().remove(tile); // Remove from player's TileRack
            //TODO: Catch exception if tile somehow doesn't belong to player
        }

        getNewTiles(playerID);

        this.board.placeTiles(tiles, positions);
        System.out.println(board);
    }

    public int getPoints(Tile[] tiles, Position[] positions) {
        // TODO: Calculate points. No need to check if real word or allowed position.
        //  front-end will not call function if position is illegal

        // Check positions for special effects. Letter-effects can be added right away, save Word-effects for later
        // How will multiple word play be calculated?
        for (int i = 0; i < positions.length; i++) {
            String effect = this.board.getSpecialEffect(positions[i]);
            // do something with effect and corresponding tile
        }

        return 0;
    }

    private void getNewTiles(int playerID) {
        Player player = getPlayer(playerID);
        List tileRack = player.getTiles();
        while (tileRack.size() < 7 && tileBag.getSize() != 0) {
            tileRack.add(tileBag.getRandomTile());
        }
    }
}
