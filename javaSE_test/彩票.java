/**
 * @author Komorebi
 * @since 2021.09.16.19:43
 */
import java.util.*;
public class 彩票 {
    public static void main(String[] args) {
        Random random = new Random();


        Set set = new TreeSet<Integer>();
        while(set.size()<7){
            set.add((int)random.nextInt(30)+1);
        }
        for(Object i:set){
            System.out.print(i+" ");
        }
    /*
        int[] numArray = new int[30];
        for(int i=0;i<numArray.length;i++){
            numArray[i]=i+1;
        }
        int randomNum = numArray.length-1;
        int[] array=new int[7];
        for(int i=0;i<array.length;i++){
            int index = random.nextInt(randomNum--);
            array[i]= numArray[index];
            int temp=numArray[index];
            numArray[index]=numArray[randomNum];
            numArray[randomNum]=temp;
        }
        Arrays.sort(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }


     */
  }
}
