package se.elserver.ELWordfeud.hello;

import javax.persistence.*;

@Entity
@Table( name = "Hellos")
public class Hello {

    //@GeneratedValue( strategy = GenerationType.IDENTITY )
    @Id
    private int id;

    @Column( name="phrase", nullable = false, unique = true)
    private String message;

    private boolean isSwedish;

    protected Hello() {};

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
