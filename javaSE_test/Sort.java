/**
 * @author Komorebi
 * @since 2021.09.15.20:20
 */
import java.util.*;
public class Sort {
    private String name;
    private int score;
    public Sort[] sort(Sort[] s,int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(s[j].score<s[j+1].score){
                    Sort temp = s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp;
                }
            }
        }
        return s;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        Sort[] student = new Sort[n];
        for(int i =0;i<n;i++){
            student[i] = new Sort();
            student[i].name = sc.next();
            student[i].score = sc.nextInt();
        }
        student = (new Sort()).sort(student,n);
        for(Sort i:student){
            System.out.printf("%15s %5d ",i.name,i.score);
            System.out.println();
        }
        System.out.println();
        sc.close();
    }
}