package PersonStudentDemo;

/**
 * @author Komorebi
 * @since 2021.10.14.15:44
 */
public class Teacher extends Person {
    private int salary;

    public Teacher() {
    }

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void output() {
        super.output();
        System.out.println("salary: " + salary);
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "salary=" + salary +
                '}';
    }
}
