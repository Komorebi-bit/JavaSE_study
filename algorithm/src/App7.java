import java.util.Random;

/**
 * @author Komorebi
 * @since 2022.09.27.17:50
 * <p>快速排序</p>
 */
public class App7 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for(int i=0; i<10; i++){
            a[i] = random.nextInt(100);
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("<<<<<");

        sort(a, 0, a.length - 1);

        for (int i: a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void sort(int[] a, int left, int right){
        if(left >= right) {
            return;
        }
        int pivot = qs(a, left, right);
        sort(a, left, pivot-1);
        sort(a, pivot + 1, right);
    }

    public static int qs(int[] a, int left, int right){
        int temp = a[left];
        while(left<right) {
            while (left<right && temp <= a[right]) {
                right--;
            }
            a[left] = a[right];
            while (left<right && temp >= a[left]) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }


}
