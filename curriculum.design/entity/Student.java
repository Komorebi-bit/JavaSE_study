package entity;

import java.io.Serializable;

/**
 * @author Komorebi
 * @since 2021.11.28.14:05
 */
public class Student extends Person implements Serializable {
    private int score;
    private String profession;

    public Student() {}
    public Student(String num, String name, int age, String gender, String status, int score, String profession) {
        super(num, name, age, gender, status);
        this.score = score;
        this.profession = profession;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString(){
        return super.toString()+'\t'+score+'\t'+profession;
    }

}

