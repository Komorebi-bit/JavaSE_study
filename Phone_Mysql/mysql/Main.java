package mysql;

import entity.Student;

import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2021.12.16.15:01
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();
        //连接数据库
        service.DBConnection();

        Student student = null;
        String num="";
        boolean bool = false;
        int choice = 0;

        //主界面，选择功能模块
        do {
            System.out.println("*****************************************************");
            System.out.println("************* Please Choose Your Action: ************");
            System.out.println("**** 1.show all     2.add user     3.delete user ****");
            System.out.println("**** 4.lock user    5.unlock user  6.exit        ****");
            System.out.println("*****************************************************");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    service.show();
                    break;
                case 2:
                    System.out.println("Please input you want to add user's NO.");
                    num = sc.next();
                    if(!service.query(num)){
                        System.out.println("Please input name");
                        String name = sc.next();
                        System.out.println("Please input age：");
                        int age = sc.nextInt();
                        System.out.println("Please input gender：");
                        String gender = sc.next();
                        System.out.println("Please input score：");
                        int score = sc.nextInt();
                        System.out.println("Please input profession：");
                        String profession = sc.next();
                        student = new Student(num, name, age, gender, "normal", score, profession);
                        bool = service.add(student);
                        if(bool)
                            System.out.println("Added successfully");
                        else System.out.println("Fail to add");
                        break;
                    }
                    System.out.println("The user you want to add was already in System!");
                    break;
                case 3:
                    System.out.println("Please input you want to delete user's NO.");
                    num = sc.next();
                    if(service.query(num)) {
                        bool = service.delete(num);
                        if(bool)
                            System.out.println("Deleted successfully");
                        else System.out.println("Fail to delete");
                        break;
                    }
                    System.out.println("The user you want to delete is not in System!");
                    break;
                case 4:
                    System.out.println("Please input the num you want to lock:");
                    num = sc.next();
                    if(service.query(num)){
                        bool = service.locked(num);
                        if(bool)
                            System.out.println("Locked successfully");
                        else System.out.println("The user was already locked");
                        break;
                    }
                    System.out.println("The user you want to lock is not in System!");
                    break;
                case 5:
                    System.out.println("Please input the num you want to unlock:");
                    num = sc.next();
                    if(service.query(num)){
                        bool = service.unlock(num);
                        if(bool)
                            System.out.println("Unlock successfully");
                        else System.out.println("The user was already unlock");
                        break;
                    }
                    System.out.println("The user you want to unlock is not in System!");
                    break;
                case 6:
                    System.out.println("Your choose \"exit\"!\nBye Bye!");
                    break;
                default:
                    System.out.println("Pleace input 1~6!");
                    break;
            }
        }while(6!=choice);

        service.closeAll();
        sc.close();
    }
}
