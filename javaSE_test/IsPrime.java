/**
 * @author Komorebi
 * @since 2021.09.09.18:01
 */
import java.util.*;
public class IsPrime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isPrime(n));
        sc.close();
    }
    static int isPrime(int n){
        if(1 == n){
            return 1;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return 0;
            }
        }
        return 1;
    }
}

