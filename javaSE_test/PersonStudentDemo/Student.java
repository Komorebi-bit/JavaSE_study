package PersonStudentDemo;

/**
 * @author Komorebi
 * @since 2021.10.14.15:44
 */
public class Student extends Person {
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void output() {
        super.output();
        System.out.println("score: " + score);
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "score=" + score +
                '}';
    }
}
