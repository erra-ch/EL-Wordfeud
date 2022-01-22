package se.elserver.ELWordfeud.game.board;

import se.elserver.ELWordfeud.game.square.Square;

public abstract class Board {

    Square[][] squareMatrix;

    public Board(Square[][] squareMatrix) {
        this.squareMatrix = squareMatrix;
    }

    public abstract void generateSquares();
}
