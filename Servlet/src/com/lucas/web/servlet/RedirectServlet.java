package com.lucas.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucas.web.utils.StringUtils;

public class RedirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//StringUtils.writeObject(resp, "<h1 color='red'>服务器返回信息：</h1>");
		System.out.println("页面跳转...");
		resp.sendRedirect("login.html");//跳转到指定页面，不一定局限于web应用中，如：response.sendRedirect("http://www.baidu.com")
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
