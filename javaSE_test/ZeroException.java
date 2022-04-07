/**
 * @author Komorebi
 * @since 2021.11.11.15:08
 */
public class ZeroException {
    public static void main(String[] args){
        int a=2,b=0;
        int c;
        try{
            c=div(a,b);
            System.out.println(c);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
    }
    public static int div(int a,int b) throws ArithmeticException{
        if(b==0) throw new ArithmeticException("零做分母");
        return a/b;
    }
}
