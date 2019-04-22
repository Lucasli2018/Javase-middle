package com.lucas.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XML {
	
	static final String URI="http://rss.sina.com.cn/tech/internet/home28.xml";
	static String uri="UserMapper.xml";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		try{
			//dom();
			sax();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * SAX操作XML
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void sax() throws ParserConfigurationException, SAXException, IOException{
		//SAXParserFactory也是抽象类
		SAXParserFactory instance = SAXParserFactory.newInstance();
		SAXParser saxParser = instance.newSAXParser();
		saxParser.parse(uri, new SaxHandler());
	}
	
	/**
	 * DOM操作XML
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void dom() throws ParserConfigurationException, SAXException, IOException{
		//DocumentBuilderFactory是抽象类，不能实例化new
		DocumentBuilderFactory instance = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = instance.newDocumentBuilder();
		
		Document document = builder.parse(uri);
		print(document,0);
	}

	private static void print(Node document, int i) {
		for (int j = 0; j < i; j++) {
			System.out.print(" ");
		}
		switch (document.getNodeType()) {
			case Node.DOCUMENT_NODE:
				System.out.println("DOCUMENT_NODE: "+document.getNodeName());
				break;
			case Node.ELEMENT_NODE:
				System.out.println("ELEMENT_NODE: "+document.getNodeName());
				break;
			case Node.TEXT_NODE:
				System.out.println("TEXT_NODE: "+document.getNodeName()+"="+document.getNodeValue());
				break;
			case Node.ATTRIBUTE_NODE:
				System.out.println("ATTRIBUTE_NODE: "+document.getNodeName()+"="+document.getNodeValue());
				break;
			case Node.CDATA_SECTION_NODE:
				System.out.println("CDATA_SECTION_NODE: "+document.getNodeName()+"="+document.getNodeValue());
				break;
			case Node.COMMENT_NODE:
				System.out.println("COMMENT_NODE: "+document.getNodeName()+"="+document.getNodeValue());
				break;
			default:
				System.out.println("NODETYPE:"+document.getNodeType()+",NODEVALUE:"+document.getNodeValue());
				break;
		}
		for (Node child = document.getFirstChild(); child !=null; child=child.getNextSibling()) {
			print(child,i+1);
		}
	}

}
