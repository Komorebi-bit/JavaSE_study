import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.12.06.16:37
 */
// 装载问题，队列式分支限界法
public class FIFOBBLoading {

    static int n;
    static int bestw;  // 当前最优载重量
    static ArrayQueue<QNode> queue;  // 活结点队列
    static QNode bestE;   // 当前最优扩展结点
    static int[] bestx;   // 当前最优解

    private static class QNode {

        QNode parent;
        boolean leftChild;
        int weight;

        private QNode(QNode parent, boolean leftChild, int weight) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.weight = weight;
        }
    }

    private static void enQueue(int wt, int i, QNode parent, boolean leftChild) {
        if (i == n) {
            if (wt == bestw) {
                bestE = parent;
                bestx[n] = leftChild ? 1 : 0;
            }
            return;
        }
        QNode b = new QNode(parent, leftChild, wt);
        queue.put(b);
    }

    public static int maxLoading(int[] w, int c, int[] xx) {
        n = w.length - 1;
        bestw = 0;
        queue = new ArrayQueue<>();
        queue.put(null);   // 尾部标志
        QNode e = null;
        bestE = null;
        bestx = xx;

        int i = 1;   // 扩展结点在的层
        int ew = 0;  // 扩展结点的载重量
        int r = 0;   // 剩余集装箱重量
        for (int j = 2; j <= n; j++) {
            r += w[j];
        }

        while (true) {
            int wt = ew + w[i];
            if (wt <= c) {
                if (wt > bestw) {
                    bestw = wt;
                }
                enQueue(wt, i, e, true);
            }
            if (ew + r > bestw) {
                enQueue(ew, i, e, false);
            }
            e = queue.remove();
            if (e == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.put(null);
                e = queue.remove();
                i++;
                r -= w[i];
            }
            ew = e.weight;
        }

        // 最优解
        for (int j = n - 1; j > 0; j--) {
            bestx[j] = bestE.leftChild ? 1 : 0;
            bestE = bestE.parent;
        }
        return bestw;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] w = new int[n + 1];
        int[] xx = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        int bestw = maxLoading(w, c, xx);

        System.out.println(bestw);
        for (int i = 1; i <= n; i++) {
            System.out.print(bestx[i] + " ");
        }
    }
}
