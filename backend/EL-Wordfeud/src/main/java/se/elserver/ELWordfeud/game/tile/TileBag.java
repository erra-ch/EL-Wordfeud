package se.elserver.ELWordfeud.game.tile;

import java.util.List;

public abstract class TileBag {

    List<Tile> tiles;

    public TileBag(List<Tile> tiles){
        this.tiles = tiles;
    }

    public Tile getRandomTile() {
        return tiles.remove(0); //TODO: Make random
    }

    public int getSize() {
        return this.tiles.size();
    }
}
