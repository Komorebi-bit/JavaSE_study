import java.lang.Runnable;

/**
 * @author Komorebi
 * lambda表达式
 * (参数)->结果
 */
@FunctionalInterface
interface my {
    int doSomeShit(int s);
}

interface my1 {
    void doSomeShit(int s);
}

public class lambda {
    private int r;

    lambda(int x) {
        this.r = x;
    }

    public interface Area<T> {
        int area(T a);
    }


    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello world!");
        r1.run();

        Area<lambda> l = (lam) -> (lam.r) * (lam.r);
        lambda lam = new lambda(10);
        System.out.println(l.area(lam));

        my s1 = (s) -> s * s;
        System.out.println(s1.doSomeShit(100));

        my1 ss = (s) -> System.out.println("s= " + s);
        ss.doSomeShit(100);
    }
}
