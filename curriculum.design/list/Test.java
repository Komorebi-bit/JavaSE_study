package list;

import java.io.*;

/**
 * @author Komorebi
 * @since 2021.12.03.13:33
 */
public class Test implements Serializable{
    private String name;
    private int age;
    static int count=0;
    static String path = "e:/t.txt";
    public Test(String name,int age){
        this.name=name;
        this.age=age;
    }
    public static void main(String[] args){
        add(new Test("aa",11));
        read();
        add(new Test("bb",12));
        read();
    }
    public static void add(Test t){
        ObjectOutputStream objectOutputStream = null;
        try {
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(path, true);
            if (file.length() < 1) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } else {
                objectOutputStream = new ObjectAppendOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(t);
            count++;
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(objectOutputStream!=null)
                    objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void read(){
        ObjectInputStream objectInputStream = null;
        try {
            Test test;

            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            for(int i=0;i<count;i++){
                test=(Test)objectInputStream.readObject();
                System.out.println(test);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                if(objectInputStream!=null)
                    objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String toString(){
        return name+"  "+age;
    }
}

class ObjectAppendOutputStream extends ObjectOutputStream {

    public ObjectAppendOutputStream() throws IOException {
        super();
    }

    public ObjectAppendOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        return;
    }
}
