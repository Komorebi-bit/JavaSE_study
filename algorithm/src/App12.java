import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.10.11.16:06
 */
public class App12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[][] m = new int[n+1][n+1];
        for(int i =0; i<=n; i++){
            a[i] = sc.nextInt();
        }
        matrix(a,m);
        System.out.println(m[1][n]);

    }
    public static void matrix(int[] a, int[][]m){
        int n = a.length-1;
        for(int i = 1; i <=n; i++){
            m[i][i] = 0;
        }
        for(int r = 2; r <= n; r++){
            for(int i=1; i<=n-r+1; i++){
                int j = i+r-1;
                m[i][j] = m[i+1][j]+a[i-1]*a[i]*a[j];
                for(int k =i+1; k<j; k++){
                    int t = m[i][k] + m[k+1][j] + a[i-1]*a[k]*a[j];
                    if(t<m[i][k]){
                        m[i][k]=t;
                    }
                }
            }
        }

    }
}
