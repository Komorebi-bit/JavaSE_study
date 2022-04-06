import java.util.*;
import java.lang.String;

/**
 * @author Komorebi
 * 堆 内存里的数据都有默认值, 规定:
 * 整数 0;
 * 浮点数 0.0;
 * 字符 '\u0000';
 * 布尔 false;
 * 引用类型 null;
 * .clone();数组拷贝
 * Arrays.copyOf(旧数组,新数组长度);
 */
public class Array {
    public static void main(String[] args) {
        int[] arr1;
        arr1 = new int[3];
        //int[] arr = new int[3];
        int[] arr2;
        arr2 = new int[]{1, 2, 3};
        //int[] arr2 = new int[]{1,2,3};
        int[] arr3 = {1, 2, 3, 4};
        //不可拆分
        Arrays.fill(arr1, 1);
        //快速填充,只能一维数组填充,全部填充为1
        int len = arr1.length;
        //获取数组长度
        //二位数组
        int[][] array1 = new int[10][10];
        int[][] array2 = new int[][]{{1, 1, 1}, {2, 2, 2,}};
        int[][] array3 = {{1, 1, 1}, {2, 2, 2}};
        //不定长二维数组
        int[][] array = new int[3][];
        array[0] = new int[1];
        array[1] = new int[2];
        array[2] = new int[3];
        //获取二位数组的第一维长度
        int len1 = array.length;
        System.out.println(len1);
        //获取二位数组的第一维的第一个数组长度
        int len2 = array[0].length;
        System.out.println(len2);
        //foreach遍历方式
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        Arrays.sort(arr3);
        //数组排序(升序)
        //binarySearch 对排序好的数组进行二分查找发
        //java常用API
        //输出数组 Arrays.toString()
        System.out.println(Arrays.toString(arr1));
        //数组转List Arrays.asList()
        String[] array4 = {"a", "b", "c", "d"};
        System.out.println(array4);
        System.out.println("------------------------");
        List list1 = new ArrayList(Arrays.asList(array4));
        System.out.println(list1);
        list1.add("gg");
        System.out.println(list1);
        //数组转Set Arrays.asList()
        Set set = new HashSet(Arrays.asList(array4));
        System.out.println(set);
        //List转数组 toArray()
        List list2 = new ArrayList();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        String[] array5 = new String[list2.size()];
        list2.toArray(array5);
        for (String s : array5) {
            System.out.print(s + " ");
        }
        System.out.println();
        //数组中是否包含某个值
        boolean isEle = Arrays.asList(array5).contains("A");
        System.out.println(isEle);
        //数组赋值
        int[] array6 = new int[]{1, 2, 3, 4};
        int[] array7 = new int[array6.length];
        System.arraycopy(array6, 0, array7, 0, array6.length);
        System.out.println(Arrays.toString(array6));
        //int[] arr4 = org.apache.commons.lang.ArrayUtils.addAll(arr1,arr2);
        //System.out.println(Arrays.toString(arr4));
    }
}
