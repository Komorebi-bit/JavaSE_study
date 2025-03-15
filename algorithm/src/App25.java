/*
import java.util.Arrays;
import java.util.Scanner;

*/
/**
 * @author Komorebi
 * @since 2022.12.03.16:26
 *//*


public class App25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        float opt = loading(m, w, x);
        // 最优装载重量为：4.0 最优装载下被选中的集装箱序号为： 0 2 3
        System.out.println("最优装载重量为：" + opt);
        System.out.print("最优装载下被选中的集装箱序号为：");
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static float loading(int m, int[] w, int[] x) {
        int n = w.length;
        Element[] d = new Element[n];
        for (int i = 0; i < n; i++) {
            d[i] = new Element(w[i], i);
        }
        Arrays.sort(d);

        // 装载的总重量
        float opt = 0;
        // 背包剩余容量
        float surplus = m;
        for (int i = 0; i < n; i++) {
            if (d[i].w > surplus) {
                break;
            }
            x[d[i].i] = 1;
            opt += d[i].w;
            surplus -= d[i].w;
        }
        return opt;
    }
}

class Element implements Comparable<Element> {

    public float w;
    public int i;

    public Element(float w, int i) {
        this.w = w;
        this.i = i;
    }

    @Override
    public int compareTo(Element o) {
        if (this.w > o.w) {
            return 1;
        } else if (this.w < o.w) {
            return -1;
        } else {
            return 0;
        }
    }
}
*/
