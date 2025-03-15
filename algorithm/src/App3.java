import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.09.13.17:17
 * 二分查找法
 */
public class App3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int index = f(arr,x,10);
        System.out.println(index);
    }

    public static int f(int[] arr,int x,int len){
        //if (left > right){
        //    return -1;
        //}
        //int mid = (left+right)/2;
        //if(x == arr[mid]){
        //    return mid;
        //}
        //if(x < arr[mid]){
        //    return f(arr,left,mid-1);
        //}
        //if(x > arr[mid]){
        //    return f(arr,mid+1,right);
        //}
        int left = 0;
        int right = len-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(x == arr[mid]){
                return mid;
            }
            if(x > arr[mid]){
                left = mid + 1;
            }
            if(x < arr[mid]){
                right = mid - 1;
            }
        }
        return -1;
    }
}
