package com.spring.service;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.spring.bean.Luna;

/**
 * Notice 定义一个通知打团的信号 - 团战之前
 * @author Administrator
 *
 */
public class BeforeTuanZhan implements MethodBeforeAdvice{

    @Override
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.print(this.getClass().getName() + " -- ");
        Luna luna = new Luna();
        luna.setHeroName("露娜");
        luna.setType("战士/法师");
        luna.setDescription("月光女神");
        luna.say("等我集合打团！");
    }
    
}