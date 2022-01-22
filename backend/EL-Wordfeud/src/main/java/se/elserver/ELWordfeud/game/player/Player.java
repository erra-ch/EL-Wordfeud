package se.elserver.ELWordfeud.game.player;

import se.elserver.ELWordfeud.game.tile.Tile;

import java.util.List;

public abstract class Player {

    int id;
    String name;
    TileRack tileRack;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.tileRack = new TileRack();
    }

    public List<Tile> getTiles() {
        return this.tileRack.getTiles();
    }
}
