package com.spring.web.servlet.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 字符串处理工具类
 * @author lucas
 *
 */
public class StringUtil {
	/**
	 * 对象是否为空
	 * @param o
	 * @return
	 */
	public static boolean isEmpty(Object o){
		if(o==null)return true;
		if("".equals(o.toString()))return true;
		return false;
	}
	/**
	 * 对象不为空
	 * @param o
	 * @return
	 */
	public static boolean isNotEmpty(Object o){
		return !isEmpty(o);
	}
	
	public static void writeObject(HttpServletResponse resp,Object o){
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			out = resp.getWriter();
			out.println(o);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.flush();
			out.close();
		}
	}
}
