package fruit;

/**
 * @author Komorebi
 * @since 2021.10.21.16:36
 */
public class Apple extends Fruit {
    public Apple(){}
    public Apple(int weight,String color){
        super(weight,color);
    }
    @Override
    public String toString(){
        return getClass().getName()+"[ weight: "+weight+", color: "+color+" ]";
    }
}
