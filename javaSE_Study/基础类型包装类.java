/**
 * @author Komorebi
 * char 支持2^16种字符包括汉字及希腊字符等;
 * 基本数据类型   包装数据类型
 * byte         Byte        [-128,127] [-2^7,2^7-1]
 * short        Short       [-32768,32767]  [-2^15,2^15-1]
 * int          Integer     [-21 4748 3648,21 4748 3647] [-2^31,2^31-1]
 * long    0L   Long        [-2^63,2^63-1] [-922 3372 0368 5477 5808,~-1]
 * float  0.0F  Float       32位
 * double       Double      64位
 * char         Character
 * boolean       Boolean
 * 包装类 BigInteger 支持任意精度的整数, BigDecimal 支持任意精度带小数点的运算;
 * 所有的包装类对象之间值的比较, 全部使用equals方法, 对于Integer var = ? 在-128~127之间的
 * 赋值, Integer 对象是在IntegerCache.cahche产生, 会复用已有对象, 这个区间内的Integer值可以
 * 直接使用==进行判断, 但是这个区间之外的所有数据, 都会在堆上产生, 并不会复用已有对象, 这是一个大
 * 坑, 推荐使用equals方法进行判断
 * 自动类型转换
 * bybe->short->int->long
 * char->int
 * int->double
 * float->double
 * 强制类型转换
 * int->float
 * long->float
 * long->double
 */

import java.math.BigDecimal;

public class 基础类型包装类 {
    public static void main(String[] args) {
        long l = 100l;
        float f = 1.2f;

        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        System.out.println("-----------------");

        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        System.out.println("-----------------");

        /**-------浮点数比较大小--------*/
        //(1) 指定一个误差范围, 两个浮点数的差值再次范围之内则认为是相等的.
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        float diff = 1e-6f;
        System.out.println(a == b);   //false
        System.out.println(Math.abs(a - b) < diff);  //true
        //(2) 使用BigDecimal来定义值,在进行浮点数的运算
        BigDecimal A = new BigDecimal("1.0");
        BigDecimal B = new BigDecimal("0.9");
        BigDecimal C = new BigDecimal("0.8");
        BigDecimal x = A.subtract(B);
        BigDecimal y = B.subtract(C);
        System.out.println(x.equals(y));

        //为了防止精度损失, 禁止使用构造方法BigDecimal(Double)的方法把double的值转化为BigDecimal对象
        // BigDecimal g = new BigDecimal(0.1f);实际的储存值为:0.10000000149
        //错误写法
        BigDecimal m = new BigDecimal(0.1);
        System.out.println(m);
        double d = 0.1;
        BigDecimal n = new BigDecimal(d);
        System.out.println(n);
        //正确写法
        BigDecimal M = new BigDecimal("0.1");
        BigDecimal N = BigDecimal.valueOf(0.1);
        System.out.println(M + "  " + N);

        System.out.println("-----------------");
        char c = '我';
        System.out.println(c);

    }
}
