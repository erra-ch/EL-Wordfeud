package se.elserver.ELWordfeud.game.board;

import se.elserver.ELWordfeud.game.square.Square;

public class StandardBoard extends Board{


    public StandardBoard() {
        super.squareMatrix = new Square[][] {};
    }

    @Override
    public void generateSquares() {
        //TODO: Provide layout
    }
}