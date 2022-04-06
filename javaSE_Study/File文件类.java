/**
 * @author Komorebi
 * @since 2021.08.09.21:41
 * 1.Java中新建或者删除一个文件,文件夹以及createNewFile(),delete(),mkdirs()函数的使用
 * 2.判断文件的函数:exists(),isFile(),isAbsolute(),isDirectory(),canRead(),canWrite(),isHidden()
 * 3.文件属性函数:lastModified(),length(),list(),listFiles(),renameTo(),
 * getName(),getParent(),getPath(),getAbsolutePath(),delete()
 * 4.文件输入输出: FileInputStream()字节方式输入,一般用来处理图片,声音,图像,InputStreamReader()字符方式输入
 */

import java.io.File;
import java.util.Date;

public class File文件类 {
    //删除文件夹函数
    //删除文件夹须先判断是否有子文件夹及文件,若有须先删除子文件夹,子文件
    public static void deleteFile(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            return;
        } else if (dir.isFile()) {
            dir.delete();
        } else {
            File[] files = dir.listFiles();
            for (File myfile : files) {
                System.out.println("\t:" + myfile.getAbsolutePath());
                deleteFile(myfile.getAbsolutePath());
            }
            dir.delete();
        }
    }

    public static void main(String[] args) {
        File file = new File("E:/JavaFile/file.txt");
        File directory = new File("E:/JavaFile/k");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        if (!file.exists()) {
            try {
                System.out.println(file.createNewFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //创建一个file.txt文件,通过exists()来判断文件是否已经存在,如果文件不存在调用createNewFile(),返回一个
        //boolean值,如果指定的文件不存在并成功地创建,则返回true,如果指定的文件已经存在,则返回false

        if (!directory.exists()) {
            System.out.println(directory.mkdir());
        }
        //创建文件夹,如果指定的文件夹不存在可以通过mkdir(),mkdirs()来创建文件夹
        //mkdir(),mkdirs()都返回一个Boolean值,如果指定的文件夹不存在并且通过mkdir(),mkdirs()创建成功
        //则返回true,否则返回false
        //如果新建的文件目录的上级目录不存在则mkdir()会报异常不能成功创建文件夹,
        //而mkdirs()会将目录与上级目录一起创建
        file.setReadable(true);
        file.setWritable(true);
        System.out.println("file.txt  isFile: " + file.isFile() + "\tisDirectory(): "
                + file.isDirectory() + "\tcanRead: " + file.canRead() + "\tcanWrite: "
                + file.canWrite());
        System.out.println("directory  isFile: " + directory.isFile() + "\tisDirectory(): "
                + directory.isDirectory());
        //判断是否是文件,文件夹,是否可读,可写,是否隐藏.

        System.out.println("lastModified: " + new Date(file.lastModified()));
        //.lastModified()型返回一个long型的值,上面的例子通过Date函数将long型的值转化为日期
        System.out.println("length: " + file.length());
        System.out.println("getPath: " + file.getPath() + "\ngetAbsolutePath: " + file.getAbsolutePath());
        //获取路径
        System.out.println("getName: " + file.getName());
        //获取文件名
        File dir = new File("E:/JavaFile");
        if (!dir.exists()) {
            System.out.println("没有找到此文件夹");
            return;
        }
        try {
            String[] s1 = dir.list();
            File[] s2 = dir.listFiles();
            for (int i = 0; i < s1.length; i++) {
                System.out.println("\t:" + s1[i]);
            }
            //目录下的文件名
            for (int j = 0; j < s2.length; j++) {
                System.out.println("\t:" + s2[j]);
            }
            //目录下的文件名(包括路径)
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        System.out.println("--------------");
        //file.delete();
        //删除指定文件
        //deleteFile("E:/JavaFile");
        //删除指定路径文件夹

    }
}
