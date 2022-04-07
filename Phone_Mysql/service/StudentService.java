package service;

import entity.Student;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Komorebi
 * @since 2021.11.28.15:31
 */
public class StudentService {
    public int init(String filepath,List<Student> students){
        File file = new File(filepath);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        ObjectOutputStream objectOutputStream = null;
        int count=0;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            for(Student s:students){
                objectOutputStream.writeObject(s);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(objectOutputStream != null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    public void showAll(String filepath,int count){
        ObjectInputStream objectInputStream = null;
        List<Student> students = new ArrayList<Student>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filepath));
            for(int i=0;i<count;i++){
                students.add((Student)objectInputStream.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("学号\t姓名\t年龄\t性别\t状态\t\t成绩\t专业");
        for(Student s:students){
            if(s != null)
                System.out.println(s);
        }
        System.out.println();
    }

    public int add(String filepath,Student student,int count){
        File file = new File(filepath);
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filepath, true);
            if (file.length() < 1) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } else {
                objectOutputStream = new ObjectAppendOutputStream(fileOutputStream);
            }
            objectOutputStream.writeObject(student);
            count ++;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    public int update(String filepath,List<Student> students) {
        ObjectOutputStream objectOutputStream = null;
        int count = 0;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
            for (Student s : students) {
                objectOutputStream.writeObject(s);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return count;
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

