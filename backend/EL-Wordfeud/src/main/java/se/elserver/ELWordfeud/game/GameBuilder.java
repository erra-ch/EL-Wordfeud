package se.elserver.ELWordfeud.game;

import se.elserver.ELWordfeud.game.board.Board;
import se.elserver.ELWordfeud.game.board.StandardBoard;
import se.elserver.ELWordfeud.game.dictionary.EnglishWordDictionary;
import se.elserver.ELWordfeud.game.dictionary.SwedishWordDictionary;
import se.elserver.ELWordfeud.game.dictionary.WordDictionary;
import se.elserver.ELWordfeud.game.tile.EnglishTileBag;
import se.elserver.ELWordfeud.game.tile.SwedishTileBag;
import se.elserver.ELWordfeud.game.tile.TileBag;

public class GameBuilder {

    private WordDictionary dictionary;
    private TileBag tileBag;
    private Board board;

    public void setLanguage(String language) {
        switch (language) {
            case "Swedish":
                this.dictionary = new SwedishWordDictionary();
                this.tileBag = new SwedishTileBag();
                break;

            case "English":
                this.dictionary = new EnglishWordDictionary();
                this.tileBag = new EnglishTileBag();
                break;
        }
    }

    public void setBoardType(String type) {
        switch (type) {
            case "Standard":
                this.board = new StandardBoard();
                break;
        }
    }

    public WordfeudGame getResult() {
        return new WordfeudGame(dictionary, tileBag, board);
    }
}
