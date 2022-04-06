/**
 * author Komorebi
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Person1> hm = new HashMap<String, Person1>(10, 10);
        hm.put("2021001", new Person1("jack", 20));
        hm.put("2021005", new Person1("rose", 16));
        hm.put("2021003", new Person1("lucy", 18));
        hm.put("2021006", new Person1("java", 20));
        System.out.println(hm);
        Set<Map.Entry<String, Person1>> es = hm.entrySet();
        Iterator<Map.Entry<String, Person1>> it = es.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Person1> map = it.next();
            String key = map.getKey();
            Person1 value = map.getValue();
            System.out.println(key + "=" + value);
        }
        System.out.println("-------------------");

    }
}

class Person1 {
    private String name;
    private int age;

    Person1() {
    }

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + age * 37;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person1) {
            Person1 p = (Person1) o;
            return this.name.equals(p.name) && this.age == p.age;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + this.name + "," + this.age + ")";
    }
}