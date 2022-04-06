/**
 * author Komorebi
 * 日期格式化(DateFormat类,SimpleDateFormat类)
 * SimpleDateFormat:
 * 字母      日期或时间元素              表示                  示例
 * G        Era 标志符                 Text                  AD
 * y        年                        Year               1996; 96
 * M        年中的月份                  Month           July; Jul; 07
 * w        年中的周数                  Number                27
 * W        月份中的周数                Number                 2
 * D        年中的天数                  Number                189
 * d        月份中的天数                Number                 10
 * F        月份中的星期                Number                 2
 * E        星期中的天数                Text              Tuesday; Tue
 * a        Am/pm 标记                Text                    PM
 * H        一天中的小时数(0-23)        Number                  0
 * k        一天中的小时数(1-24)        Number                  24
 * K        am/pm 中的小时数(0-11)     Number                  0
 * h        am/pm 中的小时数(1-12)     Number                  12
 *m         小时中的分钟数              Number                  30
 *s         分钟中的秒数                Number                 55
 *S         毫秒数                     Number                 978
 *z         时区                      General time zone   Pacific Standard Time; PST; GMT-08:00
 *Z         时区                      RFC 822 time zone     -0800
 *
 *DateFormat:
 * SHORT:       完全为数字,如 12.5.10 或 5:30pm.
 * MEDIUM:      较长,如 May 10,2016.
 * LONG:        更长,如 May 12,2016 或 11:15:32am.
 * FULL:        是完全指定,如 Tuesday、May 10、2012 AD 或 11:l5:42am CST.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class 日期及格式化类 {
    public static void main(String[] args){
        Date date = new Date();
        Date date1 = new Date();
        System.out.println(date);
        System.out.println("------------------------");
        //输出format方法默认格式
        SimpleDateFormat sdf = new SimpleDateFormat();
        String str = sdf.format(date);
        System.out.println(str);
        System.out.println("------------------------");
        //自定义格式输出
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = sdf1.format(date);
        System.out.println(str1);
        System.out.println("------------------------");
        try {
            //把字符串转化成日期
            String str2 = "1999-2-15 23:14:59";
            date1 = sdf1.parse(str2);
            System.out.println(sdf1.format(date1));
            System.out.println("------------------------");
            //将日期转化成数字(毫秒)
            long ms = date.getTime();
            System.out.println(ms);
            System.out.println("------------------------");
            //将数字转化成日期
            date.setTime(ms+24*60*60*1000);
            System.out.println(sdf1.format(date));

        }catch(ParseException e){
            e.printStackTrace();
        }
    }
}
