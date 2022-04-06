import java.text.DecimalFormat;
import java.util.*;

import java.lang.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//方法参数不允许有默认值
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello java!");
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println("a*b=" + (a * b));
//        System.out.println("a/b=" + (a / b));
//        System.out.printf("%10d", a);
        DecimalFormat df = new DecimalFormat("#.000");
        double d = 25.12;
        System.out.println(df.format(d));

    }
}
