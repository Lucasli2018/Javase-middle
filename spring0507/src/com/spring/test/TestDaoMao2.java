package com.spring.test;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bean.CuiHua;
import com.spring.bean.DaMao;
import com.spring.bean.GirlFriend;
 
public class TestDaoMao2 {
     
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("GirlFriends.xml");
        DaMao daMao = (DaMao) context.getBean("DaMao");
         
        //看一下大毛的女朋友喜欢做什么？
        System.out.println(daMao.getGirlFriend().getHobby());
         
    }
}