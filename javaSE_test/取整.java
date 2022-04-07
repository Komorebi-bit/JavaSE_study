/**
 * @author Komorebi
 * @since 2021.09.09.17:52
 */
import java.util.*;
public class 取整 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        float a = sc.nextFloat();
        int b = (int)(a+0.5);
        System.out.println(b);
        sc.close();
  }
}
