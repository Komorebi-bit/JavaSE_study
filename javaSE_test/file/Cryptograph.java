package file;

import java.io.*;
import java.util.Scanner;

/**
 * @author Komorebi
 * @since 2021.12.02.20:40
 */

public class Cryptograph {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("1.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("2.txt"));

            String s1 ;
            int len=key.length();
            while((s1= bufferedReader.readLine())!=null){
                String s2="";
                for(int i=0,j=0; i<s1.length(); i++,j++){
                    if(j>=len){
                        j=j%len;
                    }
                    char c = (char)(s1.charAt(i)^key.charAt(j));
                    s2 += String.valueOf(c);
                }
                bufferedWriter.write(s2);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                bufferedReader.close();
                bufferedWriter.close();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
