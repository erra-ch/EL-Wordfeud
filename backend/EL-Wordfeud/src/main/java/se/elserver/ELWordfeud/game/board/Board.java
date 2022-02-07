package se.elserver.ELWordfeud.game.board;

import se.elserver.ELWordfeud.game.square.Square;
import se.elserver.ELWordfeud.game.tile.Tile;

public abstract class Board {

    protected Square[][] squareMatrix;

    public abstract void generateSquares();

    public abstract void placeTiles(Tile[] tiles, Position[] positions);
}
