package Pillar;

/**
 * @author Komorebi
 * @since 2021.10.28.17:13
 */
public class Rectangle extends Shape{
    private double length;
    private double width;
    public Rectangle(){}
    public Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    @Override
    public double area(){
        return length*width;
    }
}
