/**
 * @author Komorebi
 * @since 2021.12.23.13:59
 */


public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        thread2 t2 = new thread2("thread2");
        t1.start();
        t2.start();
        System.out.println("主线程" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("线程1" + Thread.currentThread().getName());
    }
}

class thread2 extends Thread {
    public thread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("线程2" + Thread.currentThread().getName());
    }
}
