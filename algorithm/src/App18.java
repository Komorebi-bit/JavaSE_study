import java.util.Scanner;

/**
 * 电路布线
 * @author Komorebi
 * @since 2022.10.26.21:43
 */
public class App18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        /* int n = 10;
        //第一位不用
        int[] a = {0, 8, 7, 4, 2, 5, 1, 9, 3, 10, 6}; */
        int[][] size = new int[n + 1][n + 1];
        MNS(a, n, size);
        System.out.println("电路布局最大不相交连线数：" + size[n][n]);

        int[] net = new int[n];
        int m = size[n][n];
        traceback(a, n, size, net);
        for (int i = m - 1; i >= 0; i--) {
            System.out.print("<" + net[i] + "," + a[net[i]] + ">" + " ");
        }
    }

    /*
           8, 7, 4, 2, 5, 1, 9, 3, 10, 6
       i   1 2 3 4 5 6 7 8 9 10

     Pi(i) 1 2 3 4 5 6 7 8 9 10
     */
    public static void MNS(int[] a, int n, int[][] size) {
        for (int i = 1; i < n + 1; i++) {
            size[i][0] = 0;
        }

        for (int j = a[1]; j < n + 1; j++) {
            size[1][j] = 1;
        }

        for (int i = 2; i < n; i++) {
            //j<a[i]时
            for (int j = 0; j < a[i]; j++) {
                size[i][j] = size[i - 1][j];
            }
            //j>=a[i]时
            for (int j = a[i]; j < n + 1; j++) {
                size[i][j] = max(size[i - 1][a[i] - 1] + 1, size[i - 1][j]);
            }
        }
        size[n][n] = max(size[n - 1][a[n] - 1] + 1, size[n - 1][n]);

    }

    public static void traceback(int[] a, int n, int[][] size, int[] net) {
        int j = n, m = 0;
        for (int i = n; i > 1; i--) {
            //此时，(i,a[i])是最大不相交子集的一条边
            if (size[i][j] != size[i - 1][j]) {
                net[m++] = i;
                //更新扩展连接柱区间
                j = a[i] - 1;
            }

        }
        //处理i=1的情形
        if (j >= a[1]) {
            net[m++] = 1;
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
