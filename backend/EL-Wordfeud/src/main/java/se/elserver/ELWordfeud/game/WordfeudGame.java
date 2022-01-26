package se.elserver.ELWordfeud.game;

import se.elserver.ELWordfeud.game.board.Board;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;
import se.elserver.ELWordfeud.game.player.Player;
import se.elserver.ELWordfeud.game.tile.TileBag;

import java.util.ArrayList;
import java.util.List;

public class WordfeudGame {

    private WordDictionary dictionary;
    private List<Player> players;
    private TileBag tileBag;
    private Board board;

    public WordfeudGame(WordDictionary dictionary, TileBag tileBag, Board board){
        this.dictionary = dictionary;
        this.players = new ArrayList<>();
        this.tileBag = tileBag;
        this.board = board;
        //TODO: Start different type of games (Language, board type)
    }

    public void addPlayer(String name) {

    }
}
