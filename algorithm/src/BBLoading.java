import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2022.12.06.21:11
 */
// 装载问题 优先队列式分支限界法
public class BBLoading {

    private static MaxHeap<HeapNode> heap;

    private static class BBNode {

        BBNode parent;
        boolean leftChild;

        BBNode(BBNode parent, boolean leftChild) {
            this.parent = parent;
            this.leftChild = leftChild;
        }

    }

    static class HeapNode implements Comparable<HeapNode> {

        BBNode liveNode;
        int uweight;
        int level;

        public HeapNode(BBNode liveNode, int uweight, int level) {
            this.liveNode = liveNode;
            this.uweight = uweight;
            this.level = level;
        }

        @Override
        public int compareTo(HeapNode o) {
            int ouw = o.uweight;
            if (uweight < ouw) {
                return -1;
            }
            if (uweight == ouw) {
                return 0;
            }
            return 1;
        }

        public boolean equals(HeapNode o) {
            return uweight == o.uweight;
        }
    }

    private static void addLiveNode(int up, int lev, BBNode parent, boolean leftChild) {
        BBNode b = new BBNode(parent, leftChild);
        HeapNode node = new HeapNode(b, up, lev);
        heap.insert(node);
    }

    public static int maxLoading(int[] w, int c, int[] bestx) {
        heap = new MaxHeap<>();
        int n = w.length - 1;
        BBNode e = null;
        int i = 1;
        int ew = 0;

        int[] r = new int[n + 1];
        for (int j = n - 1; j >= 0; j--) {
            r[j] = r[j + 1] + w[j + 1];
        }
        while (i != n + 1) {
            if (ew + w[i] <= c) {
                addLiveNode(ew + w[i] + r[i], i + 1, e, true);
            }
            addLiveNode(ew + r[i], i + 1, e, false);
            HeapNode node = heap.removeMax();
            i = node.level;
            e = node.liveNode;
            ew = node.uweight - r[i - 1];

        }
        for (int j = n; j > 0; j--) {
            bestx[j] = e.leftChild ? 1 : 0;
            e = e.parent;
        }
        return ew;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] w = new int[n + 1];
        int[] bestx = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        int bestw = maxLoading(w, c, bestx);

        System.out.println(bestw);
        for (int i = 1; i <= n; i++) {
            System.out.print(bestx[i] + " ");
        }
    }
}
