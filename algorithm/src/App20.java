import java.util.Scanner;

/**
 * <p>二维背包问题</p>
 *
 * @author Komorebi
 * @since 2022.11.9.14:24
 */
public class App20 {
/*
5 8 8
2 1 4 3 5
1 4 2 3 5
2 3 5 2 4
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        int[] b = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }

        // 存放装入物品的序号
        int[] t = new int[n + 1];

        int v_max = backpack(n, c, d, v, w, b, t);

        System.out.println("装入背包中物品总价值最大为：" + v_max);
        System.out.print("装入的物品的序号为：");
        for (int i = 1; i < t[0]; i++) {
            System.out.print(t[i] + " ");
        }

    }

    public static int backpack(int n, int c, int d, int[] v, int[] w, int[] b, int[] t) {
        int[][][] m = new int[n + 1][c + 1][d + 1];
        for (int j = 0; j <= c; j++) {
            for (int k = 0; k <= d; k++) {
                if (w[1] <= j && b[1] <= k) {
                    m[1][j][k] = v[1];
                } else {
                    m[1][j][k] = 0;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                for (int k = 0; k <= d; k++) {

                    if (w[i] <= j && b[i] <= k) {
                        m[i][j][k] = max(m[i - 1][j - w[i]][k - b[i]] + v[i], m[i - 1][j][k]);
                    } else {
                        m[i][j][k] = m[i - 1][j][k];
                    }
                }
            }
        }

        int[] tt = new int[n + 1];
        int temp = m[n][c][d];
        int cc = c, dd = d;
        for (int i = n; i > 0; i--) {
            if (temp > m[i - 1][cc][dd]) {
                tt[i] = 1;
                temp -= v[i];
                cc -= w[i];
                dd -= b[i];
            } else {
                tt[i] = 0;
            }
        }

        int j = 1;
        for (int i = 1; i <= n; i++) {
            if (tt[i] == 1) {
                t[j++] = i;
            }
        }
        t[0] = j;

        return m[n][c][d];
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

}
