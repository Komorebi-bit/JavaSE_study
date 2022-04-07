package array;
/**
 * @author Komorebi
 * @since 2021.10.28.16:18
 */
import java.util.*;
public class Main {

    public static void main(String[] args) {
        //用户名数组
        String[] students={"小王","小李","小张","小刘","小唐"};
        //要操作的用户名
        String name;
        //数组长度
        int length=students.length;
        //判断元素是否在数组中
        boolean isArray=false;
        //获取students的第一个null的下标
        int index=-1;
        //用户选择
        int choice = 0;
        //用户状态
        String locks[] ={"normal","normal","normal","normal","normal"};

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

                //    if(students[0]==null){
                //        System.out.println("空");
                //        break;
                //    }

                    System.out.println("编号\t姓名");
                    for(int i=0;i<length;i++){
                        if(students[i]!=null){
                            System.out.println((i+1) +"\t"+students[i]+"\t"+locks[i]);
                        }
                    }
                break;
                case 2:
                    System.out.println("Please input the user`s name: ");
                    isArray=false;
                    name=sc.next();
                    for(String s:students){
                        if(name.equals(s)){
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
                        if(index>=0&&index<length){
                            students[index]=name;
                            locks[index]="normal";
                        }else{
                            students= Arrays.copyOf(students,length+1);
                            students[length]=name;
                            locks = Arrays.copyOf(locks,length+1);
                            locks[length]="normal";
                        }
                        System.out.println("Added successfully");
                    }
                break;
                case 3:
                    System.out.println("Please you want to delete a user`name.");
                    isArray=false;
                    name = sc.next();
                    length = students.length;
                    for(int i=0;i<length;i++){
                        if(name.equals(students[i])){
                            isArray=true;
                            index=i;
                            break;
                        }
                    }
                    if(isArray){
                        int i;
                        for(i=index;i<length-1;i++){
                            students[i]=students[i+1];
                            locks[i]=locks[i+1];
                        }
                        students[i]=null;
                        locks[i]=null;
                        index=i;
                        System.out.println("Deleted successfully");
                    }else{
                        System.out.println("The user you want to delete is not in system!");
                    }
                break;
                case 4:
                    length = students.length;
                    System.out.println("Please input a name you want to lock.");
                    name=sc.next();
                    for(int i=0;i<length;i++){
                        if(name.equals(students[i])){
                            isArray=true;
                            index=i;
                            break;
                        }
                    }
                    if(isArray){
                        locks[index]="locked";
                        System.out.println("Locked successfully");
                    }else{
                        System.out.println("The user you want to lock is not in system!");
                    }
                break;
                case 5:
                    length = students.length;
                    System.out.println("Please input a name you want to unlock.");
                    name = sc.next();
                    for(int i=0;i<length;i++){
                        if(name.equals(students[i])){
                            isArray=true;
                            index=i;
                            break;
                        }
                    }
                    if(isArray){
                        locks[index]="unlock";
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
