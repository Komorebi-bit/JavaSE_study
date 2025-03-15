import java.util.Random;

/**
 * @author Komorebi
 * @since 2022.09.27.19:51
 * <p>求逆序对总个数</p>
 */
public class App8 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        System.out.println(">>>>>>>原数组：");
        for(int i=0; i<10; i++){
            a[i] = random.nextInt(100);
            System.out.print(a[i]+" ");
        }
        // int[] a = {10,9,8,7,6,5,4,3,2,1};  //45
        System.out.println();
        System.out.println(">>>>>>>逆序对总个数");

        int count = sort(a, 0, a.length - 1);

        System.out.println(count);
        System.out.println(">>>>>>>排好序的数组");
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static int sort(int[] a,int left, int right){
        if(left == right){
            return 0;
        }
        int mid = (left+right)/2;
        int leftCount = sort(a, left, mid);
        int rightCount = sort(a,mid+1,right);
        int mergeCount = merge(a, left, mid, right);
        return mergeCount+leftCount+rightCount;
    }

    public static int merge(int[] a, int left,int mid, int right){
        int count = 0;
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1, k = 0, o=mid-left+1;
        while(i<=mid && j<=right){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
                o--;
                // count++;
            }else {
                temp[k++] = a[j++];
                count += o;
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
        return count;
    }
}
