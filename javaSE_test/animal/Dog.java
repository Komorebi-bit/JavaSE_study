package animal;

/**
 * @author Komorebi
 * @since 2021.10.14.16:34
 */
public class Dog extends Animal{

    public Dog(){};
    public Dog(String name){
        super(name);
    }

    public void swimming(){
        System.out.println(name +" can swime");
    }
    @Override
    public void cry(){
        System.out.println("dog:"+name+" cry");
    }
}
