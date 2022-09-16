package refect;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Komorebi
 * @since 2022.07.24.11:30
 */
public class App {
    public static void main(String[] args) throws Exception{
        Class<Book> c = Book.class;
        Constructor<Book> constructor = c.getConstructor();
        System.out.println(constructor);
        Book book = constructor.newInstance();
        System.out.println(book);
        book.setName("koo");
        System.out.println(book);

        Field name = c.getDeclaredField("name");
        System.out.println(name);
        name.setAccessible(true);
        name.set(book,"ko");
        System.out.println(book);
    }
}
