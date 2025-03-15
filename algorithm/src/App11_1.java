import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.11.20.15:19
 */
public class App11_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long start = System.nanoTime();
        mergeSort(a);
        long end = System.nanoTime();
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println((end - start) / 1000.0 + " ms");
    }

    // 归并算法，非递归
    public static void mergeSort(int[] a) {
        int h = 1;
        while (h < a.length) {
            sort(a, h);
            h = 2 * h;
        }
    }

    public static void sort(int[] a, int h) {
        int i = 0;
        while (i + 2 * h <= a.length) {
            merge(a, i, i + h - 1, i + 2 * h - 1);
            i = i + 2 * h;
        }
        if (i + h < a.length) {
            merge(a, i, i + h - 1, a.length - 1);
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }

        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        for (k = 0; k < temp.length; k++) {
            a[left++] = temp[k];
        }
    }
}
