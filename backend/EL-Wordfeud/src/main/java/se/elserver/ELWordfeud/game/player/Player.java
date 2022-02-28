package se.elserver.ELWordfeud.game.player;

import se.elserver.ELWordfeud.game.tile.Tile;

import java.util.List;

public class Player {

    private int id;
    private String name;
    private TileRack tileRack;
    private int points;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.tileRack = new TileRack();
        this.points = 0;
    }

    public List<Tile> getTiles() {
        return this.tileRack.getTiles();
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getPoints() { return this.points; }

    public void addPoints(int points) {
        this.points = this.points + points;
    }
}
