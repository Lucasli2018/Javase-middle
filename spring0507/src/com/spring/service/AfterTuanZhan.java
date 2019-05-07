package com.spring.service;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import com.spring.bean.Luna;

/**
 * Notice 定义一个团战结束后的类 - 团战之后
 * @author Administrator
 */
public class AfterTuanZhan implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
        System.out.print(this.getClass().getName() + " -- ");
        Luna luna = new Luna();
        luna.setHeroName("露娜");
        luna.setType("战士/法师");
        luna.setDescription("月光女神");
        luna.say("进攻敌方防御塔！");
    }
    
}
