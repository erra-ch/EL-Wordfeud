package se.elserver.ELWordfeud.game;

import se.elserver.ELWordfeud.game.board.Board;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;
import se.elserver.ELWordfeud.game.player.Player;
import se.elserver.ELWordfeud.game.tile.TileBag;

import java.util.List;

public class WordfeudGame {

    WordDictionary dictionary;
    List<Player> players;
    TileBag tileBag;
    Board board;

    public WordfeudGame(){
        //TODO: Start different type of games (Language, board type)
    }

    public void addPlayer(String name) {

    }
}
