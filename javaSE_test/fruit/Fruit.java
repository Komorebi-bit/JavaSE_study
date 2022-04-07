package fruit;

/**
 * @author Komorebi
 * @since 2021.10.21.16:36
 */
public class Fruit {
    protected int weight;
    protected String color;
    public Fruit(){}
    public Fruit(int weight,String color){
        this.weight=weight;
        this.color=color;
    }
    @Override
    public String toString(){
        return getClass().getName()+"[ weight: "+weight+", color: "+color+" ]";
    }
}
