package gov.counselling.collageCounselling.Entity;

import java.util.List;

public class Student {
    private long id;
    private String  name;
    private double score;
    private List<Collage>  choice;

    public Student(long id, String name, double score, List<Collage> choice) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.choice = choice;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Collage> getChoice() {
        return choice;
    }

    public void setChoice(List<Collage> choice) {
        this.choice = choice;
    }
}
