package Pillar;

/**
 * @author Komorebi
 * @since 2021.10.28.17:31
 */
public class Text {
    public static void main(String[] args){
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(5,2);
        Triangle triangle = new Triangle(10,5);
        Pillar pillar = new Pillar();
        System.out.println("底面为圆形(2),高为10的柱体的体积: "+(new Pillar(circle,10)).Volume());
        System.out.println("底面为矩形(5，2),高为10的柱体的体积: "+(new Pillar(rectangle,10)).Volume());
        System.out.println("底面为三角形(10,5),高为10的柱体的体积: "+(new Pillar(triangle,10)).Volume());

    }
}
