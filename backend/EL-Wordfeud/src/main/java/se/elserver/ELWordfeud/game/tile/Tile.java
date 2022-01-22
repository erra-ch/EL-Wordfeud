package se.elserver.ELWordfeud.game.tile;

public abstract class Tile {

    String letter;
    int value;

    public Tile(String letter, int value) {
        this.letter = letter;
        this.value = value;
    }
}
