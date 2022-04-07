package list;

import entity.Student;
import service.StudentService;

import java.util.*;

/**
 * @author Komorebi
 * @since 2021.11.28.15:30
 */
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        //用户名数组
        students.add(new Student("01", "小王", 21, "男", "normal", 95, "软件开发"));
        students.add(new Student("02", "小李", 21, "男", "normal", 97, "软件开发"));
        students.add(new Student("03", "小张", 19, "男", "normal", 99, "软件开发"));
        students.add(new Student("04", "小刘", 20, "男", "normal", 98, "软件开发"));
        students.add(new Student("05", "小唐", 19, "女", "normal", 100, "软件开发"));

        StudentService service = new StudentService();
        String filepath = "e:/data.txt";
        int count = service.init(filepath,students);
        //要操作的用户号
        String number;

        //判断元素是否在数组中
        boolean isInArray = false;

        //用户选择
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************************************************");
            System.out.println("********Please Choose Your Action*******************");
            System.out.println("*****1.show all   2.add user      3.delete user*****");
            System.out.println("*****4.lock user  5.unclock user  6.exit       *****");
            System.out.println("****************************************************");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.showAll(filepath,count);
                    break;
                case 2:
                    isInArray = false;
                    System.out.println("Please input the user`s number: ");
                    number = sc.next();
                    for (Student student : students) {
                        if (student != null) {
                            if (number.equals(student.getNum())) {
                                isInArray= true;
                                break;
                            }
                        }
                    }
                    if(!isInArray) {
                        System.out.println("Please input name：");
                        String name = sc.next();
                        System.out.println("Please input age：");
                        int age = sc.nextInt();
                        System.out.println("Please input gender：");
                        String gender = sc.next();
                        System.out.println("Please input score：");
                        int score = sc.nextInt();
                        System.out.println("Please input profession：");
                        String profession = sc.next();
                        Student student = new Student(number, name, age, gender, "normal", score, profession);
                        students.add(student);
                        count = service.add(filepath, student, count);
                        System.out.println("Added successfully");
                        break;
                    }else{
                        System.out.println("The user you want to add is already in system!");
                        break;
                    }
                case 3:
                    isInArray = false;
                    String status = "locked";
                    boolean bool = false;
                    System.out.println("Please input you want to delete a user`number.");
                    number = sc.next();
                    //在集合里查找，如果找到就删除
                    Iterator<Student> iterator = students.iterator();
                    while (iterator.hasNext()) {
                        Student student = iterator.next();
                        if (number.equals(student.getNum())) {
                            if(status.equals(student.getStatus())){
                                bool = true;
                                System.out.println("The num you want to delete was locked");
                                System.out.println("Unable to delete!!!");
                                break;
                            }
                            iterator.remove();
                            isInArray = true;
                            break;
                        }
                    }
                    if(bool){
                        break;
                    }
                    if(isInArray){
                        count = service.update(filepath,students);
                        System.out.println("Deleted successfully");
                        break;
                    }
                    System.out.println("The num you want to delete is not in system!");
                    break;
                case 4:
                    System.out.println("Please input the num you want to lock:");
                    number = sc.next();
                    isInArray = false;
                    for (Student s : students) {
                        if (s != null) {
                            if (number.equals(s.getNum())) {
                                isInArray = true;
                                s.setStatus("locked");
                            }
                        }
                    }
                    if(isInArray){
                        service.update(filepath,students);
                        System.out.println("Lock successfully");
                        break;
                    }
                    System.out.println("The num you want to lock is not in the system!");
                    break;
                case 5:
                    System.out.println("Please input the num you want to unlock:");
                    number = sc.next();
                    isInArray = false;
                    for (Student s : students) {
                            if (number.equals(s.getNum())) {
                                isInArray = true;
                                s.setStatus("normal");
                            }
                    }
                    if(isInArray){
                        service.update(filepath,students);
                        System.out.println("Unlock successfully");
                        break;
                    }
                    System.out.println("The num you want to unlock is not in the system!");
                    break;
                case 6:
                    System.out.println("Your choose \"exit\"!");
                    break;
                default:
                    System.out.println("Please input 1~6!");
                    break;
            }
        } while (choice != 6);
        sc.close();

    }
}

