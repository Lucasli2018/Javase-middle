package com.lucas.javase.mybatis.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lucas.javase.jdbc.demo.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
        System.err.println("写一个错误error");
        System.out.println("日志 org.apache.commons.logging.Log");
        System.out.println();
        Log log=LogFactory.getLog(App.class);
        
        log.info("日志 org.apache.commons.logging.Log");
        log.error("写一个错误error");
        Person p=new Person();
        p.setName("lucas");
        log.info(p);
    }
}
