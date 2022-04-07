/**
 * @author Komorebi
 * @since 2021.11.18.17:07
 */
import java.util.*;
public class StringSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(!sc.hasNext("#")){
            list.add(sc.nextLine());
        }
        Collections collections = null;
        collections.sort(list);
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        sc.close();
    }
}
