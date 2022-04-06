/**
 * author Komorebi
 * list接口是Collection接口的子接口 元素允许重复
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("Tom");
        list.add("Jam");
        list.add("Alix");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        //获取元素
        String str = list.get(0);
        System.out.println(str);
        //删除元素
        list.remove(0);
        list.remove("Alix");
        //遍历元素
        for (String s : list) {
            System.out.println(s);
        }

        //判断某一个元素是否在list中
        System.out.println(list.contains("Jam"));
        //根据索引改变元素的值
        list.set(0, "Tom");
        list.add(1, "Jam");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("-------------");
        List<Integer> num = new ArrayList<Integer>();
        num.add(1);
        num.add(2);
        num.add(9);
        num.add(2);
        num.add(2);
        //返回元素值等于2的索引
        System.out.println(num.indexOf(2));
        //返回元素值等于2的最后的索引
        System.out.println(num.lastIndexOf(2));
        //利用list中索引位置重新生成一个新list(截取集合)
        num = num.subList(0, 4);
        for (Integer i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
        //判断list是否为空
        System.out.println(num.isEmpty());
        System.out.println("-------------");
        //返回iterator集合对象
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.print(obj + " ");
        }
        System.out.println();
        //将集合转化为String
        String str1 = list.toString();
        System.out.println(str1);

        //将集合转化为数组
        // .toArray()返回Object[] toArray()在功能上与toArray(new Object[0])相同。
        //ArrayStoreException – 如果指定数组的运行时类型不是此列表中每个元素的运行时类型的超类型
        //NullPointerException – 如果指定的数组为空
        String[] arr = list.toArray(new String[0]);
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();

        //清空列表
        list.clear();
        System.out.println(list.isEmpty());
    }
}
