/**
 * @author Komorebi
 * @since 2021.09.30.17:50
 */
import java.util.*;
import java.lang.*;
public class User {
    private String name;
    private int number;
    public User(){
        name="";
        number=0;
    }
    public User(String name,int number){
        this.name=name;
        this.number=number;
    }
    public String getName() {
        return name;
    }
    public int getNumber(){
        return number;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        User[] user=new User[n];
        for(int i=0;i<n;i++){
            String name= sc.next();
            int number=0;
            if(sc.hasNextInt()){
                number=sc.nextInt();
            }
            //超过10位去前10位
            else if(sc.hasNext()){
                String s=sc.next();
                s=s.substring(0,10);
                number=Integer.parseInt(s);
            }else{
                System.out.println("false!!!");
                return;
            }
            user[i]=new User(name,number);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                String s1=user[j].getName();
                String s2=user[j+1].getName();
                if(s1.compareTo(s2)>0){
                    User temp=user[j];
                    user[j]=user[j+1];
                    user[j+1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.printf("%12s%12d",user[i].getName(),user[i].getNumber());
            System.out.println();
        }
        sc.close();
    }
}
