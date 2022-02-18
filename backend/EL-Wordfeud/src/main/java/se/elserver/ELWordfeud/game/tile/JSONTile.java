package se.elserver.ELWordfeud.game.tile;

class JSONTile {

    private String letter;
    private int points;
    private int amount;

    JSONTile() {

    }

    JSONTile(String letter, int points, int amount) {
        this.letter = letter;
        this.points = points;
        this.amount = amount;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
