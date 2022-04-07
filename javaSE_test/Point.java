/**
 * @author Komorebi
 * @since 2021.09.30.17:03
 */
import java.util.*;
public class Point {
    private int x,y;
    public Point(){
        x=0;
        y=0;
    }
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x1,y1,x2,y2;
        System.out.println("输入第一个点的坐标");
        x1=sc.nextInt();
        y1=sc.nextInt();
        System.out.println("输入第二个点的坐标");
        x2=sc.nextInt();
        y2=sc.nextInt();
        Point p1 = new Point(x1,y1),p2=new Point(x2,y2);
        System.out.println("两点之间的距离: "+distance(p1,p2));
        sc.close();
    }
    static double distance(Point p1,Point p2){
        double d=Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
        return d;
    }
}
