import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.12.03.21:51
 */
public class App26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ret = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ret[i] = sc.nextInt();
            sum += ret[i];
        }
        int ans = count(n, ret, sum);
        System.out.println(ans);
    }

    public static int count(int n, int[] weight, int sum) {
        boolean[][] mat = new boolean[n + 1][sum + 1];
        mat[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // 如果第 i - 1 个砝码能称出 j 的重量，则进入if
                if (mat[i - 1][j]) {
                    // 直接设置成true（代表 j 可以被称出）
                    mat[i][j] = true;
                    // 同时 j + w[i-1] 的重量也可以被称出
                    mat[i][j + weight[i - 1]] = true;
                    // 大的重量减小的，就不会越界
                    if (j > weight[i - 1]) {
                        mat[i][j - weight[i - 1]] = true;
                    } else {
                        mat[i][weight[i - 1] - j] = true;
                    }
                }
            }
        }
        // 统计最后一行的 true 的个数 （第0列不算在内）
        int ans = 0;
        for (int i = 1; i <= sum; i++) {
            if (mat[n][i]) {
                ans++;
            }
        }
        return ans;
    }

}
