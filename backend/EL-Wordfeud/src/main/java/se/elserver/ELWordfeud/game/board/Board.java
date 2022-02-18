package se.elserver.ELWordfeud.game.board;

import se.elserver.ELWordfeud.game.square.Square;
import se.elserver.ELWordfeud.game.tile.Tile;

public abstract class Board {

    protected Square[][] squareMatrix;

    protected abstract void generateSquares();

    public void placeTiles(Tile[] tiles, Position[] positions) {
        if (!isValidPositions(positions)) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < tiles.length; i++) {
            this.squareMatrix[positions[i].getRow()][positions[i].getCol()].setTile(tiles[i]);
        }
    }

    public boolean isValidPositions(Position[] positions) {
        for (Position position : positions) {
            if (this.squareMatrix[position.getRow()][position.getCol()].isOccupied()) {
                return false;
            }
        }
        return true;
    }
}
