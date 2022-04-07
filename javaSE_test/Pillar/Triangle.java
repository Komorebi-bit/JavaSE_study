package Pillar;

/**
 * @author Komorebi
 * @since 2021.10.28.17:19
 */
public class Triangle extends Shape{
    private double height;
    private double base;
    public Triangle(){}
    public Triangle(double height,double base){
        this.height = height;
        this.base = base;
    }
    @Override
    public double area(){
        return 0.5*base*height;
    }
}
