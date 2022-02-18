package se.elserver.ELWordfeud.game.player;

import se.elserver.ELWordfeud.game.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileRack {

    List<Tile> tiles;

    public TileRack() {
        this.tiles = new ArrayList<Tile>(7);
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

    public void shuffleTiles() {
        Collections.shuffle(this.tiles);
    }
}
