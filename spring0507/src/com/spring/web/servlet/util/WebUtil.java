package com.spring.web.servlet.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 工具类
 * @author lucas
 *
 */
public class WebUtil {
	public static Map<String,Object> getParameters(HttpServletRequest req){
		Map<String,Object> map=new HashMap<>();
		Enumeration<String> names = req.getParameterNames();
		while (names.hasMoreElements()) {
			String key=names.nextElement();	//获取key值
			String value=req.getParameter(key);	//获取对应的value值
			map.put(key, value);
		}
		return map;
	}
}
