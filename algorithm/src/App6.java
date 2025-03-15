/**
 * @author Komorebi
 * @since 2022.09.27.17:07
 * <p>求最大字段和</p>
 */
public class App6 {

    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, -2};
        int maxSum = maxSumDIV(a,0,a.length-1);
        System.out.println(maxSum);
    }

    public static int maxSumDIV(int[] a, int l, int r) {
        int k, sum = 0;
        if (l == r) {
            return a[l] >= 0 ? a[l] : 0;
        } else {
            int center = (l + r) / 2;
            int lsum = maxSumDIV(a, l, center);
            int rsum = maxSumDIV(a, center + 1, r);

            int s1 = 0;
            int lefts = 0;
            for (k = center; k >= l; k--)
            {
                lefts += a[k];
                if (lefts > s1) {
                    s1 = lefts;
                }
            }

            int s2 = 0;
            int rights = 0;
            for (k = center + 1; k <= r; k++)
            {
                rights += a[k];
                if (rights > s2) {
                    s2 = rights;
                }
            }
            sum = s1 + s2;
            if (sum < lsum) {
                sum = lsum;
            }
            if (sum < rsum) {
                sum = rsum;
            }
        }
        return sum;
    }
}
