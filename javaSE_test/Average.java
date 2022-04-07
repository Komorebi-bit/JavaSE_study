/**
 * @author Komorebi
 * @since 2021.09.09.17:06
 */

import java.util.*;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        int sum = a + b + c;
        System.out.println(sum);
        double d = sum * 1.0 / 3;
        System.out.printf("%.2f", d);
        sc.close();
    }
}
