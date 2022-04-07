/**
 * @author Komorebi
 * @since 2021.09.09.21:04
 */
import java.util.*;
public class 星号三角形 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = n-1;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<m;j++){
                System.out.print(" ");
            }
            for(int k=0;k<n-m;k++){
                System.out.print("*");
            }
            System.out.println();
            m=m-2;
        }
        sc.close();
    }
}
