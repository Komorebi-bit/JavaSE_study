import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * 最长公共子序列
 * </p>
 * @author Komorebi
 * @since 2022.10.26.10:55
 */
public class App16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        int[] x, y;
        m = sc.nextInt();
        n = sc.nextInt();
        x = new int[m];
        y = new int[n];
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
        }

        List<Integer> subsequences = subsequences(x, y, m, n);

        System.out.println(subsequences.size());
        for (Integer s : subsequences) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("答案不唯一。");
    }

    public static List<Integer> subsequences(int[] x, int[] y, int lenx, int leny) {
        List<Integer> list = new ArrayList<>();
        if (lenx == 0 || leny == 0) {
            return list;
        }
        if (x[lenx - 1] == y[leny - 1]) {
            list.add(0, x[lenx - 1]);
            list.addAll(0, subsequences(x, y, lenx - 1, leny - 1));
        } else {
            List<Integer> l1 = subsequences(x, y, lenx, leny - 1);
            List<Integer> l2 = subsequences(x, y, lenx - 1, leny);
            list.addAll(0, l1.size() > l2.size() ? l1 : l2);
        }
        return list;
    }

}
