package SchoolSystem;

public interface Printer {
    public void print(String content);
}
class BWPrinter implements Printer{
    public void print(String content){
        System.out.print("黑白打印机开始打印: ");
        System.out.println(content);
    }
}
class ColourPrinter implements Printer{
    public void print(String content){
        System.out.print("彩色打印机开始打印: ");
        System.out.println(content);
    }
}
