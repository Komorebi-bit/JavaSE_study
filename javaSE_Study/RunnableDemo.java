/**
 * @author Komorebi
 * @since 2021.12.23.14:21
 */

/**
 * sleep() 静态方法
 * currentThread() 静态方法
 * main 方法启动了两个线程(main线程,Monitor Ctrl-Break线程)
 */

public class RunnableDemo implements Runnable {
    public static void main(String[] args) {
        RunnableDemo r = new RunnableDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        try {
            System.out.println("等待状态:" + t1.isAlive());

            t2.setPriority(Thread.MAX_PRIORITY);
            System.out.println("线程2的优先级: " + t2.getPriority());
            /*
             * 设置线程优先级
             * 优先级高的并不一定先执行
             * 线程睡眠后，优先级失效
             */

            t1.start();
            //启动线程

            System.out.println("运行状态:" + t1.isAlive());
            t2.start();

            //Thread.sleep(10);
            //线程失眠10ms

            System.out.println();
            System.out.println(Thread.activeCount());
            //获得当前线程数
            Thread.currentThread().getThreadGroup().list();
            //打印当先线程里列表

            t1.join();
            //等待线程结束
            System.out.println("线程结束1:" + t1.isAlive());
            t2.join();
            System.out.println("线程结束2:" + t1.isAlive());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //加锁
    //同步方法
    synchronized public static void fun() {
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    @Override
    public void run() {
        fun();

        //同步块
        Share s = new Share();
        synchronized (s) {
            s.f();
        }
    }

}

class Share {
    public void f() {
        for (int i = 0; i < 20; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}