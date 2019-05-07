package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//使用@Controller注解表示这个类是一个Handler
@Controller
public class HelloController {

  //@RequestMapping注解括号里面的表示访问的URL
  @RequestMapping("hello")
  public ModelAndView hello(){
      ModelAndView modelView = new ModelAndView();
      //类似于 request.setAttribute()
      modelView.addObject("name","张三");
      //配置返回的视图名，由于我们在springmvc.xml中配置了前缀和后缀，这里直接写视图名就好
      modelView.setViewName("index");
      //modelView.setViewName("/WEB-INF/view/index.jsp");
      return modelView;
  }

}
