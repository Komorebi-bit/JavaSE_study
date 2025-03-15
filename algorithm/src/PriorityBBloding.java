/*

 */
/**
 * @author Komorebi
 * @since 2022.12.06.22:42
 *//*



public class PriorityBBloding {

    // 优先队列式分支限界法，返回最优载重量 bestx返回最优解
    static MaxHeap heap = new MaxHeap();
    static int n;// 集装箱数量

    static class BBNode// 解空间树的结点类
    {

        BBNode parent; // 指向父结点的指针
        boolean leftChild; // 左儿子结点标志

        BBNode(BBNode par, boolean ch) {
            parent = par;
            leftChild = ch;
        }
    }

    static class HeapNode implements Comparable// 堆的元素类型类
    {

        BBNode liveNode; // 指向活结点在子集树中相应结点的指针
        int uweight; // 活结点优先级（上界）
        int level; // 活结点在子集树中所处的层序号

        HeapNode(BBNode node, int up, int lev) {// 构造方法
            liveNode = node;
            uweight = up;
            level = lev;
        }

        public int compareTo(Object x) {
            int xuw = ((HeapNode) x).uweight;
            if (uweight < xuw) {
                return -1;
            }
            if (uweight == xuw) {
                return 0;
            }
            return 1;
        }

        public boolean equals(Object x) {
            return uweight == ((HeapNode) x).uweight;
        }
    }

    // 从该方法可以看出该解法只是构建部分解空间树
    private static void addLiveNode(int up, int lev, BBNode par,
        boolean ch)// 将一个新产生的BBNode类型活结点加入到子集树中，并将这个新结点插入到表示活结点优先队列的最大堆中
    {// 将一个新产生的活结点插入到表示活结点优先队列的最大堆中
        BBNode b = new BBNode(par, ch);
        HeapNode node = new HeapNode(b, up, lev);
        heap.insert(node);
    }

    // 用于存放活结点的最大堆类


    public static int maxLoading(int[] w, int c, int[] bestx) {
        // 初始化
        BBNode A = null;
        BBNode e = A;        // 当前扩展结点
        int i = 1;                     // 当前扩展结点所处的层
        int ew = 0;                    // 扩展结点所相应的载重量
        int[] r = new int[n + 1];        // 定义剩余重量数组r
        for (int j = n - 1; j >= 0; j--) {
            r[j] = r[j + 1] + w[j + 1];
        }

        // 搜索子集空间树
        while (i != n + 1) {// 非叶结点，检查当前扩展结点的儿子结点
            if (ew + w[i] <= c)
            // 左儿子结点为可行结点
            {
                addLiveNode(ew + w[i] + r[i], i + 1, e, true);
            }
            // 右儿子结点总为可行结点
            addLiveNode(ew + r[i], i + 1, e, false);
            // 取下一个扩展结点
            HeapNode node = (HeapNode) heap.removeMax();
            i = node.level;
            e = node.liveNode; // 下一扩展结点
            ew = node.uweight - r[i - 1];
        }
        for (int j = n; j > 0; j--) {// 构造当前最优解
            bestx[j] = (e.leftChild) ? 1 : 0;
            e = e.parent;
        }
        return ew;
    }

    public static void main(String[] args) {
        n = 4;// 集装箱个数
        int[] w = {0, 20, 10, 26, 15};// 集装箱重量
        int c = 70;// 轮船载重量
        int[] bestx = new int[n + 1];// 最优解
        int a = maxLoading(w, c, bestx);
        System.out.println("最优载重量为：" + a);
        System.out.println("最优解为：");
        for (int i = 1; i < n + 1; i++) {
            System.out.print(bestx[i] + " ");
        }

    }
}

*/
