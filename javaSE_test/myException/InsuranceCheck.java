/**
 * @author Komorebi
 * @since 2021.11.04.17:29
 */
package myException;
import java.util.*;
public class InsuranceCheck {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dateOfBirth = sc.nextInt();
        try {
            System.out.println(insurance(dateOfBirth));
        } catch (AgeException e) {
            e.printStackTrace();
        }
        sc.close();
    }
    public static int insurance(int dateOfBirth) throws AgeException {
        int age = 2021-dateOfBirth;
        if(age<16) throw new AgeException("年龄太小，不用保险");
        int drivingYears = age - 16;
        if(drivingYears<4) return 2000;
        return 1000;
    }
}
