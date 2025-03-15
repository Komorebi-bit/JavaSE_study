/**
 * @author Komorebi
 * @since 2022.09.27.16:33
 * n个数的全排列问题
 */
public class App5 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        perm(a,0,a.length-1);
    }

    public static void perm(int[] a, int k, int m){
        if(k == m){
            for(int i = 0; i <= m; i++){
                System.out.print(a[i]);
            }
            System.out.println();
        }else{
            for(int i = k; i <= m; i++){
                swap(a,k,i);
                perm(a,k+1,m);
                swap(a,k,i);
            }
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
