package com.spring.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.spring.web.servlet.util.*;
public class LoginServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("进入 " +this.getClass().getName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String type=req.getParameter("type");
		
		System.out.println("用户登录...");
		System.out.println("开始存入map...");
		Map<String,Object> user=WebUtil.getParameters(req);
		
		System.out.println("存入map成功！");
		System.out.println(user);
		
		if(StringUtil.isEmpty(user.get("username"))){
			System.out.println("用户名不能为空！");
			StringUtil.writeObject(resp, "{\"errCode\":-1,\"errMsg\":\"用户名不能为空！\"}");
			return;
		}
		if(StringUtil.isEmpty(user.get("password"))){
			System.out.println("密码不能为空！");
			//StringUtil.writeObject(resp, "密码不能为空！");
			StringUtil.writeObject(resp, "{\"errCode\":-2,\"errMsg\":\"密码不能为空！\"}");
			return;
		}
		
		System.out.println("登录成功!");
		StringUtil.writeObject(resp,"{\"errCode\":0,\"errMsg\":\"登录成功!\"}");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
}
