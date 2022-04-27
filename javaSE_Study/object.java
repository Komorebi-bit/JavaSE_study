import java.util.Scanner;

/**
 * @author Komorebi
 * 类;
 * final 修饰类 表示不可继承
 * final 修饰方法 表示此方法不可被子类覆盖
 * 静态变量也可以直接赋值
 * 内部类;
 * 内部类 类里可以直接访问外部类的字段和方法(private也可以)
 * 如果内部类和外部类有同名的字段和方法 使用 外部类名.this.字段及方法
 * 内部类可以用public protected private final abstract 修饰;
 * static 修饰的类 实际上是外部类 实例化类时, mew前面不需要用对象实例变量(new 外部类名.内部类名)
 * 不能访问外部类的非static字段和方法
 */
public class object {
    private static int title;    //静态变量也可以直接赋值

    static {
        object.title = 100;    //可以使用static块对静态变量赋值
    }

    private String name;
    private int age;
    private char sex;

    public object() {
        name = " ";
        age = 0;
        sex = ' ';
    }

    public object(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void getStatic() {
        object.title++;
    }

    public static void main(String[] args) {
        object obj = new object("马彬", 20, 'f');
        obj.output();
        object.getStatic();      //用类名调用静态方法
        System.out.println("总数: " + object.title);
        student stu = obj.new student(98);    //生成内部类对象
        System.out.println(stu.value());
        teacher tea = new teacher("数学");
    }

    public void output() {
        System.out.println("姓名: " + name);
        System.out.println("性别: " + sex);
        System.out.println("年龄: " + age);
    }

    static class teacher {
        private String career;

        teacher(String s) {
            career = s;
        }

    }

    class student {
        private int score;

        student(int score) {
            this.score = score;
        }

        int value() {
            output();
            return score;
        }
    }
}