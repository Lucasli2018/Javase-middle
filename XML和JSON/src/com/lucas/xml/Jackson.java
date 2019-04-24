package com.lucas.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Jackson {

	public static void main(String[] args) {
		try {
			//jacksonBean2XML();
			jacksonXML2Bean();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * POJO 转为XML
	 * 
	 * @throws JsonProcessingException
	 */
	public static void jacksonBean2XML() throws JsonProcessingException{
//		JacksonXmlModule module = new JacksonXmlModule();
//		module.setDefaultUseWrapper(false);
		
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDefaultUseWrapper(false);
		User user=new User(1,"lucas","nan","2019-10-01","上海");
		String xml=xmlMapper.writeValueAsString(user);
		System.out.println(xml);
	}
	
	public static void jacksonXML2Bean() throws JsonParseException, JsonMappingException, IOException{
//		JacksonXmlModule module = new JacksonXmlModule();
//		module.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDefaultUseWrapper(false);
		//自动忽略无法对应pojo的字段
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		User user=xmlMapper.readValue("<User><id>1</id><username>lucas</username><sex>nan</sex><birthday>2019-10-01</birthday><address>上海</address></User>", User.class);
		System.out.println(user);
	}
	

}
