/**
 * @author Komorebi
 * @since 2021.09.16.17:37
 */
import java.util.*;
public class 数组合并 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }

        int[] c=new int[n+m];
        int p=0,q=0;
        for(int i=0;i<n+m;i++){
            if(p<n && q<m){
                if(a[p]<b[q]){
                    c[i] = a[p];
                    p++;
                }else{
                    c[i] = b[q];
                    q++;
                }
            }else if(p<n){
                c[i]=a[p];
                p++;
            }else if(q<m){
                c[i]=b[q];
                q++;
            }
        }
/*
        int i=0,j=0,k=0,len1=a.length,len2=b.length;
        while(i<len1&&j<len2){
            if(a[i]<=b[j]){
                c[k++]=a[i++];
            }else{
                c[k++]=b[j++];
            }
        }
        while(i<len1){
            c[k++]=a[i++];
        }
        while(j<len2){
            c[k++]=b[j++];
        }
        for(int i:c){
            System.out.print(i+" ");
        }

 */
        System.out.println();
        sc.close();
    }
}
