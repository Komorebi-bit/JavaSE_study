import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.09.13.17:43
 * 改进二分搜索算法
 */
public class App4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
                  // 0,1,2,3,4, 5, 6, 7, 8, 9
        int[] arr = {2,4,6,8,10,12,14,16,18,20};
        int[] index = f(arr,x,10);
        System.out.println("["+index[0]+","+index[1]+"]");
    }

    public static int[] f(int[] arr, int x, int len){
        int left = 0;
        int right = len - 1;
        int[] index = {-1,-1};
        while(left <= right){
            int mid = (left+right)/2;
            if(x == arr[mid]){
                index[0]=mid;
                index[1]=mid;
                break;
            }
            if(x < arr[mid]){
                index[1]=mid;
                right = mid-1;
                continue;
            }
            if(x > arr[mid]){
                index[0]=mid;
                left = mid+1;
                continue;
            }
        }
        return index;
    }
}
