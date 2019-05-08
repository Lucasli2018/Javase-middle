package com.lucas.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucas.web.utils.StringUtils;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get:");
		Map<String, Object> parameters = StringUtils.getParameters(req);
		System.out.print("获取输入参数 ： ");
		System.out.println(parameters);
		if("".equals(parameters.get("account"))){
			System.out.println("用户名不能为空！");
			StringUtils.writeObject(resp, "{\"status\":\"0\",\"message\":\"用户名不能为空！\"}");
			return;
		}
		if("".equals(parameters.get("password"))){
			System.out.println("密码不能为空！");
			StringUtils.writeObject(resp, "{\"status\":\"0\",\"message\":\"密码不能为空！\"}");
			return;
		}
		if("admin".equals(parameters.get("account"))&&"123".equals(parameters.get("password"))){
			System.out.println("登录成功！");
			StringUtils.writeObject(resp, "{\"status\":\"0\",\"message\":\"登录成功！\"}");
			return;
		}
		System.out.println("用户名或密码错误！");
		StringUtils.writeObject(resp, "{\"status\":\"0\",\"message\":\"用户名或密码错误！\"}");
		//resp.sendRedirect("login.html");//跳转到指定页面，不一定局限于web应用中，如：response.sendRedirect("http://www.baidu.com")
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post:");
		doGet(req, resp);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("进入 服务器...");
	}

}
