import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.11.20.15:44
 */
public class App21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][n];
        // int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
                // dp[i][j] = 0;
            }
        }
        // dp[0][0] = num[0][0];
        for (int i = 1; i < n; i++) {
            num[i][0] = num[i - 1][0] + num[i][0];
            num[0][i] = num[0][i - 1] + num[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                num[i][j] = Math.max(num[i - 1][j], num[i][j - 1]) + num[i][j];
            }
        }
        System.out.println(num[n - 1][n - 1]);
    }
}
