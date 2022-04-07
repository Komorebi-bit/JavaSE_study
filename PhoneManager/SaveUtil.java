/**
 * @author Komorebi
 * @since 2021.11.03.19:05
 */
import java.io.*;
public class SaveUtil {
    /**
     *  序列化，将对象转化为字节序列
     *  保存对象
     *  1.创建一个对象输出流
     *  2.通过对象输出流中的writeObject()方法写对象
     */
    private static String filepath="E:/phone.txt";

    public static void saveObject(Object object){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
            objectOutputStream.writeObject(object);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * 反序列化，将字节序列转化为对象
     * 读取对象
     * 1.创建一个对象输入流
     * 2.通过一个对象输入流中的readObject()方法读取对象
     */
    public static Object readObject(){
//        File file = new File(filepath);
//        if (file.exists()) {
//            try {
//                file.setReadable(false);
//                file.setWritable(false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        ObjectInputStream inputStream = null;
        FileInputStream fileInputStream = null;
        Object object = null;
        try {
            fileInputStream = new FileInputStream(filepath);
            if(fileInputStream.getChannel().size()==0){
                return null;
            }
            inputStream = new ObjectInputStream(fileInputStream);
            object = inputStream.readObject();
            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
