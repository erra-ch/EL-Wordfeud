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

    public String getSpecialEffect(Position position) {
        return this.squareMatrix[position.getRow()][position.getCol()].getSpecialEffect();
    }

    public boolean isValidPositions(Position[] positions) {
        // Assumes front-end will prevent placing Tiles on occupied spaces

        if (isCohesiveRight(positions) || isCohesiveDown(positions)) {
            return true;
        }

        return false;
    }

    private boolean isCohesiveRight(Position[] positions) {
        for (int i = 1; i < positions.length; i++) {
            if (positions[i-1].getRow() + 1 != positions[i].getRow()) {
                return false;
            }
        }
        return true;
    }

    private boolean isCohesiveDown(Position[] positions) {
        for (int i = 1; i < positions.length; i++) {
            if (positions[i-1].getCol() + 1 != positions[i].getCol()) {
                return false;
            }
        }
        return true;
    }
}