package gov.counselling.collageCounselling.Entity;

import org.springframework.stereotype.Component;

@Component
public class Collage {
    private long id;
    private String  name;
    private long seat;

     public Collage(){
     }

    public Collage(long id, String name, long seat) {
        this.id = id;
        this.name = name;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSeat() {
        return seat;
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

    @Override
    public String toString() {
        return "Collage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seat=" + seat +
                '}';
    }
}
