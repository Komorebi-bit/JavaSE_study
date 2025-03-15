import java.util.Scanner;

/**
 * <p>0-1背包问题</p>
 *
 * @author Komorebi
 * @since 2022.11.08.16:02
 */
public class App19 {
/*
5 8
2 1 4 3 5
1 4 2 3 5
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        // 存放装入物品的序号
        int[] t = new int[n + 1];
        int v_max = backpack(n, m, v, w, t);
        System.out.println("装入背包中物品总价值最大为：" + v_max);
        System.out.print("装入的物品的序号为：");
        for (int i = 1; i < t[0]; i++) {
            System.out.print(t[i] + " ");
        }
    }

    public static int backpack(int n, int m, int[] v, int[] w, int[] t) {
        int[][] mm = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            if (w[1] <= j) {
                mm[1][j] = v[1];
            } else {
                mm[1][j] = 0;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 第i的物品，重量大于j
                if (w[i] > j) {
                    mm[i][j] = mm[i - 1][j];
                } else {
                    // 第i物品，重量小于等于j
                    mm[i][j] = max(mm[i - 1][j], mm[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        // 找出物品序号
        int[] tt = new int[n + 1];
        int temp = mm[n][m];
        int mmm = m;
        for (int i = n; i > 0; i--) {
            if (temp > mm[i - 1][mmm]) {
                tt[i] = 1;
                temp -= v[i];
                mmm -= w[i];
            } else {
                tt[i] = 0;
            }
        }
        // 放入数组t中
        int j = 1;
        for (int i = 1; i <= n; i++) {
            if (tt[i] == 1) {
                t[j++] = i;
            }
        }
        t[0] = j;

        return mm[n][m];
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

}
