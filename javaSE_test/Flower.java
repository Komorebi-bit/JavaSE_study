/**
 * @author Komorebi
 * @since 2021.09.30.17:24
 */

public class Flower {
    private String name,type,color;
    private int price;
    public Flower(){
        name="";
        type="";
        color="";
        price=0;
    }
    public Flower(String name,String type,String color,int price){
        this.name=name;
        this.type=type;
        this.color=color;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getColor(){
        return color;
    }
    public int getPrice(){
        return price;
    }

    public static void main(String[] args){
        Flower f1=new Flower("玫瑰花","路易十四","深紫色",400),
                f2=new Flower("玫瑰花","朱丽叶","但茶色",300),
                f3=new Flower("百合花","地平线","花橙色",450);
        Flower[] flower = new Flower[]{f1,f2,f3};
    for (int i =0; i < 3; i++) {
        System.out.println("名称: "+flower[i].getName()+", 品种: "+flower[i].getType()
                +", 颜色: "+flower[i].getColor()+", 销售价格: "+flower[i].getPrice());
    }

    }
}
