package com.lucas.baiduMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaiduMap {

	static final String ak="pb8TgeddcRmfC6ToK4STjYWChmHPMZDj";
	static final String baiduApiUrl="http://api.map.baidu.com/geocoder/v2/";
	public static void main(String[] args) {
		String json=null;
		try {
			
			json=getCoordinate("北京市海淀区上地十街10号");
			json=getCoordinate("上海市闸北区西藏南路289号");
			json=getAddress("121.475324", "31.254511");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(json);
	}
	
	public static String getAddress(String lng,String lat) throws IOException{
		String url=baiduApiUrl+"?output=json&ak="+ak+"&location="+lat+","+lng;
		URL myUrl=null;
		String city="";
		String gx="";
		URLConnection httpsConn=null;
		//创建连接
		try {
			myUrl=new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader insr=null;
		BufferedReader br=null;
		StringBuffer sb=new StringBuffer();
		try {
			httpsConn=myUrl.openConnection();//不使用代理
			if(httpsConn!=null){
				insr=new InputStreamReader(httpsConn.getInputStream(),"UTF-8");
				br=new BufferedReader(insr);
				String data=null;
				while((data=br.readLine())!=null){
					sb.append(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(insr!=null){
				insr.close();
			}
			if (br!=null) {
				br.close();
			}
		}
		System.out.println(lng+","+lat+"---->"+sb);
		return sb.toString();
	}
	
	/**
	 * 获取经纬度 
	 * @param addr 地址 eg:北京市海淀区上地十街10号
	 * @return {"status":0,"result":{"location":{"lng":116.30694088743103,"lat":40.057338773497537},"precise":1,"confidence":80,"comprehension":100,"level":"道路"}}
	 * @throws IOException
	 */
	public static String getCoordinate(String addr) throws IOException{
		
		String lng=null;//经度
		String lat=null;//纬度
		String address=null;//地址
		//编码
		try {
			address=URLEncoder.encode(addr,StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(address);
		
		String url=baiduApiUrl+"?output=json&ak="+ak+"&address="+address;
		URL myUrl=null;
		URLConnection httpsConn=null;
		//创建连接
		try {
			myUrl=new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader insr=null;
		BufferedReader br=null;
		StringBuffer sb=new StringBuffer();
		try {
			httpsConn=myUrl.openConnection();
			if(httpsConn!=null){
				insr=new InputStreamReader(httpsConn.getInputStream(),"UTF-8");
				br=new BufferedReader(insr);
				String data=null;
				
				while((data=br.readLine())!=null){
					sb.append(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(insr!=null){
				insr.close();
			}
			if(br!=null){
				br.close();
			}
		}
		System.out.println(addr+"---->"+sb);
		return sb.toString();
	}
}
