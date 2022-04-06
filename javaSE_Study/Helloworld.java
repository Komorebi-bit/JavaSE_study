import java.util.Scanner;
import java.lang.String;

/**
 * @author Komorebi
 * 标识符 必须以字母, _ ,$开头
 * JDK1.7 支持用_分割字符 例如 int a = 100 000;
 * switch(a) a必须为int bybe char short,1.7以后支持String
 * 创建自定义类数组时，并没有为每一项数组创建分配空间;
 */
public class Helloworld {
    final static double PI = 3.1415;

    //byte 1字节, short 2字节, int 4字节, long 8字节
    //float 4字节, double 8字节
    //char 2字节
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        if ((a & 1) == 1) {
            System.out.println("a是奇数");
        } else {
            System.out.println("a是偶数");
        }
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
        //final int e = 2;
        //Scanner sc = new Scanner(System.in);
        //int b = 5, a = 0;
        //System.out.print("输入字符串: ");
        //String name = sc.next();
        //boolean bool = a < b;
        //if (bool) {
        //    a = a * e;
        //} else {
        //    b = e;
        //}
        //System.out.println("circle: s= " + PI * 1 * 1);
        //char c = 'a';
        //System.out.print((int) c);
        //double f = 1.2356;
        //System.out.format("% .2f", f);//四舍五入 printf  Math.round(2.55)
        //sc.close();
    }
}
