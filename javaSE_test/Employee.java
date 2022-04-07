/**
 * @author Komorebi
 * @since 2021.11.18.16:27
 */

import java.util.*;
public class Employee implements Comparable<Employee>{
    private String name;
    private int salary;

    Employee(){}

    Employee(String name,int salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "name: "+name+" , "+"salary: "+salary;
    }
    @Override
    public int compareTo(Employee e) {
        if(this.salary<e.salary) return 1;
        if(this.salary>e.salary) return -1;
        return this.name.compareTo(e.name);
    }
    public static void main(String[] args){
        Set<Employee> set = new TreeSet<Employee>();
        set.add(new Employee("张三",8000));
        set.add(new Employee("李四",6000));
        set.add(new Employee("王五",5600));
        set.add(new Employee("马六",7500));
        for(Employee e:set){
            System.out.println(e);
        }
    }

}
