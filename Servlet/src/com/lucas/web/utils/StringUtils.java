package com.lucas.web.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 工具类
 * @author 50632
 *
 */
public class StringUtils {
	/**
	 * 获取输入参数
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getParameters(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			map.put(key, request.getParameter(key));
		}
		return map;
	}

	/**
	 * 输信息出到页面
	 * @param response
	 * @param object
	 */
	public static void writeObject(HttpServletResponse response, Object object) {
		PrintWriter writer = null;
		response.setContentType("text/html;charset=utf-8");
		try {
			writer = response.getWriter();
			writer.println(object);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			writer.flush();
			writer.close();
		}
	}
}
