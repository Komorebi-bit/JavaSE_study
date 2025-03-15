import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Komorebi
 * @since 2022.12.18.9:21
 */
public class Book {

    private String name;
    private int price;

    public Book() {
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }

    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Java开发", 90));
        list.add(new Book("Python数据分析", 100));
        list.add(new Book("Spark大数据", 110));

        for (Book b : list) {
            System.out.println(b);
        }

        Iterator<Book> it = list.listIterator();
        while (it.hasNext()) {
            if (it.next().getPrice() < 100) {
                it.remove();
            }
        }
        
    }
}
