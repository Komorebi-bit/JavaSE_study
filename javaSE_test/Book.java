/**
 * @author Komorebi
 * @since 2021.11.25.14:50
 */
import java.util.*;
public class Book {
    private String name;
    private int pages;

    public Book(){}
    public Book(String name,int pages){
        this.name=name;
        this.pages=pages;
    }
    @Override
    public String toString(){
        return "书名: "+name+'\t'+"页数: "+pages;
    }

    public static void main(String[] args){
        Map<String,Book> map = new HashMap<String,Book>();
        for(int i=1,j= 65;i<11;i++,j++){
            if(10==i){
                String s1 = "SA0",s2 = "SOFT_";
                s1+=i;
                s2+=(char) j;
                map.put(s1,new Book(s2,i*2-1));
                continue;
            }
            String s1 ="SA00", s2 ="SOFT_";
            s1+=i;
            s2+=(char) j;
            map.put(s1,new Book(s2,i*2-1));
        }
        Set<Map.Entry<String,Book>> set = map.entrySet();
        for(Map.Entry<String,Book> entry: set){
            System.out.println("编号: "+entry.getKey()+'\t'+entry.getValue());
        }
        //StringBuilder ss=new StringBuilder("00");
        //map.put(ss,new Book());
        //System.out.println(map.containsKey(ss));
        System.out.println("------------------------------");
        System.out.println("编号: SA008"+'\t'+map.get("SA008"));

    }
}
