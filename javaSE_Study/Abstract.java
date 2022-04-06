import java.util.Scanner;
/**
 *@author Komorebi
 * 抽象类
 * 接口
 * 变量名 instanceof 类名   //判断变量是不是属于某个类
 * 普通方法为虚方法
 */
public abstract class Abstract {
    public abstract void area();
    public abstract void girth();
}
interface myInterFace{
    double PI = 3.1415926;   //
    void putR();
    default void method(){} //1.8 有函数体
    static void function(){} //1.8  静态方法；
}
class circle extends Abstract implements myInterFace{
    //final static double PI=3.1415926;
    private double r;
    circle(double r){
        this.r=r;
    }
    public void area(){
        System.out.println("area: "+PI*r*r);
    }
    public void girth(){
        System.out.println("girth: "+2*PI*r);
    }
    public void putR(){
        System.out.println("r= "+r);
    }
    public static void main(String[] args) {
        Abstract ab;
        circle c = new circle(1.0);
        ab = c;
        ab.area();
        ab.girth();
        c.putR();
        System.out.println(c instanceof circle);
    }
}