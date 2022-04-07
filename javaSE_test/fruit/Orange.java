package fruit;

/**
 * @author Komorebi
 * @since 2021.10.21.16:37
 */
public class Orange extends Fruit{
    public Orange(){}
    public Orange(int weight,String color){
        super(weight,color);
    }
    @Override
    public String toString(){
        return getClass().getName()+"[ weight: "+weight+", color: "+color+" ]";
    }
}
