/**
 * author Komorebi
 *
 */

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Comparator;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<String,Integer>();
        map.put("张三",22);
        map.put("李四",21);
        map.put("小明",18);
        map.put("李华",16);
        map.put("老八",30);
        System.out.println(map);
        System.out.println("张三".compareTo("李四"));//-2094
        System.out.println("jack".compareTo("rose"));//-8
        System.out.println("---------------------------");

        TreeMap<Student1,Integer> tm = new TreeMap<Student1,Integer>(new myComparator1());
        tm.put(new Student1("jack",22),1001);
        tm.put(new Student1("rose",16),1002);
        tm.put(new Student1("rose",18),1003);
        tm.put(new Student1("lucy",20),1004);
        System.out.println(tm);
        Set<Map.Entry<Student1,Integer>> se = tm.entrySet();
        Iterator<Map.Entry<Student1,Integer>> it = se.iterator();
        while(it.hasNext()){
            Map.Entry<Student1,Integer> me = it.next();
            Student1 key = me.getKey();
            Integer value = me.getValue();
            System.out.println(key+"="+value);
        }

    }
}
class Student1 implements Comparable<Student1>{
    protected String name;
    protected int age;
    Student1(){}
    Student1(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode(){
        return this.name.hashCode()+age*37;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Student1){
            return this.name.equals(name) && this.age == age;
        }
        else return false;
    }
    @Override
    public String toString(){
        return "("+this.name+","+this.age+")";
    }
    @Override
    public int compareTo(Student1 s){
        if(this.age>s.age){
            return 1;
        }
        else if(this.age<s.age){
            return -1;
        }
        else return this.name.compareTo(s.name);
    }
}
class myComparator1 implements Comparator<Student1>{
    public int compare(Student1 s1,Student1 s2){
        if(s1.name.compareTo(s2.name) == 0){
            if(s1.age>s2.age){
                return 1;
            }
            else if(s1.age<s2.age){
                return -1;
            }
            else return 0;
        }
        else {
            return s1.name.compareTo(s2.name);
        }

    }
}