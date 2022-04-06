/**
 * author Komorebi
 * Map学习体系：
 *  ---| Map  接口    将键映射到值的对象.一个映射不能包含重复的键;每个键最多只能映射到一个值.
 * 			---| HashMap  采用哈希表实现,所以无序
 *             ---| TreeMap   可以对健进行排序
 * ---|Hashtable:
 * 底层是哈希表数据结构,线程是同步的,不可以存入null键,null值.
 * 效率较低,被HashMap 替代.
 * ---|HashMap:
 * 底层是哈希表数据结构,线程是不同步的,可以存入null键, null值.
 * 要保证键的唯一性,需要覆盖hashCode方法,和equals方法.
 * ---| LinkedHashMap：
 * 该子类基于哈希表又融入了链表,可以Map集合进行增删提高效率.
 * ---|TreeMap:
 * 底层是二叉树数据结构.可以对map集合中的键进行排序.需要使用Comparable或者Comparator进行排序比较.return 0判断键的唯一性
 *
 */
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        //.put(); .putAll()添加元素
        map.put("jack",20);
        map.put("rose",12);
        map.put("lucy",18);
        map.put("java",20);
        map.put("java",16);
        //添加重复的键(值不同),会返回原有键映射的值,同时会置换掉原有的值
        System.out.println(map);
        //map.putAll(map1) //把map1的映射关系复制到map中

        //.remove(key) 删除指定key对象,同时返回value  .clear();清空
        System.out.println(map.remove("java"));
        System.out.println(map);

        //.get(key); 获取value   .size()获取容器大小;
        System.out.println(map.get("rose"));
        System.out.println("map.size: "+map.size());

        //判断 .isEmpty(),  .containsKey()   .containsValue()
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("lucy"));
        System.out.println(map.containsValue(12));

        /**------遍历map的方法--------*/
        //使用.keySet()
        //分别获取key和value, 没有面向对象思想
        //Set<K>, .keySet()返回所有的key的Set集合
        Set<String> k = map.keySet();
        Iterator<String> it = k.iterator();
        while(it.hasNext()) {
            String key = it.next();
            Integer value = map.get(key);
            System.out.println("key="+key+","+"value="+value);
        }

        //通过.values()获取所有值, 不能获取到key
        //Collection<V>   .values()
        Collection<Integer> v = map.values();
        Iterator<Integer> it1 = v.iterator();
        while(it1.hasNext()){
            Integer value1 = it1.next();
            System.out.println("value="+value1);
        }

        /*
        面向对象的思想将map集合中的键值映射关系打包为一个对象,就是Map.Entry,将该对象存入Set集合,Map.Entry是一个对象
        Map.Entry对象 推荐使用 重点
        Set<Map.Entry<K,V>>   .entrySet()
         */
        //返回的Map.Entry对象的Set集合,Map.Entry包含了key和value对象
        Set<Map.Entry<String,Integer>> es = map.entrySet();
        Iterator<Map.Entry<String,Integer>> it2 = es.iterator();
        while(it2.hasNext()){
            //返回的是封装了key和value对象的Map.Entry对象
            Map.Entry<String, Integer> en = it2.next();
            //获取Map.Entry对象中封装的key和value对象
            String key = en.getKey();
            Integer value = en.getValue();
            System.out.println("key="+key+","+"value="+value);
        }
    }
}
