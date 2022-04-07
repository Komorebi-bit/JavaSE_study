package animal;

/**
 * @author Komorebi
 * @since 2021.10.14.16:34
 */
public class Cat extends Animal{

    public Cat(){}
    public Cat(String name){
        super(name);
    }

    public void climbUpTree(){
        System.out.println(name+" can climb up tree");
    }
    @Override
    public void cry(){
        System.out.println("cat: "+name+" cry");
    }
}
