package gov.counselling.collageCounselling.Entity;

import java.util.List;

public class Student {
    private long id;
    private String  name;
    private double score;
    //private List<Collage>  choice;
    private long rank;
    private Collage allocate;

    public Student(){

     }

    public Student(long id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
//        this.choice = choice;
        this.allocate=null;
        this.rank=0;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRank(long rank) {
        this.rank = rank;
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

    public double getRank() {
        return rank;
    }

    public void setAllocate(Collage allocate){this.allocate=allocate;}

    public Collage getAllocate(){return allocate;}

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                ", allocate=" + allocate +
                '}';
    }
//    public List<Collage> getChoice() {
//        return choice;
//    }

//    public void setChoice(List<Collage> choice) {
//        this.choice = choice;
//    }
}
