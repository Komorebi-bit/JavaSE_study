/**
 * @author Komorebi
 * 字符串练习
 * 1.String字符串是不可变的.
 * 2.在修改字符串操作比较多的时候用StringBuilder(线程不安全)或StringBuffer(线程安全).
 * append(xxx)      字符串拼接
 * delete(int start, int end)       删除指定位置的内容
 * replace(int start, int end, String str)      把[start,end)位置替换成str
 * insert(int offset,xxx)       指定位置插入xxx
 * reverse()    把当前字符序列逆转
 * indexOf(String)   substring(int,int)  length()  charAt(int)  setCharAt(int, char)
 * 在要求线程安全的情况下用StringBuffer
 * 在不要求线程安全的情况下用StringBuilder
 * <p>
 * String方法
 * endWith(String) 判断是否以指定内容结尾
 * public int length()
 * String toLowerCase()     所有字符转化为小写
 * String toUpperCase()     所有字符转化为大写
 * public String concat(String str)  连接
 * public char charAt(int index)   获取指定位置的单个字符(从0开始)
 * public int indexOf(String str)    查找参数字符串在本字符串中首次出现的位置, 没有返回-1
 * public String substring(int index)    截取从参数位置一直到字符串末尾，返回新字符串
 * public String substring(int begin, int end) 截取从begin开始，一直到end结束，中间的字符串
 * public char[] toCharArray()     将当前字符串拆分成为字符数组作为返回值 String->char[]
 * String str = new String(arr)     char[]->String
 * public byte[] getBytes()   编码String->byte[]   获得当前字符串底层的字节数组
 * byte[] byteArray = str.getBytes();  使用默认字符集进行编码
 * str.getBytes("gbk");     使用gbk字符集进行编码
 * byte[]->String 解码
 * String str = new String(byteArray);
 * String str = new String(byteArray,"gbk");
 * public String replace(CharSequence oldString, CharSequence newString)
 * 将所有出现的老字符串替换成为新的字符串，返回替换之后的结果新字符串
 * public String[] split(String regex)   按照参数的规则，将字符串切分成为若干部分
 * split方法的参数其实是一个“正则表达式”
 * 转义必须写"\\."（两个反斜杠）
 * 如果split失败则返回一个空字符串数组，比如split(".")就会失败，正则不明确，程序不知道怎么切了
 * 字符串比较
 * == 比较两个字符串在内存中的地址
 * equals 比较两个字符串的值
 * String->基本类，包装类       .parseXxx(str)
 * 基本类，包装类->String       .valueOf(xxx)或直接+"";
 * <p>
 * <p>
 * java11
 * .isBlank();      判断字符串是否为空白
 * .strip();        去除首尾空白
 * .stripTrailing();    去除尾部空格
 * .stripLeading();     去除首部空格
 * .repeat(int);        复制字符串n遍
 * .lines().count();    行数统计
 */

import java.util.Scanner;
import java.lang.String;

public class String类 {
    public static void main(String[] args) {

    }
}
