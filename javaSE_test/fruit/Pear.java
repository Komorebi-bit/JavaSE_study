package fruit;

/**
 * @author Komorebi
 * @since 2021.10.21.16:37
 */
public class Pear extends Fruit {
    public Pear(){}
    public Pear(int weight,String color){
        super(weight,color);
    }
    @Override
    public String toString(){
        return getClass().getName()+"[ weight: "+weight+", color: "+color+" ]";
    }
}
