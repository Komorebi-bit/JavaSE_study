package refect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Komorebi
 * @since 2022.07.24.12:53
 */
public class App2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(56);
        list.add(8);
        list.add(34);
        //list.add("");

        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list,"hello");
        method.invoke(list,"world");

        System.out.println(list);

    }
}
