/**
 * @author Komorebi
 * @since 2021.10.01.14:58
 */
public class Overload {
    public boolean compare(int a,int b){
        if(a>b){
            return true;
        }else{
            return false;
        }
    }
    public boolean compare(double a,double b){
        if(a>b){
            return true;
        }else{
            return false;
        }
    }
    public boolean compare(String s1,String s2){
        if(s1.compareTo(s2)<0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Overload o = new Overload();
        int x1=10,x2=5;
        System.out.println(o.compare(x1,x2));
        double y1=2.5,y2=3.6;
        System.out.println(o.compare(y1,y2));
        String s1="java",s2="c++";
        System.out.println(o.compare(s1,s2));
  }
}
