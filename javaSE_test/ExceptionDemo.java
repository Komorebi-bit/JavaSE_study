/**
 * @author Komorebi
 * @since 2021.11.04.16:33
 */
import java.util.*;
public class ExceptionDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = i/j;
            String s = sc.next();
            int m = Integer.parseInt(s);
            int[] a = new int[1];
            int[] a1 = new int[-1];
            a[0]=i;
            a[1]=j;

        }catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("分母为〇!");
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("数组下标越界!");
        }catch(InputMismatchException e){
            e.printStackTrace();
            System.out.println("输入不匹配!");
        }catch(NumberFormatException e){
            e.printStackTrace();
            System.out.println("数字转化异常!");
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("空指针异常!");
        }catch(NegativeArraySizeException e){
            e.printStackTrace();
            System.out.println("你创建了一个数组大小为负数的数组!!!");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("其他异常!");
        }finally{
            System.out.println("程序结束!");
            sc.close();
        }
    }
}

