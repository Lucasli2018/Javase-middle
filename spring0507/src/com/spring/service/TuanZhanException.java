package com.spring.service;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

import com.spring.bean.Luna;

/**
 * 定义一个团战异常类，万一出现情况就进入这个类
 * @author Administrator
 *
 */
public class TuanZhanException implements ThrowsAdvice {
    
    //该方法会在露娜团战出现异常后自动执行
    public void afterThrowing(Method method, Object[] args, 
            Object target, Exception ex){
        System.out.print(this.getClass().getName() + " -- ");
        Luna luna = new Luna();
        luna.run();
    }
}
