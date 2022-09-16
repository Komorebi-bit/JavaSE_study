package lambda;

import org.jetbrains.annotations.NotNull;
/**
 * @author Komorebi
 * @since 2022.07.23.21:58
 */
public interface Consumer<T> {
    /**
     * emm
     * @param t emm
     */
    void accept(T t);

    /**
     * emm
     * @param after emm
     * @return emm
     */
    default Consumer<T> andThen(@NotNull Consumer<T> after){
        return t -> {accept(t);after.accept(t);};
    }


    /**
     * em
     * @param args emm
     */
    static void main(String[] args) {
        operatorString("哇哈哈",
                System.out::println,
                t -> System.out.println(new StringBuilder(t).reverse()));

        //需求：拆分字符串，并按  姓名：xxx，年龄：xx  格式输出
        String[] strArray = {"林青霞，30","张曼玉，35","王祖贤，33"};
        printInfo(strArray
                ,t -> System.out.print("姓名："+t.split("，")[0]+"，")
                ,t -> System.out.println("年龄："+Integer.parseInt(t.split("，")[1])));
    }

    /**
     * emm
     * @param name emm
     * @param c1 emm
     * @param c2 emm
     */
    static void operatorString(String name, Consumer<String> c1, Consumer<String> c2){
        c1.andThen(c2).accept(name);
        /*
        andThen的返回值是函数式接口，实现了Consumer.accept()方法（方法体是this, after分别执行了，该接口的accept方法
        （该方法还未被实现，在operator参数里，才把这两个方法分别实现了）），
        该函数式接口参数调用了被重写的accept()方法，把参数传进去了（this，after执行accept方法是，才有了实参）
        */
    }
    static void printInfo(String [] strArray, Consumer<String> c1, Consumer<String> c2){
        for (String s: strArray){
            c1.andThen(c2).accept(s);
        }
    }


}
