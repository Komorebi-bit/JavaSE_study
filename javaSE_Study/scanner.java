import java.util.Scanner;

/**
 * author Komorebi
 * next()
 * 一定要读取到有效字符才结束输入
 * 对输入有效字符之前遇到的空白, 自动忽略
 * 不能得到带有空格的字符串
 * nextLine()
 * 返回的是输入回车之前的所有字符
 * 可以得到空格
 * boolean hasNext(Pattern pattern)
 * 判断输入的数据是否符合指定的正则标准
 * boolean hasNextInt()
 * 判断输入的是否是整数，是，则返回true
 * Scanner useDelimiter(String patterm)
 * 设置读取的分隔符
 */
public class scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("int: ");
        int i = sc.nextInt();
        System.out.print("long: ");
        long l = sc.nextLong();
        System.out.print("String: ");
        String s = sc.next();
        System.out.print("double: ");
        double d = sc.nextDouble();
        System.out.print("float: ");
        float f = sc.nextFloat();
        System.out.print("boolean: ");
        boolean b = sc.nextBoolean();
        System.out.println("---------------------");
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("String: " + s);
        System.out.println("double: " + d);
        System.out.println("float: " + f);
        System.out.println("boolean: " + b);
        //    int i=0;
        //    double d=0.0;
        //    String s=" ";
        while (sc.hasNextInt()) {
            i = sc.nextInt();
            System.out.println(i);
        }
        while (sc.hasNextDouble()) {
            d = sc.nextDouble();
            System.out.println(d);
        }
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            System.out.println(s);
        }
        System.out.println(i + " " + d + " " + s);
        sc.close();
    }
}
