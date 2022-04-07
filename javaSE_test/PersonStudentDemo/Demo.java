package PersonStudentDemo;

/**
 * @author Komorebi
 * @since 2021.10.14.15:45
 */
public class Demo {
    public static void main(String[] args) {
        Person teacher = new Teacher("bilibili", 36, 6000);
        teacher.output();
        System.out.println(teacher);
        Person student = new Student("玛卡巴卡", 19, 96.2);
        student.output();
        System.out.println(student);
    }
}
