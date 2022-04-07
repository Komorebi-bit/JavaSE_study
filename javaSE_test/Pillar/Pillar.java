package Pillar;

/**
 * @author Komorebi
 * @since 2021.10.28.17:25
 */
public class Pillar {
    private Shape bottom;
    private double height;
    public Pillar(){}
    public Pillar(Shape bottom,double height){
        this.bottom = bottom;
        this.height = height;
    }
    public double Volume(){
        return bottom.area()*height;
    }
}
