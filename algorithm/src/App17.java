import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最长公共子序列动态规划
 * @author Komorebi
 * @since 2022.10.27.17:27
 */
public class App17 {
    /*
        8 9
        1 3 4 5 6 7 7 8
        3 5 7 4 8 6 7 8 2
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        int[] x, y;
        m = sc.nextInt();
        n = sc.nextInt();
        x = new int[m+1];
        y = new int[n+1];
        for (int i = 1; i <= m; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            y[i] = sc.nextInt();
        }
        //保存最长公共子序列
        List<Integer> lcs = new ArrayList<>();
        subsequences(x, y, lcs);
        System.out.println(lcs.size());
        for (Integer i : lcs) {
            System.out.print(i + " ");
        }
    }

    public static void subsequences(int[] x, int[] y, List<Integer> lcs) {
        int m = x.length-1;
        int n = y.length-1;
        int[][] b = new int[m+1][n+1];
        int[][] c = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }

            }
        }

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (b[i][j] == 1) {
                lcs.add(0,x[i]);
                i--;
                j--;
            } else if (b[i][j] == 2) {
                i--;
            } else {
                j--;
            }
        }

    }
}
