import java.util.Random;

/**
 * @author Komorebi
 * @since 2022.09.28.16:22
 * <p>2.设$A=\{a_1,a_2,...,a_n\}$是正整数的集合，且
 * $$ \sum_{l=1}^n a_i=N $$ ## 设计一个算法判断是否能够把A划分成两个子集$A_1$和$A_2$， 使得$A_1$中的数之和与$A_2$中的数之和相等？
 * 说明算法的设计思想，估计算法最坏情况下的时间复杂度。
 * </p>
 */
public class App10 {
    public static int[] a;
    public static int len = 0;  //数组长度
    public static int sum = 0;  //数组中数之和
    public static int half = 0; //数组中数之和的一半

    public static int[] temp;  //其中一个子集
    public static int ans = 0;  //保存子集中数之和的最大值


    public static void main(String[] args) {
        Random random = new Random();
        a = new int[10];
        System.out.println(">>>>>>>随机数组：");
        for (int i = 0; i < 10; i++) {
            a[i] = random.nextInt(100) + 1;
            System.out.print(a[i] + " ");
        }
        // a = new int[]{10,9,8,7,6,5,4,3,2,1};
        // a = new int[]{10,8,20,15,6,2,1};
        // a = new int[]{15,8,7,6,4,3,3};

        System.out.println();

        len = a.length;
        temp = new int[len];
        //对数组降序排序
        sort(a, 0, len - 1);
        //求数组各数之和
        for (int i = 0; i < len; i++) {
            sum += a[i];
        }
        System.out.println(">>>>>>"+"结果：");
        //如果sum为奇数，打印false，结束程序
        if ((sum & 1) == 1) {
            // System.out.println(sum);
            System.out.println(false);
            return;
        }
        //求数组和的一半
        half = sum / 2;

        //拆分数组
        split(0, 0, 0);

        //如果子集中各数之和等于数组a的一半，打印true，并打印出了其中一个子集中的元素
        if (ans == half) {
            System.out.println(true);
            System.out.println("其中一个子集为：");
            for (int i = 0; i < temp[len-1]; i++) { //子集中最后一位的存放值就是自己元素的个数
                System.out.print(temp[i]+" ");
            }
            System.out.println();
        } else {
            //否则false
            System.out.println(false);
        }
        // System.out.println(ans);

    }

    /**
     * 把数组拆分成两个子集，使之各子集中数之和相等
     * @param i
     * @param s 暂存子集中数之和
     * @param k 表示子集数组元素的个数
     */
    public static void split(int i, int s, int k) {
        //当子集中数之和等于数组的一半时，或者下标i越界时，或者s+(len-i)*a[i]<ans（（做了一点优化）不好描述，我不描述了）
        if (ans == half || i >= len || s+(len-i)*a[i]<ans) {
            return;
        }
        if ((s + a[i]) <= half) {

            ans = max(ans, s + a[i]);
            temp[k] = a[i];   //满足条件就把a[i]元素放入子集中
            temp[len - 1] = k + 1;   //子集的最后一位放子集中元素的个数
            split(i + 1, s + a[i], k + 1);
        }
        split(i + 1, s, k);
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    //快速排序，降序
    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = qs(a, left, right);
        sort(a, left, pivot - 1);
        sort(a, pivot + 1, right);
    }

    public static int qs(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && temp >= a[right]) {
                right--;
            }
            a[left] = a[right];
            while (left < right && temp <= a[left]) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }

}
