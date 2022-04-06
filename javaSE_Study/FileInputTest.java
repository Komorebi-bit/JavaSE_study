/**
 * @author Komorebi
 * @since 2021.08.11.20:36
 * 文件输入输出: FileInputStream()字节方式输入,一般用来处理图片,声音,图像;
 * InputStreamReader()字符方式输入
 */

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileInputTest {
    public static String ReadFileByByte(String path) throws FileNotFoundException {
        File file = new File(path);
        StringBuffer s = new StringBuffer();
        if (!file.exists() || !file.isFile()) {
            System.out.println("This file is not exists");
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] temp = new byte[1024];
        try {
            while (fileInputStream.read(temp) != -1) {
                s.append(new String(temp));
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    public static String ReadFileByChar(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("This file is not exists");
            return null;
        }
        StringBuffer s = new StringBuffer();
        try {
            char[] temp = new char[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            while (inputStreamReader.read(temp) != -1) {
                s.append(new String(temp));

            }
            fileInputStream.close();
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("E:/JavaFile/心理健康常识.txt");
        if (!file.exists()) {
            System.out.println(file.createNewFile());
        }
        System.out.println(":" + ReadFileByByte("E:/JavaFile/心理健康常识.txt"));
        System.out.println(":" + ReadFileByChar("E:/JavaFile/心理健康常识.txt"));
    }
}
