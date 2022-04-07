/**
 * @author Komorebi
 * @since 2021.11.18.16:49
 */
import java.util.*;
public class TreeSetDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Character> set = new TreeSet<>();
        String s = sc.next();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        for(Character c:set){
            System.out.print(c);
        }
        System.out.println();
        sc.close();
    }
}
