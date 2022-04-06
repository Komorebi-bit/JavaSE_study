import sun.rmi.runtime.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Komorebi
 * @date 2021.08.06.12:26
 * Genericity(泛型)
 */
public class Genericity {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<Integer>();
        Class classList1 = list1.getClass();
        Class classList2 = list2.getClass();
        System.out.println(classList1.equals(classList2));//true

        System.out.println("-----------------");

        //泛型类
        Generic<Integer> g1 = new Generic<Integer>(123);
        Generic<String> g2 = new Generic<String>("key-value");
        System.out.println(g1.getKey()+"    "+g2.getKey());

        System.out.println("-----------------");

        //泛型接口
        FruitGenerator f = new FruitGenerator();
        System.out.println(f.next());

        System.out.println("-----------------");

        //通配符
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(123);
        //showKeyValue(gInteger);
        /*报错 Generic<java.lang.Integer>无法转换为Generic<java.lang.Number>
          虽然Integer是Number的子类,但通过上述测试可以看到Generic<Integer>不能被看作Generic的子类
          因此可以看出: 同一种泛型可以对应多个版本(因为参数类型是不确定的),不同版本的泛型实例是不兼容的
          泛型通配符 ?
        */
        showKeyValue1(gInteger);
        showKeyValue1(gNumber);

        System.out.println("-----------------");

        //泛型方法
        g1.show1();
        g2.show2(g1);

        System.out.println("-----------------");
        g1.printMsg("111",222,"aaa",12.56,'a');
        System.out.println();
        Generic.show(g1);
    }

    /**------泛型通配符------*/
    //非通配符例子
    public static void showKeyValue(Generic<Number> obj) {
        System.out.println(obj.getKey());
    }
    //使用泛型通配符
    //上边界通配符 <? extends 具体类型1>  接收的类型必须是其及其子类
    //下边界通配符 <? super 具体类型2>  接收的类型必须是其及其父类
    public static void showKeyValue1(Generic<?> obj){
        System.out.println(obj.getKey());
    }
}
/**-----泛型类------*/
//不能对确切的泛型类型使用instanceof操作
//[T <: 类型] 上界
//[T >: 类型] 下界
class Generic<T>{
    private T key;
    public Generic(T key){
        this.key = key;
    }
    public T getKey(){
        return key;
    }
    /**--------泛型方法--------*/
    //<T> 泛型方法标识符
    //可以为多个 <T, E, K, V> (常用)
    public<T> void show1(){
        System.out.println(toString());
    }
    public<E> void show2(E e){
        System.out.println(e.toString());
    }
    //泛型方法与可变参数
    public <T> void printMsg(T... args){
        for(T t : args){
            System.out.print(t+" ");
        }
    }
    //静态方法与泛型
    public static <T> void show(T t){
        System.out.println("泛型静态方法练习");
    }
}

/**------泛型接口-------*/
interface Generator<T> {
    public T next();
}

/*
        当实现泛型接口的类,为传入泛型实参时,与泛型类的定义相同,在声明类的时候需将泛型的声明也一起加到类中
        class FruitGenerator<T> implements Generator<T>{
            @Override
            public T next(){
                return null;
            }
        }
     */
//当实现泛型接口的类,传入泛型实参时,则所有实现泛型的地方都要替换成传入的实参类型
class FruitGenerator implements Generator<String>{
    private String[] fruits = new String[]{"Apple","Banana","Pear"};
    @Override
    public String next(){
        Random r = new Random();
        return fruits[r.nextInt(3)];
    }
}