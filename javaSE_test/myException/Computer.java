package myException;

/**
 * @author Komorebi
 * @since 2021.11.11.16:40
 */
import java.util.*;
public class Computer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        try {
            System.out.println(gcd(n,m));
        } catch (NegativeException e) {
            e.printStackTrace();
        }
        sc.close();
    }
    public static int gcd(int n,int m) throws NegativeException{
        if(n<=0||m<=0)throw new NegativeException("参数中存在小于等于0的数!!!");
        int a,b;
        if(n<m){ a=m; b=n; }
        else{ a=n; b=m; }
        int c = a%b;
        while(c!=0){
            a=b;
            b=c;
        }
        return b;
    }
}
