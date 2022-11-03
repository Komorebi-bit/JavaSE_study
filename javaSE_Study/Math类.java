/**
 * @author Komorebi
 * 静态方法
 * PI 兀
 * E 自然对数e
 * scalb(float/double a, int sf) 在lang包内
 * 表示a×(2^sf)  //infinity 无穷大
 * sin(double x);
 * cos(double x);
 * tan(double x);
 * com.log(double x);  //自然对数e
 * log10(double x);
 * acos(double x);
 * asin(double x);
 * atan(double x);
 * atan2(double y,double x); //将矩形坐标(x,y)转换成极坐标(r,theta),返回所得角theta
 */

import java.lang.Math;

public class Math类 {
    public static void main(String[] args) {
        System.out.println(Math.scalb(5, 0));
        System.out.println(Math.abs(-12.5)); //绝对值
        System.out.println(Math.sqrt(64.0)); //平方根
        System.out.println(Math.max(12, 56));
        System.out.println(Math.min(12, 56));
        System.out.println(Math.random());
        System.out.println(Math.pow(2, 8)); //幂
        System.out.println(Math.ceil(12.56)); //向上取整
        System.out.println(Math.floor(12.56)); //向下取整
        System.out.println(Math.round(11.5)); //四舍五入  =>Math.floor(x+0.5)
        System.out.println(Math.PI / 4 == Math.atan2(1, 1));
        System.out.println(Math.PI);
    }
}
