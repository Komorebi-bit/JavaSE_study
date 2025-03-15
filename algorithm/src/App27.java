import java.util.Scanner;

/**
 * @author Komorebi
 */
public class App27 {

    static int Ma_x = 99999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, k, d;
        int[] w = new int[201];
        int[][] dp = new int[201][201];

        n = sc.nextInt();
        for (i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            dp[i][i] = 0;
        }
        //核心算法，动态规划
        for (d = 1; d < n; d++) {
            for (i = 1; i <= n - d; i++) {
                j = d + i;
                dp[i][j] = Ma_x;
                for (k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum(i, j, w));
                }
            }
        }
        System.out.println(dp[1][n]);
    }

    public static int sum(int i, int j, int[] w) {
        //i到j的合并花费总和
        int k, s = 0;
        for (k = i; k <= j; k++) {
            s = s + w[k];
        }
        return s;
    }
}