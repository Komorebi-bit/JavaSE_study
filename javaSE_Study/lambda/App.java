package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Komorebi
 * @since 2022.07.23.19:53
 * jdk8 java.util.function包下的常用函数式接口
 * Supplier,Consumer,Predicate,Function接口
 */
public class App {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "cc", "dddd", "bbb");
        //Collections.sort(list,(s1,s2)-> s1.length()-s2.length());
        //Collections.sort(list,App::c);
        //Collections.sort(list,new App()::co);

        //接口名 = (类名::成员方法名)  括号里的第一个参数必须是该类的实例对象，上面那个例子无法做测试

        System.out.println(list);

        //operatorString("哇哈哈", s -> System.out.println(new StringBuilder(s).reverse().toString()));

        new Thread(() -> System.out.println("函数式编程，lambda表达式")).start();
    }
    private static int c(String s1,String s2) {
        return s1.length() - s2.length();
    }

    private int co(String s1,String s2){
        return s1.length() - s2.length();
    }

    private static void operatorString(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

}
