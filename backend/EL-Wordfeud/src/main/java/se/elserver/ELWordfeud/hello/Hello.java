package se.elserver.ELWordfeud.hello;

public class Hello {

    private int id;
    private String message;
    private boolean isSwedish;

    public Hello(int id, String message, boolean isSwedish) {
        this.id = id;
        this.message = message;
        this.isSwedish = isSwedish;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSwedish() {
        return isSwedish;
    }
}
