package se.elserver.ELWordfeud.game.square;

import se.elserver.ELWordfeud.game.tile.Tile;

public abstract class Square {

    protected Tile tile;

    public void setTile(Tile tile) {
        if (isOccupied()) {
            throw new IllegalStateException();
        }
        this.tile = tile;
    }

    public boolean isOccupied() {
        return this.tile != null;
    }

    @Override
    public String toString() {
        if (this.tile == null) {
            return "-";
        }
        return this.tile.getLetter();
    }

    public abstract String getSpecialEffect();


}
