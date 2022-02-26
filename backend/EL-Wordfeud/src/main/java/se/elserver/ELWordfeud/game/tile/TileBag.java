package se.elserver.ELWordfeud.game.tile;

import java.util.List;

public abstract class TileBag { //TODO: Refactor: No point in being abstract since languages doesn't change implementation.

    protected List<Tile> tiles;

    public TileBag(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public Tile getRandomTile() {
        return tiles.remove(0); //List is shuffled during creation
    }

    public int getSize() {
        return this.tiles.size();
    }
}
