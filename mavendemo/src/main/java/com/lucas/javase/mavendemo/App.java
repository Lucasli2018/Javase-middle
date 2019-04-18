package com.lucas.javase.mavendemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	static final Log log=LogFactory.getLog(App.class);
    public static void main( String[] args ) throws InterruptedException
    {
    	log.info("记录日志...");
        log.info( "Hello World!" );
        CountThread.count();
        System.out.println("over");
        
        new Bmi().main(null);
    }
    
    public static int sum(int a,int b){
    	return a+b;
    }
}
