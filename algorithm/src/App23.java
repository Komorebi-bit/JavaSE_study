import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.12.01.19:08
 */


public class App23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        perm(arr, 0, n - 1, sum);
    }

    public static boolean perm(int[] arr, int k, int m, int sum) {
        if (k == m) {
            if (num(arr, m + 1, sum)) {
                for (int i = 0; i <= m; i++) {
                    System.out.print(arr[i] + " ");
                }
                return true;
            }
            return false;
        } else {
            for (int i = k; i <= m; i++) {
                swap(arr, k, i);
                if (perm(arr, k + 1, m, sum)) {
                    return true;
                }
                swap(arr, k, i);
            }
        }
        return false;
    }

    public static boolean num(int[] arr, int n, int sum) {
        int[] a = arr.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                a[j] = a[j] + a[j + 1];
            }
        }
        return a[0] == sum;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
