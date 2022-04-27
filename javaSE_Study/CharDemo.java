import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Komorebi
 * @since 2022.04.26.19:13
 */
public class CharDemo {
    public static void main(String[] args) throws IOException {
        char c = '中';
        //char占2个字节或者4个字节
        System.out.println(c);
        String s = "中国a";
        System.out.println(s.getBytes().length);
        System.out.println(s.getBytes(Charset.forName("gbk")).length);

        //FileInputStream in = new FileInputStream("a.txt");
        //in.close();

        /*FileWriter fw = new FileWriter("character.txt");
        for(int i=0;i<1024*1024;i++){
            fw.write(i);

            if(i%1000 == 0){
                fw.write("\n");
                fw.write("\n");
                String s = String.valueOf(i);
                fw.write(s);

            }
            fw.flush();
        }
        //int i =97;
        //fw.write(i);
        fw.flush();
        fw.close();*/
    }
}
