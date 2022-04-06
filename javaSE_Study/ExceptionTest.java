import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2021.08.08.17:01
 * <p>
 * 1	public String getMessage()
 * 返回关于发生的异常的详细信息。这个消息在Throwable 类的构造函数中初始化了。
 * 2	public Throwable getCause()
 * 返回一个Throwable 对象代表异常原因。
 * 3	public String toString()
 * 使用getMessage()的结果返回类的串级名字。
 * 4	public void printStackTrace()
 * 打印toString()结果和栈层次到System.err，即错误输出流。
 * 5	public StackTraceElement [] getStackTrace()
 * 返回一个包含堆栈层次的数组。下标为0的元素代表栈顶，最后一个元素代表方法调用堆栈的栈底。
 * 6	public Throwable fillInStackTrace()
 * 用当前的调用栈层次填充Throwable 对象栈层次，添加到栈层次任何先前信息中。
 */

public class ExceptionTest {
    public static void main(String[] args) {
        int a = 0, b = 0;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        try {
            System.out.println(a + "/" + b + "=" + a / b);
        } catch (ArithmeticException e) {
            System.out.println("除数b为0");
        }
        System.out.println("运算结束");
    }
}