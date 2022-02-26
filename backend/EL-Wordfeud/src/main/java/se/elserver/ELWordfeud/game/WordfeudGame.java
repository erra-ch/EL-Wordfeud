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
    //TODO: Maybe admin player id

    public WordfeudGame(WordDictionary dictionary, TileBag tileBag, Board board){
        this.dictionary = dictionary;
        this.players = new HashMap<>();
        this.tileBag = tileBag;
        this.board = board;
    }

    public Player addPlayer(String name) {
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

        this.board.placeTiles(tiles, positions);
        System.out.println(board);
    }

    private void getNewTiles(int playerID) {
        Player player = getPlayer(playerID);
        List tileRack = player.getTiles();
        while (tileRack.size() < 7 && tileBag.getSize() != 0) {
            tileRack.add(tileBag.getRandomTile());
        }
    }
}
