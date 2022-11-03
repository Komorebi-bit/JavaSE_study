package com.log;

import java.io.IOException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Komorebi
 * @since 2022.09.23.12:19
 */
public class LogTest {

    @Test
    public void test1() throws IOException {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("com.log.LogDemo");
        //关掉默认日志打印方式
        logger.setUseParentHandlers(false);
        //创建控制台日志打印处理器
        java.util.logging.ConsoleHandler handler = new java.util.logging.ConsoleHandler();
        // 输出到文件中 相对/绝对路径
        java.util.logging.FileHandler handler2 = new java.util.logging.FileHandler("src/com.log/my.com.log",false);
        //创建日志格式化组件对象
        java.util.logging.SimpleFormatter formatter = new java.util.logging.SimpleFormatter();
        //在处理器中设置日志格式
        handler.setFormatter(formatter);
        handler2.setFormatter(formatter);
        //在记录器中添加处理器
        logger.addHandler(handler);
        logger.addHandler(handler2);
        //设置日志的打印级别
        //必须将日志记录器和处理器的级别统一设置
        logger.setLevel(java.util.logging.Level.ALL);
        handler.setLevel(java.util.logging.Level.CONFIG);
        handler2.setLevel(java.util.logging.Level.ALL);

        logger.severe("severe");
        logger.warning("warning");
        logger.log(java.util.logging.Level.INFO,"{0},{1}",new Object[]{1,2});
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    //log4j.properties 1.2版本
    @Test
    public void test2(){
        // LogLog.setInternalDebugging(true);

        /* org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogTest.class);

        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息"); */


    }

    //log4j.properties 1.2版本
    @Test
    public void test3(){
        //创建的logger对象，默认继承rootLogger
        //我们可以自定义logger，让其他logger来继承
        //如果根logger和自定义父logger配置位置不同，取并集
        //日志级别不同，按照自定的父logger级别输出
        /* org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogTest.class);

        logger.fatal("fatal信息");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息"); */
    }

    //log4j.properties 1.2版本
    //commons.logging 1.2版本
    //日志门面技术的好处：是面向接口的开发，不再依赖具体的实现类，减少代码的耦合，可以根据实际需求，灵活的切换日志框架
    @Test
    public void test4(){
        //有第三方库（例log4j）自动引入（log4j），没有就自动引入JUL
        /* org.apache.commons.logging.Log log= org.apache.commons.logging.LogFactory.getLog(LogTest.class);
        log.info("info"); */
    }

    //logback
    //trace,debug,info,warn,error
    @Test
    public void test5(){
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }

    @Test
    public void test6(){
        //在文件中默认是以追加日记的形式记录
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }

    @Test
    public void test7(){
        int i = 10;
        while(i>0) {
            Logger logger = LoggerFactory.getLogger(LogTest.class);
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
            i--;
        }
    }

    //异步 系统单独分配一个线程给日志打印
    @Test
    public void test8(){
        for(int i=0;i<50;i++) {
            Logger logger = LoggerFactory.getLogger(LogTest.class);
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
        System.out.println("1-------------");
        System.out.println("2-------------");
        System.out.println("3-------------");
        System.out.println("4-------------");
        System.out.println("5-------------");
    }

    //log4j 2
    @Test
    public void test9(){
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        // logger.fatal("");
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }

    @Test
    public void test10(){
        //AsyncAppender 的方式  导入disruptor.jar
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        for(int i=0;i<100;i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
        for (int i=0;i<20;i++){
            System.out.println("---------------");
        }
    }

    @Test
    public void test11(){
        //AsyncLogger 的方式全局异步  disruptor.jar  log4j2.component.properties
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        for(int i=0;i<100;i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
        for (int i=0;i<20;i++){
            System.out.println("---------------");
        }
    }

    @Test
    public void test12(){
        //AsyncLogger 的方式混合异步  disruptor.jar  注释掉这个文件log4j2.component.properties
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        for(int i=0;i<100;i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
        for (int i=0;i<20;i++){
            System.out.println("---------------");
        }
    }

    @Test
    public void test13(){
        // 日志拆分
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        for(int i=0;i<100;i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }

    }
}
