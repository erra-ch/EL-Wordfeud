package se.elserver.ELWordfeud.game;

import se.elserver.ELWordfeud.game.board.Board;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;
import se.elserver.ELWordfeud.game.player.Player;
import se.elserver.ELWordfeud.game.tile.TileBag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void addPlayer(String name) {
        // int id = RANDOM
        int id = 7;
        players.put(id, new Player(id, name));
    }

    public Player getPlayer(int id) {
        return players.get(id);
    }
}
