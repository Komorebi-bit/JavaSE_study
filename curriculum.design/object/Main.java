package object;

import entity.Student;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2021.11.28.14:20
 */
public class Main {

    public static void main(String[] args) {
        //用户名数组
        Student[] students = new Student[10];
        students[0] = new Student("01","小王",21,"男","normal",95,"软件开发");
        students[1] = new Student("02","小李",21,"男","normal",97,"软件开发");
        students[2] = new Student("03","小张",19,"男","normal",99,"软件开发");
        students[3] = new Student("04","小刘",20,"男","normal",98,"软件开发");
        students[4] = new Student("05","小唐",19,"女","normal",100,"软件开发");
        //要操作的用户名
        String number;
        //数组长度
        int length=students.length;
        //判断元素是否在数组中
        boolean isArray=false;
        //获取students的第一个null的下标
        int index=-1;
        //用户选择
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("****************************************************");
            System.out.println("********Please Choose Your Action*******************");
            System.out.println("*****1.show all   2.add user      3.delete user*****");
            System.out.println("*****4.lock user  5.unclock user  6.exit       *****");
            System.out.println("****************************************************");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    length=students.length;
                    System.out.println("学号\t姓名\t年龄\t性别\t状态\t成绩\t专业");
                    for(int i=0;i<length;i++){
                        if(students[i]!=null){
                            System.out.println(students[i]);
                        }
                    }
                break;
                case 2:
                    System.out.println("Please input the user`s number: ");
                    isArray=false;
                    number=sc.next();
                    for(Student s:students){
                        if(s!=null && number.equals(s.getNum())){
                            System.out.println("The user you want to add is already in system!");
                            isArray=true;
                            break;
                        }
                    }
                    length=students.length;
                    for(int i=0;i<length;i++){
                        if(students[i]==null){
                            index=i;
                            break;
                        }
                    }
                    if(!isArray){
                        if(index<0&&index>=length){
                            students= Arrays.copyOf(students,length+1);
                            index = length;
                        }
                        System.out.println("请分别输入姓名,年龄,性别,成绩,专业");
                        String name = sc.next();
                        int age = sc.nextInt();
                        String gender = sc.next();
                        int score = sc.nextInt();
                        String profession = sc.next();
                        students[index] = new Student(number,name,age,gender,"normal",score,profession);
                        System.out.println("Added successfully");
                    }
                break;
                case 3:
                    System.out.println("Please you want to delete a user`number.");
                    isArray=false;
                    number = sc.next();
                    length = students.length;
                    for(int i=0;i<length;i++){
                        if(students[i]!=null && number.equals(students[i].getNum())){
                            isArray=true;
                            index=i;
                            break;
                        }
                    }
                    if(isArray){
                        int i;
                        for(i=index;i<length-1;i++){
                            students[i]=students[i+1];
                        }
                        students[i]=null;
                        index=i;
                        System.out.println("Deleted successfully");
                    }else{
                        System.out.println("The user you want to delete is not in system!");
                    }
                break;
                case 4:
                    length = students.length;
                    System.out.println("Please input a number you want to lock.");
                    number = sc.next();
                    for(int i=0;i<length;i++){
                        if(students[i]!=null && number.equals(students[i].getNum())){
                            isArray=true;
                            index=i;
                            break;
                        }
                    }
                    if(isArray){
                        students[index].setStatus("locked");
                        System.out.println("Locked successfully");
                    }else{
                        System.out.println("The user you want to lock is not in system!");
                    }
                    break;
                case 5:
                    length = students.length;
                    System.out.println("Please input a number you want to unlock.");
                    number = sc.next();
                    for(int i=0;i<length;i++){
                        if(students[i]!=null && number.equals(students[i].getNum())){
                            isArray=true;
                            index=i;
                            break;
                        }
                    }
                    if(isArray){
                        students[index].setStatus("unlock");
                        System.out.println("Unlocked successfully");
                    }else{
                        System.out.println("The user you want to unlock is not in system!");
                    }
                break;
                case 6:System.out.println("Your choose \"exit\"!");
                break;
                default:System.out.println("Please input 1~6!");
                break;
            }
        }while(choice != 6);
        sc.close();

    }
}
