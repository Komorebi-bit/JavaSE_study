/**
 * @author Komorebi
 * @since 2021.09.16.15:30
 */
import java.util.Arrays;
public class ArayyCopy {
    public static void main(String[] args){
        int[] arr = new int[5];
        int[] arr1 ={1,2,3,4,5};
        for(int i=0;i<5;i++){
            arr[i]=arr1[i];
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] arr2 = new int[]{10,12,14,16,18};
        arr=arr2.clone();
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] arr3 = {11,22,33,44,55};
        System.arraycopy(arr3,0,arr,0,5);
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] arr4 = {6,66,666,6666,66666};
        arr=Arrays.copyOf(arr4,5);
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
