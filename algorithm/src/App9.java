import java.util.Random;

/**
 * @author Komorebi
 * @since 2022.09.28.14:49
 * <p>找最大值和次大值</p>
 */
public class App9 {

    public static void main(String[] args) {
        // Random random = new Random();
        // int[] a = new int[10];
        // System.out.println(">>>>>>>随机生成数组");
        // for(int i=0; i<10; i++){
        //     a[i] = random.nextInt(100);
        //     System.out.print(a[i]+" ");
        // }
        int[] a = {-10,5,86,57,66,98,26,15,32,0};
        System.out.println();
        int[] result = maxAndSubmax(a, 0, a.length - 1);
        System.out.println("最大值：" + result[0] + "  最小值： " + result[1]);
    }

    public static int[] maxAndSubmax(int[] a, int left, int right){
        if(left == right){
            int[] result = new int[1];
            result[0] = a[left];
            return result;
        }
        int mid = (left+right)/2;
        int[] leftResult = maxAndSubmax(a, left, mid);
        int[] rightResult = maxAndSubmax(a, mid + 1, right);
        int[] result = compare(leftResult,rightResult);
        return result;
    }

    public static int[] compare(int[] leftResult, int[] rightResult){
        int[] result = new int[2];
        int i =0, j=0, k=0;
        int len1 = leftResult.length;
        int len2 = rightResult.length;
        while(k < 2 && i<len1 && j<len2){
            if(leftResult[i]>rightResult[j]){
                result[k++] = leftResult[i];
                i++;
            }else{
                result[k++] = rightResult[j];
                j++;
            }
        }
        if(k==1){
            if(i==0){
                result[k] = leftResult[i];
            }else{
                result[k] = rightResult[j];
            }
        }
        return result;
    }
}
