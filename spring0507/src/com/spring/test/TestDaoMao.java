package com.spring.test;
 
import com.spring.bean.CuiHua;
import com.spring.bean.DaMao;
import com.spring.bean.GirlFriend;
 
public class TestDaoMao {
     
    public static void main(String[] args) {
        DaMao daMao = new DaMao();
         
        GirlFriend cuihua = new CuiHua();
        cuihua.setHobby("王者荣耀");
         
        daMao.setGirlFriend(cuihua);
         
        //看一下大毛的女朋友喜欢做什么？
        System.out.println(daMao.getGirlFriend().getHobby());
         
    }
}