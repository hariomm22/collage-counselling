package gov.counselling.collageCounselling.Entity;

public class Collage {
    private long id;
    private String  name;
    private long seat;

    public Collage(long id, String name, long seat) {
        this.id = id;
        this.name = name;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public long getName() {
        return id;
    }

    public long getSeat() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeat(long seat) {
        this.seat = seat;
    }
}
