/**
 * author Komorebi
 * 向量类(Vector)实现类似动态数组的功能
 * 创建一个向量类的对象后, 可以往其中随意插入不同类的对象
 * public vector()
 * public vector(int initialcapacity)   //initialcapacity(初始容量)设定向量对象的容量
 * public vector(int initialcapacity, int capacityIncerment) //capacityIncerment(容量扩充)给定每次扩充的扩充值
 */

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector v = new Vector();
        /** ------插入功能-------- */
        //添加对象
        Integer i1 = new Integer(1);
        v.addElement(i1);
        v.addElement("one");
        v.addElement(new Double(3.14));
        v.addElement(i1);
        System.out.println(v);
        //指定位置插入对象
        v.insertElementAt("three", 2);
        //覆盖掉指定位置的对象
        v.setElementAt(new Integer(2), 4);
        System.out.println(v);
        v.addElement(i1);
        /** ------删除功能-------- */
        //删除指定对象, 若有多个删除第一个
        v.removeElement(1);
        //jdk1.5开始可以自动装箱拆箱
        System.out.println(v);
        //删除指定位置的对象
        v.removeElementAt(2);
        System.out.println(v);
        //清空
        //v.removeAllElements();
        System.out.println(v);
        /** ------查询搜索功能-------- */
        //返回第一个遇到的下标, 没有返回-1
        System.out.println(v.indexOf("three"));
        //从index所表示的下标开始搜索(包括它)
        System.out.println(v.indexOf("three", 1));
        //逆向搜索
        // v.lastIndexOf("three"); v.lastIndexOf("three",0);
        //获取首个对象
        System.out.println(v.firstElement());
        //获取最后一个对象
        System.out.println(v.lastElement());
        /**------枚举-------*/
        //.elements(); 将向量对象对应到一个枚举类型
        Enumeration enum1 = v.elements();
        while (enum1.hasMoreElements()) {
            System.out.print(enum1.nextElement()+" ");
        }
        System.out.println();

        //返回向量对象个数
        System.out.println(v.size());
        //重置大小, 多余的对象被舍弃, 不足用null补充
        v.setSize(10);
        v.remove(9);
        System.out.println(v);
        System.out.println(v.size());
        //返回容器容量
        System.out.println(v.capacity());
    }
}
