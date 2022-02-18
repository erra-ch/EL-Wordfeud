package se.elserver.ELWordfeud.game.tile;

public abstract class Tile {

    //TODO: Maybe id is needed? How can front-end differentiate between equal tiles?
    private String letter;
    private int value;

    public Tile(String letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public String getLetter() {
        return letter;
    }

    public int getValue() {
        return value;
    }
}
