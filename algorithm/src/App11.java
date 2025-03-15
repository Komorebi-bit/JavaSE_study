import java.util.Random;

/**
 * @author Komorebi
 * @since 2022.09.29.15:57
 * <p>非递归归并算法</p>
 */
public class App11 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        System.out.println(">>>>>>>原数组：");
        for(int i=0; i<10; i++){
            a[i] = random.nextInt(100);
            System.out.print(a[i]+" ");
        }
        System.out.println();

        // int[] a = {10,8,5,3,7,9,2,4,6,1};

        mergeSort(a);

        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //归并算法，非递归
    public static void mergeSort(int[] a){
        int h=1;
        while (h<a.length){
            sort(a,h);
            h=2*h;
        }
    }

    public static void sort(int[] a,int h){
        int i = 0;
        while (i+2*h<=a.length){
            merge(a,i,i+h-1,i+2*h-1);
            i=i+2*h;
        }
        if(i+h<a.length){
            merge(a,i,i+h-1,a.length-1);
        }
    }

    public static void merge(int[] a, int left,int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1, k = 0;
        while(i<=mid && j<=right){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }

        }
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=right){
            temp[k++] = a[j++];
        }
        for(k=0; k<temp.length; k++){
            a[left++] = temp[k];
        }
    }
}
