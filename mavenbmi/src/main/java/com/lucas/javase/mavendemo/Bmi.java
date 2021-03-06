package com.lucas.javase.mavendemo;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hello world!
 *
 */
public class Bmi 
{
	static final Log log=LogFactory.getLog(Bmi.class);
    public static void main( String[] args ) throws InterruptedException
    {
    	System.out.println("计算bmi...");
    	System.out.println( "bmi指数=体重（kg）/身高（m）的平方" );
    	
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您的身高（m）：");
        double h=Double.parseDouble(scanner.nextLine());
        double bw=(h*100-80)*0.7;
        System.out.println("男性：(身高cm－80)×70﹪=标准体重");
        System.out.println(String.format("男性标准体重%.2f kg", bw));
        System.out.println("请输入您的体重（kg）：");
        double w=Double.parseDouble(scanner.nextLine()) ;
        double bmi=w/(h*h);
        System.out.println(String.format("bmi指数%.2f", bmi));
        String info=String.format("您的bmi指数：bmi指数=%.2f（kg）/%.2f（m）的平方=%.2f", w,h,bmi);
        log.info(info);
        scanner.close();
    }
    
}
