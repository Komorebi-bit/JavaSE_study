/**
 * @author Komorebi
 * @since 2021.10.06.19:49
 */
import java.util.*;
import java.io.*;
public class Manager {
    //把对象放入链表中
//    private List<Phone> phoneList = new ArrayList<Phone>();
    private static List<Phone> phoneList = null;
    private Scanner sc = new Scanner(System.in);
    boolean startSingle = true;
    private String name;
    private String num;
    static File file = null;
    //程序入口
    public static void main(String[] args){
        Manager manager =new Manager();
        file = new File("E:/phone.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        manager.read();
        manager.home();
    }
    //反序列化，进行读取对象
    public static void read(){
        if(SaveUtil.readObject() != null){
            phoneList = (ArrayList<Phone>) SaveUtil.readObject();
        }
        else {
            phoneList = new ArrayList<Phone>();
        }
    }
    //home方法显示主页面
    public void home(){
        int select;
        System.out.println("************  电话本管理  ************");
        System.out.println("*****         1.添加信息         *****");
        System.out.println("*****         2.删除信息         *****");
        System.out.println("*****         3.查询信息         *****");
        System.out.println("*****         4.修改信息         *****");
        System.out.println("*****         5.显示信息         *****");
        System.out.println("*****         6.保存信息         *****");
        System.out.println("*****         7.姓名排序         *****");
        System.out.println("*****         0.退出系统         *****");
        System.out.println("*************************************");
        while(startSingle){
            System.out.println("请选择功能");
            select = sc.nextInt();
            switch(select){
                case 1:
                    add();
                    System.out.println("添加成功! ");
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    SaveUtil.saveObject(phoneList);
                    System.out.println("保存成功！");
                    break;
                case 7:
                    list();
                    break;
                case 0:
                    sc.close();
                    startSingle=false;
                    System.out.println("成功退出系统");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
    //add()方法: 添加电话信息
    public void add(){
        System.out.println("请输入姓名: ");
        name=sc.next();
        System.out.println("请输入电话号码: ");
        num=sc.next();
        Phone phone = new Phone(name,num);
        phoneList.add(phone);
        System.out.println(phone.toString());
    }
    //display()方法: 显示电话信息
    public void display(){
        for(Phone p:phoneList){
            System.out.println(p.toString());
        }
    }
    //按照姓名进行删除，返回的是索引号
    public int findbyname(String name){
        for(Phone phone: phoneList){
            if(phone.getName().equals(name)){
                return phoneList.indexOf(phone);
            }
        }
        System.out.println("对不起，找不到此人！！！");
        return -1;
    }
    //按照姓名查询，返回对象phone
//    public Phone findbyname(String name){
//        for (Phone phone:phoneList) {
//            if(phone.getName().equals(name)){
//                return phone;
//            }
//        }
//        System.out.println("对不起，找不到此人！！！");
//        return null;
//    }
    //删除方法 delete
    public void delete(){
        System.out.println("请输入要删除的联系人的姓名：");
        String name = sc.next();
       int index=findbyname(name);
        if(index!=-1){
            phoneList.remove(index);
            System.out.println("删除成功！");
        }
    }
    //删除方法 delete
//    public void delete(){
//        Phone phone = null;
//        System.out.println("请输入要删除联系人的姓名：");
//        String name = sc.next();
//        if((phone=findbyname(name))!=null){
//            phoneList.remove(phone);
//            System.out.println("删除成功！");
//        }
//    }
    //按照姓名进行查询
    public void search(){
        System.out.println("请输入要查询联系人的姓名：");
        String name = sc.next();
        int index = findbyname(name);
        if(index!=-1){
            System.out.println(phoneList.get(index).toString());
        }
    }
    //修改方法 update()
    public void update(){
        System.out.println("请输入要修改的联系人的姓名：");
        String name = sc.next();
        int index = findbyname(name);
        if(index!=-1){
            System.out.println("请输入号码: ");
            phoneList.get(index).setNum(sc.next());
            System.out.println("修改成功!");
        }
    }
    //按照姓名排序 list()
    public void list(){
        Collections.sort(phoneList, new Comparator<Phone>(){
            @Override
            public int compare(Phone p1,Phone p2){
                return p1.getName().compareTo(p2.getName());
            }
        });
        System.out.println("排序成功");
        display();
        }

}
