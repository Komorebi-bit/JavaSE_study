package animal;

/**
 * @author Komorebi
 * @since 2021.10.14.16:34
 */
public class Animal {
    protected String name;

    public Animal(){}

    public Animal(String name){
        this.name=name;
    }
    public void cry(){
        System.out.println( "annimal:"+name +" cry");
    }
    public void showName(){
        System.out.println("name: "+name);
    }

}
