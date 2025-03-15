
public class MaxHeap<T extends Comparable<T>> {

    private final T[] data;// 最大堆的存储空间
    private final int front;// 堆顶引用，若堆不空，指向堆顶元素
    private int rear;// 堆尾引用，若堆不空，指向堆尾元素的下一个位置

    @SuppressWarnings("unchecked")
    public MaxHeap() {// 初始化最大堆
        front = rear = 0;
        data = (T[]) new Comparable[100];
    }

    public MaxHeap(T[] t) {// 初始化最大堆
        front = rear = 0;
        data = t;
    }

    // 筛选法调整堆
    // 将以low为根结点的子树调整成大顶堆，low和high分别是待调整序列的上界和下界
    public void sift(int low, int high) {
        int i = low;// 子树的根结点
        int j = 2 * i + 1;// j为i结点的左孩子
        T temp = data[i];
        while (j < high) {// 沿较大值的孩子结点向下筛选
            if (j < high - 1 && data[j].compareTo(data[j + 1]) < 0) {
                j++;// 结点优先级进行比较，j为左右孩子结点的较大者
            }
            if (temp.compareTo(data[j]) < 0) {// 若父母结点值较小
                data[i] = data[j];// 孩子结点的较大者上移
                i = j;
                j = 2 * j + 1;// 对以被交换的子结点作为根结点所在的子树进行调整
            } else {
                j = high + 1;// 退出循环
            }
        }
        data[i] = temp;// 当前子树的原根值调整后的位置
    }

    // 创建堆算法
    public void insertheapSort() {
        int n = rear - front;// 待加入堆的结点个数
        T temp;
        for (int i = n / 2 - 1; i >= front; i--) {// 创建堆
            sift(i, n);
        }
    }

    // 取出堆顶元素，并且重新调整堆为最大堆的算法
    public T removeheapSort() {
        int n = rear - front;//
        int i = n - 1;// 堆的最后一个结点
        T temp = data[front];// 将堆中最小关键字值移到最前面
        data[front] = data[i];
        sift(front, i);// 并且调整成堆
        return temp;// 返回最顶堆结点
    }

    // 将堆元素node加入堆，并且调整堆
    public void insert(T node) {
        data[rear] = node;
        rear += 1;// 修改尾指针
        insertheapSort();// 调整堆
    }

    // 将堆顶元素取出，并且调整堆
    public T removeMax() {
        T temp = removeheapSort();
        rear -= 1;
        return temp;
    }
}