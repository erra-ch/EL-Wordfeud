package se.elserver.ELWordfeud.game.square;

import se.elserver.ELWordfeud.game.tile.Tile;

public class RegularSquare extends Square {

    public RegularSquare() {

    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile; //TODO: Prevent multiple changes.
    }
}
