import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.11.20.15:08
 */
public class App7_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long start = System.nanoTime();
        sort(a, 0, a.length - 1);
        long end = System.nanoTime();
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println((end - start) / 1000.0 + " ms");
    }

    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = qs(a, left, right);
        sort(a, left, pivot - 1);
        sort(a, pivot + 1, right);
    }

    public static int qs(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && temp <= a[right]) {
                right--;
            }
            a[left] = a[right];
            while (left < right && temp >= a[left]) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }

}
