import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;
//import java.lang.Comparable;
/**
 * author Komorebi
 * set接口也是Collection接口的子接口,没有进行扩充
 * 元素不允许重复
 *
 * set集合方法
 * .add();  .size();  .isEmpty()   .clear()   .contains(Object o);  .toArray()
 * HashSet 具有不确定性, LinkedHashSet 按照用户储存顺序储存, TreeSet 按照自然顺序储存,
 * !!! 因此不存在list集合中的.get(index); .add(index,element); .set(index,element)
 * 因此不能用传统的for循环 可以使用foreach语句, 或进迭代器迭代
 * Iterator it = list.iterator();
 * while(it.hasNext()){
 *      Object obj = it.next();
 *      System.out.println(obj);
 * }
 *
 * set子接口HashSet,TreeSet
 * HashSet 存放数据没有规律
 * 进行重复元素判断需要依靠ComParable接口来完成如果是自定义类需要覆写hashCode(),equals(Object obj)方法.
 * TreeSet 自动排序
 * 如果是自定义类对象,不具备比较性
 * 1.让元素自身具备比较性(元素的自然排序默认排序)
 * 也就是元素(类)需要实现Comparable接口, 覆盖compareTo方法
 * 2.定义一个类实现Comparator接口, 覆盖compare方法
 * 若同时出现, 以Comparator为主
 *
 * 看到 array，就要想到角标。
 * 看到 link，就要想到 first，last。
 * 看到 hash，就要想到 hashCode,equals.
 * 看到 tree，就要想到两个接口.Comparable，Comparator。
 */

//例 覆写hashCode(),equals(Object obj)方法消除重复元素
class student{
        private String name;
        private Integer age;
        student(String name,Integer age){
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString(){
            return "name = "+name+" "+"age = "+age;
        }
        @Override
        public boolean equals(Object obj){
            if(obj==null||getClass()!=obj.getClass()){
                return false;
            }
            if(obj == this){
                return true;
            }
            if(obj instanceof student){
                student student = (student) obj;
                return student.age.equals(this.age)&&student.name.equals(this.name);
            }
            return false;
        }
        @Override
        public int hashCode(){
            return Objects.hash(name,age);
        }
}
//例 实现Comparable接口, 覆盖compareTo方法, 实现Comparator接口, 覆盖compare方法
class person implements Comparable<person> {
    protected String name;
    protected Integer age;

    person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name = " + name + " " + "age = " + age;
    }
    @Override
    public int compareTo(person p){
        if(this.name.compareTo(p.name) == 0){
            if(this.age>p.age){
                return 1;
            }
            else if(this.age<p.age){
                return -1;
            }
            else return 0;
        }
        else {
            return this.name.compareTo(p.name);
        }
    }
}
//例  实现Comparator接口, 覆盖compare方法
class myComparator implements Comparator<person>{
    @Override
    public int compare(person p1,person p2) {
        if (p1.age > p2.age) {
            return 1;
        } else if (p1.age < p2.age) {
            return -1;
        } else {
            return p1.name.compareTo(p2.name);
        }
    }
}
public class SetTest {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(4);
        set.add(1);
        set.add(3);
        set.add(1);
        System.out.println(set);

        Set<student> set1 = new HashSet<student>();
        set1.add(new student("A",1));
        set1.add(new student("B",2));
        set1.add(new student("C",4));
        set1.add(new student("B",3));
        set1.add(new student("B",2));
        System.out.println(set1);

        TreeSet set2 = new TreeSet();
        set2.add("Message C");
        set2.add("Message A");
        set2.add("Message B");
        set2.add("Message C");
        set2.add("Message D");
        System.out.println(set2);
        //TreeSet实现了升序排序

        Set<person> set3 = new TreeSet<person>(new myComparator());
        set3.add(new person("A",1));
        set3.add(new person("C",2));
        set3.add(new person("B",3));
        set3.add(new person("B",2));
        set3.add(new person("A",1));
        System.out.println(set3);

    }
}
