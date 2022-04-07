package animal;

/**
 * @author Komorebi
 * @since 2021.10.14.16:35
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal("唔西迪西");
        Dog dog = new Dog("玛卡巴卡");
        Cat cat = new Cat("依古比古");
        animal.showName();
        animal.cry();
        dog.showName();
        cat.showName();
        dog.cry();
        cat.cry();
        dog.swimming();
        cat.climbUpTree();
    }
}
