/**
 * @author Komorebi
 * @since 2021.09.30.16:46
 */
import java.util.*;
public class Box1 {
    private double height;
    private double width;
    private double length;
    public Box1(){
        height=0.0;
        width=0.0;
        length=0.0;
    }
    public Box1(double h, double w, double l){
        height=h;
        width=w;
        length=l;
    }
    public double volume(){
        return height*width*length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double h,w,l;
        h=sc.nextDouble();
        w=sc.nextDouble();
        l=sc.nextDouble();
        Box1 box1 =new Box1(h,w,l);
        System.out.println(box1.volume());
        sc.close();
  }
}
