package file;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Komorebi
 * @since 2021.12.02.16:47
 */
public class FileRandom {
    public static void main(String[] args){
        DataInputStream dataInputStream=null;
        DataOutputStream dataOutputStream=null;
        Random random = new Random();
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("out.dat"));
            int count=100;
            while(count!=0){
                dataOutputStream.writeInt(random.nextInt(1000));
                count--;
            }
            dataOutputStream.flush();

            dataInputStream = new DataInputStream(new FileInputStream("out.dat"));
            int[] arr = new int[100];
            for(int i=0;i<100;i++){
                arr[i]=dataInputStream.readInt();
            }
            Arrays.sort(arr);
            for(int i=0;i<100;i++){
                if(i%5==0){
                    System.out.println();
                }
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                dataOutputStream.close();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
