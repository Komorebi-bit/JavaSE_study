package myGeneric;

/**
 * @author Komorebi
 * @since 2021.11.11.17:30
 */
public class Generic<T extends Number> {
    private T number;
    public Generic(T number){
        this.number = number;
    }
    @Override
    public String toString(){
        return getClass().getName()+"="+number;
    }
    public static void main(String[] args){
        Generic<Integer> g1 = new Generic<Integer>(10);
        System.out.println(g1);
    }
}
