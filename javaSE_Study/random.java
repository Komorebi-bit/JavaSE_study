import java.util.Scanner;
import java.util.Random;
import java.lang.String;

/**
 * @author Komorebi
 * 随机数练习
 * 1 Math类
 * Math.random范围[0.0,1);
 * 2 Random类(非静态方法);
 * public int nextInt();
 * public int nextInt(n) 返回大于等于0且小于n的随机整数;
 * public long nextLong();
 * public boolean nextBoolean();
 * public float nextFloat();
 * public double nextDouble();
 * public double nextGaussian()返回一个概率密度为高斯分布的双精度值;
 */
public class random {
    public static void main(String[] args) {
        double result = Math.random();
        System.out.println("随机数: " + result);
        int left, right;
        Scanner sc = new Scanner(System.in);
        left = sc.nextInt();
        right = sc.nextInt();
        System.out.println(left + "到" + right + "随机数: " + getRandom(left, right));
        System.out.println();

        Random r = new Random();
        System.out.println(r.nextInt(10));
        System.out.println(r.nextDouble());
        System.out.println(getRandomString(10));
        sc.close();
    }

    /*
     *获取随机数
     * @param l,r取值范围
     */
    public static int getRandom(int l, int r) {
        int result = (int) (l + Math.random() * (r - l + 1));
        return result;
    }

    /*
     * 随机生成字符串
     * @param len 随机字符串长度
     */
    public static String getRandomString(int len) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int num = r.nextInt(base.length() + 1);
            s.append(base.charAt(num));
        }
        return s.toString();
    }
}
