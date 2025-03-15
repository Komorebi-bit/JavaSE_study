import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Komorebi
 * @since 2022.12.18.9:14
 */
public class Student {

    private String id;
    private String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student student)) {
            return false;
        }
        return getId().equals(student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student[] students = {new Student("001", "张三"),
            new Student("002", "李四"),
            new Student("003", "王五"),
            new Student("001", "赵六")};
        for (Student s : students) {
            if (set.contains(s)) {
                System.out.println("已经存在id=" + s.getId() + "的元素了");
            } else {
                set.add(s);
            }
        }

    }
}
