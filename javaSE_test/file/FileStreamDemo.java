package file;

import java.io.*;

/**
 * @author Komorebi
 * @since 2021.12.02.15:01
 */
public class FileStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        int c;
        try {
            fileInputStream = new FileInputStream("01.txt");
            fileOutputStream = new FileOutputStream("02.txt");
            while((c=fileInputStream.read())!=-1){
                fileOutputStream.write(c);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
