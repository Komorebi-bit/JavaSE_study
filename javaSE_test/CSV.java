/**
 * @author Komorebi
 * @since 2021.11.17.11:11
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class CSV {
    public static void main(String[] args){
        String file = "F:\\stock.csv";
        List<Double> list = new ArrayList<Double>();
        BigDecimal max= BigDecimal.valueOf(0.0),min= BigDecimal.valueOf(1000.0),value;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");
                String last = item[item.length-1];
                list.add(Double.parseDouble(last));
                value = new BigDecimal(last);
                if(max.compareTo(value)<0){
                    max = value;
                }
                if(min.compareTo(value)>0){
                    min = value;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(max+" "+min);
        int i =-1;
        double[] arr = new double[list.size()];
        for(double a:list){
            BigDecimal v = new BigDecimal(a);
            arr[++i] = v.subtract(min).divide(max.subtract(min),4,BigDecimal.ROUND_HALF_UP).doubleValue();
            //System.out.println(arr[i]);
        }
        int length = arr.length;
        DecimalFormat df = new DecimalFormat("0.0000");
        for(i=0;i<length-5;i++){
            for(int j=i;j<i+5;j++){
                System.out.print(df.format(arr[j])+"  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for(i=5;i<length;i++){
            System.out.print(df.format(arr[i])+"  ");
        }
        System.out.println();
    }
}
