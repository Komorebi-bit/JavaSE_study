import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.12.03.14:43
 */

public class App24 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        float[] x = new float[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        float opt = knapsack(m, w, v, x);
        System.out.println("背包中物品的最大价值为: " + opt);
        for (int i = 0; i < n; i++) {
            if (x[i] > 0) {
                System.out.println("第" + (i + 1) + "个物品：" + x[i] + "个");
            }
        }
    }

    public static float knapsack(int m, int[] w, int[] v, float[] x) {
        int n = w.length;
        Element[] d = new Element[n];
        for (int i = 0; i < n; i++) {
            d[i] = new Element(w[i], v[i], i);
        }
        // 按照物品单位重量的价值降序排列
        Arrays.sort(d, (a, b) -> {
            if ((1.0 * a.v / a.w) - (1.0 * b.v / b.w) > 0) {
                return -1;
            } else if ((1.0 * a.v / a.w) - (1.0 * b.v / b.w) < 0) {
                return 1;
            } else {
                return 0;
            }
        });
        // 装入的总价值
        float opt = 0;
        // 背包剩余容量
        float surplus = m;

        int i = 0;
        for (i = 0; i < n; i++) {
            if (d[i].w > surplus) {
                break;
            }
            x[d[i].i] = 1;
            opt += d[i].v;
            surplus -= d[i].w;
        }

        if (i < n) {
            x[d[i].i] = (float) (1.0 * surplus / d[i].w);
            opt += x[d[i].i] * d[i].v;
        }
        return opt;
    }
}

// 记录每个物品的重量和价值
class Element {

    public float w;
    public float v;
    public int i;

    public Element(float w, float v, int i) {
        this.w = w;
        this.v = v;
        this.i = i;
    }

}
