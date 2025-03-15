import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.09.13.16:52
 * n!的递归算法的编写
 */
public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long l = f(n);
        System.out.println("n! = "+l);
    }

    public static long f(int n){
        if(n==1 || n ==0){
            return 1;
        }
        return n*f(n-1);
    }
}
