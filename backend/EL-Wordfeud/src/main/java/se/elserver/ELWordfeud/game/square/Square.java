package se.elserver.ELWordfeud.game.square;

import se.elserver.ELWordfeud.game.tile.Tile;

public abstract class Square {

    Tile tile;

    public Square() {}

    public abstract void setTile(Tile tile);
}
