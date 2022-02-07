package se.elserver.ELWordfeud.game.board;

import se.elserver.ELWordfeud.game.square.Square;
import se.elserver.ELWordfeud.game.tile.Tile;

public class StandardBoard extends Board{


    public StandardBoard() {
        super.squareMatrix = new Square[][] {};
    }

    @Override
    public void generateSquares() {
        //TODO: Provide layout
    }

    @Override
    public void placeTiles(Tile[] tiles, Position[] positions) {
        for (int i = 0; i < tiles.length - 1; i++) {
            super.squareMatrix[positions[i].getRow()][positions[i].getCol()].setTile(tiles[i]);
        }
    }

}
