/**
 * @author Komorebi
 * @since 2021.10.28.16:32
 */
public class Test1 {
    public static void main(String[] args){
        Shape shape = new Circle(3);
        System.out.println(shape.area());
    }
}
class Circle implements Shape{
    private double radius;
    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return PI*radius*radius;
    }
}
interface Shape{
    double PI=3.1415926;
    double area();
}
