/**
 * @author Komorebi
 * @since 2021.12.22.10:07
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        List list1 = new ArrayList();
        List list2 = new ArrayList();

        Student liLei = new Student("李雷",21);
        Student hanMeiMei = new Student("韩梅梅",20);
        Student lucy = new Student("Lucy",19);
        Student lily = new Student("Lily",18);

        list1.add(liLei);
        list1.add(hanMeiMei);
        list1.add(lucy);
        list1.add(lily);

        File file = new File("data.txt");
        try {
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            for(int i=0;i<4;i++){
                objectOutputStream.writeObject(list1.get(i));
            }
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            for(int i=0;i<4;i++){
                list2.add(objectInputStream.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                objectOutputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(int i=0;i<4;i++){
           System.out.println(list2.get(i));
        }
    }
}

class Student implements Serializable {
    private String name;
    private int age;

    Student(){}
    Student(String name,int age){
        this.name = name;
        this.age = age;
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

    @Override
    public String toString(){
        return "姓名=“"+name+"”, 年龄="+age;
    }
}


