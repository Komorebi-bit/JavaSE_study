import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2021.09.09.17:20
 */
public class Switch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double s = sc.nextDouble();
        int a=0;
        if(s<1000){
            a=1;
        }else if(s<2000){
            a=2;
        }else if(s<3000){
            a=3;
        }else if(s<4000){
            a=4;
        }else{
            a=5;
        }
        double t=0;
        switch(a){
            case 1:t=0;break;
            case 2:t=0.1;break;
            case 3:t=0.15;break;
            case 4:t=0.2;break;
            case 5:t=0.25;break;
            default:System.out.println("错误");
        }
        System.out.printf("%.2f",s-s*t);
    }
}
