package file;

import java.io.*;

/**
 * @author Komorebi
 * @since 2021.12.02.17:37
 */
public class Book implements Serializable {
    private int id;
    private String name;
    private String author;
    private float price;

    public Book(){}
    public Book(int id,String name,String author,float price){
        this.id=id;
        this.name=name;
        this.author=author;
        this.price=price;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }
    public void setPrice(float price){
        this.price=price;
    }
    public float getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return "id: "+id+" name: "+name+" author: "+author+" price: "+price;
    }

    public static void main(String[] args){
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("book.dat"));
            objectOutputStream.writeObject(new Book(2001001,"平凡的世界","路遥",78.9f));
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(new FileInputStream("book.dat"));
            Object book=objectInputStream.readObject();
            if(book!=null)
                System.out.println((Book)book);

        } catch (IOException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        finally{
            try {
                objectOutputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
