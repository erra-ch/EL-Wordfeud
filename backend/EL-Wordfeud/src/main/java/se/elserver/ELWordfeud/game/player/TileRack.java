package se.elserver.ELWordfeud.game.player;

import se.elserver.ELWordfeud.game.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class TileRack {

    List<Tile> tiles;

    public TileRack() {
        this.tiles = new ArrayList<Tile>();
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

    public void shuffleTiles() {
        //TODO: Shuffle order in list
    }
}
