package com.lucas.javase.mybatis.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Log log=LogFactory.getLog(App.class);
        
        log.info("日志--->org.apache.commons.logging.Log");
    }
}