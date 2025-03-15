import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Komorebi
 * @since 2022.11.20.16:35
 */
public class App22 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1, s2;
        String[] b1 = null, b2 = null;
        try {
            s1 = br.readLine();
            b1 = s1.split(" ");
            s2 = br.readLine();
            b2 = s2.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int n = Integer.parseInt(b1[0]);
        long s = Long.parseLong(b1[1]);
        int[] m = new int[n + 1];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            m[i] = Integer.parseInt(b2[i - 1]);
            sum[i] = sum[i - 1] + m[i];
        }

        // int max = 0;
        // int k = n / 2;
        // for (int i = k; i > 0; i--) {
        //     for (int j = i; j <= n - i; j++) {
        //         if (sum[j] - sum[j - i] <= s && sum[j + i] - sum[j] <= s) {
        //             max = 2 * i;
        //             System.out.println(max);
        //             return;
        //         }
        //     }
        // }

        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (f(mid, n, s, sum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.print(2 * l);
    }

    public static boolean f(int mid, int n, long s, long[] sum) {
        for (int i = mid; i <= n - mid; i++) {
            if (sum[i] - sum[i - mid] <= s && sum[i + mid] - sum[i] <= s) {
                return true;
            }
        }
        return false;
    }
}
