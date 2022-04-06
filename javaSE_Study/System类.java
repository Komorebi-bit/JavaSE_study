/**
 * author Komorebi
 * System.arraycopy(a,b,c,d,e)
 * a是被复制的数组,b是复制的起始位置,c是复制到的数组,d是复制到这个数组的起始位置,e是复制到这个数组的结束位置.
 * System.currentTimeMillis() 返回毫秒数 和Date类中的getTime方法一样
 * getProperty          获取系统属性
 * 常用的有:
 * os.arch	            操作系统的架构
 * os.version	        操作系统的版本
 * file.separator	    文件分隔符（在 UNIX 系统中是“/”）
 * path.separator	    路径分隔符（在 UNIX 系统中是“:”）
 * line.separator	    行分隔符（在 UNIX 系统中是“/n”）
 * user.name	        用户的账户名称
 * user.home	        用户的主目录
 * user.dir	            用户的当前工作目录
 * java.version	        Java 运行时环境版本
 * java.vendor	        Java 运行时环境供应商
 * java.vendor.url	    Java 供应商的 URL
 * java.home	        Java 安装目录
 * java.vm.specification.version	    Java 虚拟机规范版本
 * java.vm.specification.vendor	        Java 虚拟机规范供应商
 * java.vm.specification.name	        Java 虚拟机规范名称
 * java.vm.version	            Java 虚拟机实现版本
 * java.vm.vendor	            Java 虚拟机实现供应商
 * java.vm.name	                Java 虚拟机实现名称
 * java.specification.version	    Java 运行时环境规范版本
 * java.specification.vendor	    Java 运行时环境规范供应商
 * java.specification.name	        Java 运行时环境规范名称
 * java.class.version	            Java 类格式版本号
 * java.class.path	                Java 类路径
 * java.library.path	加载库时搜索的路径列表
 * java.io.tmpdir	    默认的临时文件路径
 * java.compiler	    要使用的 JIT 编译器的名称
 * java.ext.dirs	    一个或多个扩展目录的路径
 *
 * gc  Java的垃圾回收器,不需要我们调用
 * exit(int) 方法是终止当前正在运行的java虚拟机
 * 参数是状态码.根据惯例,非0的状态码表示异常终止,0表是终止.而且,该方法永远不会正常返回.
 */
import java.lang.System;
public class System类 {
    public static void main(String[] args) {
        System.out.println("当前毫秒数: "+System.currentTimeMillis());
        //System.exit(0);
        System.out.println("------------------------------------------");
        System.out.println("操作系统的架构: "+System.getProperty("os.arch"));
        System.out.println("操作系统的版本: "+System.getProperty("os.version"));
        System.out.println("用户的账户名称: "+System.getProperty("user.name"));
        System.out.println("用户的主目录: "+System.getProperty("user.home"));
        System.out.println("用户的当前工作目录: "+System.getProperty("user.dir"));
        System.out.println("Java 运行时环境版本: "+System.getProperty("java.version"));
        System.out.println("Java 运行时环境供应商: "+System.getProperty("java.vendor"));
        System.out.println("Java 供应商的 URL: "+System.getProperty("java.vendor.url"));
        System.out.println("Java 安装目录: "+System.getProperty("java.home"));
        System.out.println("Java 虚拟机规范版本: "+System.getProperty("java.vm.specification.version"));
        System.out.println("Java 虚拟机规范供应商: "+System.getProperty("java.vm.specification.vendor"));
        System.out.println("Java 虚拟机规范名称: "+System.getProperty("java.vm.specification.name"));
        System.out.println("Java 虚拟机实现版本: "+System.getProperty("java.vm.version"));
        System.out.println("Java 虚拟机实现供应商: "+System.getProperty("java.vm.vendor"));
        System.out.println("Java 虚拟机实现名称: "+System.getProperty("java.vm.name"));
        System.out.println("Java 运行时环境规范版本: "+System.getProperty("java.specification.version"));
        System.out.println("Java 运行时环境规范供应商: "+System.getProperty("java.specification.vendor"));
        System.out.println("Java 运行时环境规范名称: "+System.getProperty("java.specification.name"));
        System.out.println("Java 类格式版本号: "+System.getProperty("java.class.version"));
        System.out.println("Java 类路径: "+System.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表: "+System.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径: "+System.getProperty("java.io.tmpdir"));
        System.out.println("要使用的 JIT 编译器的名称: "+System.getProperty("java.compiler"));
        System.out.println("一个或多个扩展目录的路径: "+System.getProperty("java.ext.dirs"));
        System.out.println("文件分隔符: "+System.getProperty("file.separator"));
        System.out.println("路径分隔符: "+System.getProperty("path.separator"));
        System.out.println("行分隔符: "+System.getProperty("line.separator"));

    }
}
