import javax.swing.*;
import java.io.*;

/**
 * @author Komorebi
 * @since 2022.04.27.15:18
 *
 * 目录的拷贝
 */
public class CopyDirectory {
    public static void main(String[] args) {
        //拷贝源
        File srcFile = new File("E:\\7-Zip");
        //拷贝目标
        File destFile = new File("D:\\a\\b");
        //拷贝方法
        copyDir(srcFile,destFile);
    }

    private static void copyDir(File srcFile, File destFile) {
        if(srcFile.isFile()){
            FileInputStream in = null;
            FileOutputStream out = null;

            try {
                in = new FileInputStream(srcFile);
                String path = (destFile.getAbsolutePath().endsWith("\\")? destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcFile.getAbsolutePath().substring(3);
                out = new FileOutputStream(path);
                byte[] bytes = new byte[1024*1024];
                int readCount = 0;
                while((readCount=in.read(bytes)) != -1){
                    out.write(bytes,0,readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        File[] files = srcFile.listFiles();
        for (File file:files) {
            if(file.isDirectory()){
                String srcDir = file.getAbsolutePath();
                String destDir = (destFile.getAbsolutePath().endsWith("\\")? destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\")+srcDir.substring(3);
                //System.out.println(destDir);
                File newFile = new File(destDir);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }
            }
            copyDir(file,destFile);
        }
    }
}
