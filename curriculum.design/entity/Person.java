package entity;

import java.io.Serializable;

/**
 * @author Komorebi
 * @since 2021.11.28.14:04
 */
public class Person implements Serializable {
    private String num;
    private String name;
    private int age;
    private String gender;
    private String status;

    public Person() {}

    public Person(String num, String name, int age, String gender, String status) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = status;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return num+'\t'+name+'\t'+age+'\t'+gender+'\t'+status;
    }
}
