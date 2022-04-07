import java.util.*;

/**
 * @author Komorebi
 * @since 2021.08.13.13:08
 */
public class 统计字符出现的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        //while (!sc.hasNext("\\^c")) {
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if (c == ' ') {
            //    continue;
            //}
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int value = map.remove(c);
                value++;
                map.put(c, value);
            }
        }
        //}
        Set<Map.Entry<Character, Integer>> ms = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = ms.iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> mp = it.next();
            Character key = mp.getKey();
            Integer value = mp.getValue();
            System.out.println(key + ": " + value);
        }
        System.out.println("---------------------");
    }
}

