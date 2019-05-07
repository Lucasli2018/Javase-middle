package com.spring.bean;

public class Luna extends Hero{
    
    /**
     * 秀操作
     */
    public void operation(){
        System.out.println("看我月下无限连！");
    }
    
    /**
     * 跑路
     */
    public void run(){
        System.out.println("我操，大空了，赶紧跑！");
    }
    
    /**
     * 发信息
     * @param str
     */
    public void say(String str){
        System.out.println(str);
    }
    
}