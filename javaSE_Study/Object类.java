import java.lang.*;

/**
 * @author Komorebi
 * Object类位于 java.lang包中
 * public int hashCode()
 * 返回改对象的哈希码值 同一个对象或者equals()为true的哈希码值相等, 否则可能相等可能不相等
 * public final Class getClass() 返回运行时类
 * public String getName()  获取对象真实类的全名称
 * public String toString()   返回该对象的字符串表示
 * 底层代码:  return getClass().getName()+"@"+Integer.toHexString(hashCode());
 * 返回的是 类的全路径名称+他的哈希码值,    一般需要重载
 * public boolean equals()   一般用来判断对象值是否相等
 * 底层代码  return (this==obj)  比较的是引用是否相等,    需要重写
 * clone() 快速创建一个已有对象的副本  被protected修饰,用就必须继承Object, 返回一个Object对象(强制类型转化得到我们想要的类)
 * wait(), wait(long timeout) 线程等待
 * notify() 唤醒处于等待的某个线程
 * notifyAll()  唤醒处于等待的所有线程
 */
public class Object类 {
    public static void main(String[] args) {
        Object obj = new Object();
        int a = 100;
        System.out.println(obj.hashCode());
        Class c = obj.getClass();
        String name = c.getName();
        System.out.println(name);
        System.out.println(obj.toString());
    }
}
