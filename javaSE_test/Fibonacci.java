/**
 * @author Komorebi
 * @since 2021.09.15.19:57
 */
public class Fibonacci {
    public static void main(String[] args){
        int[] arr = new int[20];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<20;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(fibonacci());
    }
    static int fibonacci(){
        int a=1,b=1,c=0,count=2;
        while(c<2178309){
            c=a+b;
            count++;
            if(c==2178309){
                return count;
            }
            a=b;
            b=c;
        }
        return -1;
    }
}