import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.09.13.17:08
 * Fibonacci数列求解
 */
public class App2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long l = f(n);
        System.out.println("Fibonacci数列f(" + n + ") = "+l);
    }

    public static long f(int n){
        if(n==0 || n==1){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
}
