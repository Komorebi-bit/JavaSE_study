package fruit; /**
 * @author Komorebi
 * @since 2021.10.21.16:36
 */
import java.util.*;
public class Box {
    private Fruit[] fruits;
    public static int sum=-1;
    public Box(){
        fruits = new Fruit[100];
    }
    public void addFruit(Fruit fruit){
        sum++;
        fruits[sum] = new Fruit();
        fruits[sum] = fruit;
    }
    public void getFruit(){
        System.out.println(fruits[sum].toString());
        sum--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Box box = new Box();
        System.out.println("请输入共添加的水果的个数: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("请输入要添加水果的类型(均小写): ");
            String s = sc.next();
            System.out.println("请输入要添加水果的重量及颜色: ");
            int weight = sc.nextInt();
            String color = sc.next();
            switch(s){
                case "apple":
                    box.addFruit(new Apple(weight,color));
                    break;
                case "pear":
                    box.addFruit(new Pear(weight,color));
                    break;
                case "orange":
                    box.addFruit(new Orange(weight,color));
                    break;
                default:
                    System.out.println("输入错误!!!");
                    break;
            }
        }
        System.out.println("请输入要取出水果的数量(按存入依次取出)");
        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            box.getFruit();
        }
        sc.close();
    }
}
