/**
 * @author Komorebi
 * @since 2021.10.06.19:46
 */
import java.io.Serializable;
public class Phone implements Serializable {
    private String name;
    private String num;
    public Phone(String name, String num){
        this.name=name;
        this.num=num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Phone [ 姓名: " + name  + ", 电话号码: " + num + "]";
    }
}
