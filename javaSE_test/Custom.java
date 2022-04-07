/**
 * @author Komorebi
 * @since 2021.11.18.17:29
 */
import java.util.*;
public class Custom {
    private String name;
    private int age;
    private String gender;

    Custom(){}
    Custom(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "name: "+name+" , "+"age: "+age+" , "+"gender: "+gender;
    }

    public static void main(String[] args){
        List<Custom> list = new ArrayList<>();
        list.add(new Custom("张立",18,"女"));
        list.add(new Custom("王猛",22,"男"));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
