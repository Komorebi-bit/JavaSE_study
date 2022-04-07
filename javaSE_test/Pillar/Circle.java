package Pillar;

/**
 * @author Komorebi
 * @since 2021.10.28.17:07
 */
public class Circle extends Shape{
    private double radius;
    public static final double PI=3.1415926;
    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double area(){
        return PI*radius*radius;
    }
}
